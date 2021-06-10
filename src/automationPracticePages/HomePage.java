package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	
    WebElement signInButton;

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	
	//Metode za klik
	
	public void SignInButtonClick() {
		
		this.getSignInButton().click();
		
	}
	
	
}
