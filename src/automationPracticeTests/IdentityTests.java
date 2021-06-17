package automationPracticeTests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IdentityTests extends BaseTests {

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		successfulLogin();

	}

	@Test(priority = 0)
	public void editYourPersonal_Information() throws InterruptedException {

		myAccountPage.myPersonalInformationClick();
		yourPersonal_Information.MrsRadioButtonClick();
		yourPersonal_Information.InsertFirstName(citacIzExcela.getStringData("MY PERSONAL INFO", 11, 3));
		yourPersonal_Information.InsertLastName(citacIzExcela.getStringData("MY PERSONAL INFO", 12, 3));
		yourPersonal_Information.chooseDayOfBirth(21);
		yourPersonal_Information.chooseMonth(6);
		yourPersonal_Information.chooseYearOfBirth(30);
		yourPersonal_Information.InsertOldPassword(citacIzExcela.getStringData("MY PERSONAL INFO", 16, 3));
		yourPersonal_Information.saveButtonClick();

		Assert.assertTrue(yourPersonal_Information.getUpdatePersonalInfoSuccess().isDisplayed());

	}

	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
