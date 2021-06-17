package automationPracticeTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressesTests extends BaseTests {

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		successfulLogin();
	}

	@Test(priority = 0)
	public void updateAddress() throws InterruptedException {

		myAccountPage.MyAddressesClick();
		Thread.sleep(2000);
		myAddresses.UpdateButtonClick();
		myAddresses.InputAddress1(citacIzExcela.getStringData("MY ADDRESSES", 11, 3));
		myAddresses.InputAddress2(citacIzExcela.getStringData("MY ADDRESSES", 13, 3));
		myAddresses.InputCity(citacIzExcela.getStringData("MY ADDRESSES", 14, 3));
		myAddresses.chooseState(3);
		myAddresses.InputZip_PostalCode(citacIzExcela.getStringData("MY ADDRESSES", 16, 3));
		String updatedAddress = citacIzExcela.getStringData("MY ADDRESSES", 17, 3);
		myAddresses.updateMainAddressInsert(updatedAddress);
		myAddresses.saveButtonClick();

		// String asserti

		String textForAssertion = citacIzExcela.getStringData("MY ADDRESSES", 11, 3);
		String actualText = myAddresses.textFromUpdatedAddress();
		assertEquals(actualText, textForAssertion);

		String textForAssertion2 = citacIzExcela.getStringData("MY ADDRESSES", 13, 3);
		String actualText2 = myAddresses.textFromUpdatedAddressLine2();
		assertEquals(actualText2, textForAssertion2);

//		 String textForAssertion3 = citacIzExcela.getStringData("MY ADDRESSES", 14, 3);
//		 String actualText3 = myAddresses.textFromUpdatedCity();
//		 assertEquals(actualText3, textForAssertion3);

		String actualText4 = myAddresses.textFromUpdatedState();

		String textForAssertion4 = citacIzExcela.getStringData("MY ADDRESSES", 15, 3);
		assertEquals(actualText4, textForAssertion4);

		String textForAssertion5 = citacIzExcela.getStringData("MY ADDRESSES", 16, 3);

		String actualText5 = myAddresses.textFromUpdatedZip();
		assertEquals(actualText5, textForAssertion5);

		String textForAssertion1 = citacIzExcela.getStringData("MY ADDRESSES", 17, 3);
		String actualText1 = myAddresses.textFromMainAddress();
		assertEquals(actualText1, textForAssertion1);

	}

	@Test(priority = 5)
	public void addNewAddress() throws InterruptedException {

		myAccountPage.MyAddressesClick();
		myAddresses.addANewAddressClick();
		myAddresses.InputAddress1(citacIzExcela.getStringData("MY ADDRESSES", 26, 3));
		myAddresses.InputAddress2(citacIzExcela.getStringData("MY ADDRESSES", 28, 3));
		myAddresses.InputCity(citacIzExcela.getStringData("MY ADDRESSES", 29, 3));
		myAddresses.chooseState(9);
		myAddresses.InputZip_PostalCode(citacIzExcela.getStringData("MY ADDRESSES", 16, 3));
		myAddresses.InputHomePhone(citacIzExcela.getStringData("MY ADDRESSES", 32, 3));
		myAddresses.updateMainAddressInsert(citacIzExcela.getStringData("MY ADDRESSES", 33, 3));
		myAddresses.saveButtonClick();

		Assert.assertEquals(myAddresses.numberOfAddressBoxes(), 2);

	}

	@Test(priority = 10)
	public void deleteNewAddress() throws InterruptedException {

		myAccountPage.MyAddressesClick();
		myAddresses.deleteNewAddressesBox();
		Thread.sleep(7000);
		Assert.assertEquals(myAddresses.numberOfAddressBoxes(), 1);

	}

	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
