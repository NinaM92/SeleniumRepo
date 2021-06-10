package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	WebElement emailAddressField;
	WebElement passwordField;
	WebElement signInButton;

	public WebElement getEmailAddressField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getSignInButton() {
		return driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	}
	
	
	//Metode- 
		//popunjavanje polja
		public void insertEmailAddress(String emailAddress) {
			this.getEmailAddressField().clear();
			this.getEmailAddressField().sendKeys(emailAddress);
		}
	
		public void insertPassword(String password) {
			this.getPasswordField().clear();
			this.getPasswordField().sendKeys(password);
		}
		
	//Metode za klik
		
		public void signInButtonClick() {
			this.getSignInButton().click();
		}
	
	
	
}
