package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	

	// Web elementi i getteri
	WebElement myAddressesButton;
	WebElement myPersonalInformationButton;
	WebElement myWishListButton;

	public WebElement getMyWishListButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span"));
	}

	public WebElement getMyPersonalInformationButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
	}

	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span"));
	}

	// Metode za klik

	public void MyAddressesClick() {

		this.getMyAddressesButton().click();
	}

	public void myPersonalInformationClick() {
		this.getMyPersonalInformationButton().click();
	}

	public void myWishListClick() {
		this.getMyWishListButton().click();
	}
}
