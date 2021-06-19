package automationPracticeTests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationPracticePages.ProductsCategoryNavigation;

public class WomanCategoryTests extends BaseTests {

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		successfulLogin();

	}

	@Test(priority = 0)
	public void addOneProduct() throws InterruptedException {

		productsCategoryNavigation.WomanTabClick();
		womanCategoryPage.TopSubcategoryImageClick();
		womanCategoryPage.HoverBlouseAddToCart();

		Assert.assertTrue(womanCategoryPage.getProceedToCheckoutButton().isEnabled());

	}

	@Test(priority = 5)
	public void addOneProduct_QuantityAnDSizeChanging() throws InterruptedException {

		productsCategoryNavigation.WomanTabClick();
		womanCategoryPage.TopSubcategoryImageClick();
		womanCategoryPage.HoverBlouseMoreButton();

		for (int i = 1; i <= 2; i++) {
			womanCategoryPage.QuantityPlusButtonClick();
		}
		womanCategoryPage.sizeSelect(1);
		womanCategoryPage.AddToCartAfterMoreClick();
		womanCategoryPage.ProceedToCheckOutClick();

		String textForAssertion = (citacIzExcela.getStringData("CART_ADD_&_REMOVE", 18, 4));
		String actualText = womanCategoryPage.valueFromQuantityOfProductsInCartNote();
		assertEquals(actualText, textForAssertion);

		String textForAssertion1 = (citacIzExcela.getStringData("CART_ADD_&_REMOVE", 20, 4));
		String actualText1 = womanCategoryPage.textFromSizeLabel();
		assertEquals(actualText1, textForAssertion1);

	}

	@Test(priority = 15)
	public void addMultipleProducts_3() throws InterruptedException {

		productsCategoryNavigation.WomanTabClick();
		womanCategoryPage.AddThreeProducts();
		Thread.sleep(2000);

		String textForAssertion2 = (citacIzExcela.getStringData("CART_ADD_&_REMOVE", 30, 4));
		String actualText2 = womanCategoryPage.textFromCartButton();
		assertEquals(actualText2, textForAssertion2);

	}

	@Test(priority = 10)
	public void removeProductFromCart() throws InterruptedException {

		addOneProduct();
		womanCategoryPage.ProceedToCheckOutClick();
		womanCategoryPage.DeleteProductButtonClick();
		Thread.sleep(5000);

		String textForAssertion2 = (citacIzExcela.getStringData("CART_ADD_&_REMOVE", 36, 4));
		String actualText2 = womanCategoryPage.textFromCartButton();
		assertEquals(actualText2, textForAssertion2);

	}

	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
