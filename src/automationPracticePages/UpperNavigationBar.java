package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpperNavigationBar {

	
	WebDriver driver;

	public UpperNavigationBar(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebElement signInButton;
	WebElement signOutButton;

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	// Metode za klik

	public void SignInButtonClick() {

		this.getSignInButton().click();

	}

	public void SignOutButtonClick() {
		this.getSignOutButton().click();
	}

	// Metoda za string

	public String textFromSignOutButton() {
		return this.getSignOutButton().getText();
	}

	public String textFromSignInButton() {
		return this.getSignInButton().getText();
	}
	
	
	
	
	
}




