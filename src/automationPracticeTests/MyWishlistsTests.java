package automationPracticeTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationPracticePages.MyWishlistsPage;

public class MyWishlistsTests extends BaseTests {

	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		successfulLogin();

	}

	@Test(priority = 0)
	public void addWishList() throws InterruptedException {

		myAccountPage.myWishListClick();
		int numberOfListBeforeAddingAnyWishList = myWishLists.numberOfLists();
		myWishLists.insertNameOfListInputField(citacIzExcela.getStringData("MY WISHLISTS", 10, 3));
		myWishLists.saveButtonClick();

		int numberOfListAfterAddingOneWishList = myWishLists.numberOfLists();

		Assert.assertEquals(numberOfListAfterAddingOneWishList, numberOfListBeforeAddingAnyWishList + 1);
	}

	@Test(priority = 5)
	public void addMultipleWishList() throws InterruptedException {

		myAccountPage.myWishListClick();
		for (int i = 19; i <= 23; i += 2) {

			myWishLists.insertNameOfListInputField(citacIzExcela.getStringData("MY WISHLISTS", i, 3));
			myWishLists.saveButtonClick();
		}

		Assert.assertEquals(myWishLists.numberOfLists(), 3);

	}

	@Test(priority = 10)
	public void removeWishList() throws InterruptedException {

		addWishList();
		int numberOfListAfterAddingOneWishList = myWishLists.numberOfLists();
		myWishLists.deleteAWishlist();
		int numberOfListAfterDeletingOneWishList = myWishLists.numberOfLists();
		Thread.sleep(2000);
		Assert.assertEquals(numberOfListAfterDeletingOneWishList, numberOfListAfterAddingOneWishList - 1);
	}

	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {

		myWishLists.deleteAllWishlists();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
