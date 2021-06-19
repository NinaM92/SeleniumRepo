package automationPracticePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WomanCategoryPage {

	WebDriver driver;

	public WomanCategoryPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebElement topsSubcategoryImage;
	WebElement proceedToCheckoutButton;
	WebElement blouseAddToCartButton;
	WebElement blouseMoreButton;
	WebElement quantityPlusButton;
	WebElement addToCartAfterMore;
	WebElement size;
	WebElement quantityOfProductsInCart;
	WebElement sizeLabel;
//	List<WebElement> AddToCartButtonsList;
//	List<WebElement> ImagesOfProductsList;
	WebElement cartButton;
	WebElement deleteProductButton;
	WebElement popUpXIcon;

	public WebElement getPopUpXIcon() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
	}

	public WebElement getDeleteProductButton() {
		return driver.findElement(By.xpath("//*[@id=\"2_7_0_520550\"]/i"));
	}

	public WebElement getCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
	}

	public List<WebElement> getImagesOfProductsList() {
		return driver.findElements(By.className("img-responsive"));
	}

	public List<WebElement> getAddToCartButtonsList() {
		return driver.findElements(By.className("btn-default"));
	}

	public WebElement getSizeLabel() {
		return driver.findElement(By.xpath("//*[@id=\"product_2_9_0_520550\"]/td[2]/small[2]"));
	}

	public WebElement getQuantityOfProductsInCart() {
		return driver.findElement(By.xpath("//*[@id=\"product_2_9_0_520550\"]/td[5]/input[2]"));
	}

	public WebElement getAddToCartAfterMore() {
		return driver.findElement(By.id("add_to_cart"));
	}

	public WebElement getSize() {
		return driver.findElement(By.id("group_1"));
	}

	public WebElement getQuantityPlusButton() {
		return driver.findElement(By.className("icon-plus"));
	}

	public WebElement getBlouseMoreButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]"));
	}

	public WebElement getTopsSubcategoryImage() {
		return driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img"));
	}

	public WebElement getBlouseAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium"));
	}

	// Metode za klik
	public void TopSubcategoryImageClick() {
		this.getTopsSubcategoryImage().click();
	}

	public void QuantityPlusButtonClick() {
		this.getQuantityPlusButton().click();
	}

	public void AddToCartAfterMoreClick() {
		this.getAddToCartAfterMore().click();
	}

	public void ProceedToCheckOutClick() {
		this.getProceedToCheckoutButton().click();
	}

	public void CartButtonClick() {
		this.getCartButton().click();
	}

	public void DeleteProductButtonClick() {
		this.getDeleteProductButton().click();
	}

	public void PopUpXIconClick() {
		this.getPopUpXIcon().click();
	}

	// Metode za String

	public String valueFromQuantityOfProductsInCartNote() {
		return this.getQuantityOfProductsInCart().getAttribute("value");
	}

	public String textFromSizeLabel() {
		return this.getSizeLabel().getText();
	}

	public String textFromCartButton() {
		return this.getCartButton().getText();
	}

	// Metode za hover

	public void HoverBlouseAddToCart() {
		Actions hover = new Actions(driver);
		WebElement BlousePicture = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
		hover.moveToElement(BlousePicture).moveToElement(getBlouseAddToCartButton()).click().build().perform();
	}

	public void HoverBlouseMoreButton() {
		Actions hover1 = new Actions(driver);
		WebElement BlousePicture = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
		hover1.moveToElement(BlousePicture).moveToElement(getBlouseMoreButton()).click().build().perform();
	}

	public void sizeSelect(int index) {

		Select size = new Select(getSize());
		size.selectByIndex(index);
	}

//	public void AddTwoProducts() {
//		for (int i = 1; i < 3; i++) {
//			for (int j = 1; j < 3; j++) {
//
//				Actions hover2 = new Actions(driver);
//				WebElement Images1 = getImagesOfProductsList().get(i);
//				hover2.moveToElement(Images1).moveToElement(getAddToCartButtonsList().get(i)).click().build().perform();
//
//			}
//		}
//	}

	public void AddThreeProducts() {
		Actions action = new Actions(driver);
		WebElement PrintedDressPicture = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		action.moveToElement(PrintedDressPicture)
				.moveToElement(
						driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")))
				.click().build().perform();
		PopUpXIconClick();

		WebElement PrintedChiffonDressPicture = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[1]/div/a[1]/img"));
		action.moveToElement(PrintedChiffonDressPicture)
				.moveToElement(
						driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[2]/div[2]/a[1]")))
				.click().build().perform();
		PopUpXIconClick();

		WebElement BlousePicture = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
		action.moveToElement(BlousePicture).moveToElement(getBlouseAddToCartButton()).click().build().perform();
		PopUpXIconClick();

	}

}
