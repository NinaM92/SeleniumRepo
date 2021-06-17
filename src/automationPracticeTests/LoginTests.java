package automationPracticeTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void logInValidCredentials() throws InterruptedException {

		successfulLogin();
		String textForAssertion = citacIzExcela.getStringData("LOGIN", 8, 4);
		String actualText = upperNavigationBar.textFromSignOutButton();
		Assert.assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 5)
	public void logIn_InvalidEmailAddress() throws InterruptedException {

		upperNavigationBar.SignInButtonClick();
		String emailAddress = citacIzExcela.getStringData("LOGIN", 11, 3);
		String password = citacIzExcela.getStringData("LOGIN", 12, 3);

		loginFormFiling(emailAddress, password);

		String textForAssertion = citacIzExcela.getStringData("LOGIN", 14, 4);
		String actualText = loginPage.textFromErrorMessageWrongEmail();
		Assert.assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 10)
	public void logIn_InvalidPassword() throws InterruptedException {

		upperNavigationBar.SignInButtonClick();
		String emailAddress = citacIzExcela.getStringData("LOGIN", 17, 3);
		String password = citacIzExcela.getStringData("LOGIN", 18, 3);

		loginFormFiling(emailAddress, password);
		Assert.assertTrue(upperNavigationBar.getSignInButton().isDisplayed());
	}

	@Test(priority = 15)
	public void logIn_EmptyEmailAddressField() throws InterruptedException {

		upperNavigationBar.SignInButtonClick();
		String password = citacIzExcela.getStringData("LOGIN", 23, 3);
		loginPage.insertPassword(password);
		loginPage.signInButtonClick();
		String textForAssertion = citacIzExcela.getStringData("LOGIN", 25, 4);
		String actualText = loginPage.textFromEmailRequired();
		Assert.assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 20)
	public void logIn_EmptyPasswordField() throws InterruptedException {

		upperNavigationBar.SignInButtonClick();
		String emailAddress = citacIzExcela.getStringData("LOGIN", 28, 3);

		loginPage.insertEmailAddress(emailAddress);
		loginPage.signInButtonClick();

		String textForAssertion = citacIzExcela.getStringData("LOGIN", 30, 4);
		String actualText = loginPage.textFromPasswordRequired();
		Assert.assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 25)
	public void logOut() throws InterruptedException {

		logInValidCredentials();
		upperNavigationBar.SignOutButtonClick();
		String textForAssertion = citacIzExcela.getStringData("LOGIN", 38, 4);
		String actualText = upperNavigationBar.textFromSignInButton();
		Assert.assertEquals(actualText, textForAssertion);

	}

	public void loginFormFiling(String emailAddress, String password) {

		loginPage.insertEmailAddress(emailAddress);
		loginPage.insertPassword(password);
		loginPage.signInButtonClick();
	}

	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	
	
	
}
