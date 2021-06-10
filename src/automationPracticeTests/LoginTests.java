package automationPracticeTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests  extends BaseTests{

	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 0)
	public void logInValidCredentials() throws InterruptedException {
	 
		homePage.SignInButtonClick();
		String emailAddress = citacIzExcela.getStringData("TC1", 6, 2);
		String password = citacIzExcela.getStringData("TC1", 7, 2);
	
		
		loginFormFiling(emailAddress, password);
		
		String textForAssertion = citacIzExcela.getStringData("TC1", 9, 3);
		String actualText = myAccountPage.textFromSignOut();
		assertEquals(actualText, textForAssertion);
		
	}
	
	
	public void loginFormFiling (String emailAddress, String password) {
		
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
