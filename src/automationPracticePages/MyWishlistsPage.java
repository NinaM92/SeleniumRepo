package automationPracticePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {

	WebDriver driver;

	public MyWishlistsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Web elementi i getteri

	WebElement nameOfListInputField;
	WebElement saveButton;
	List<WebElement> wishlists;
	List<WebElement> deleteButtons;

	public List<WebElement> getDeleteButtons() {
		return driver.findElements(By.className("icon"));
	}

	public WebElement getNameOfListInputField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"submitWishlist\"]/span"));
	}

	// Metode za klik

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	// Metoda za popunu polja

	public void insertNameOfListInputField(String nameOfList) {
		this.getNameOfListInputField().clear();
		this.getNameOfListInputField().sendKeys(nameOfList);
	}

	// Metode za liste
	public int numberOfLists() {
		return getDeleteButtons().size();
	}

	public void deleteAWishlist() throws InterruptedException {
		getDeleteButtons().get(0).click();
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
	}

	public void deleteAllWishlists() throws InterruptedException {
		for (int i = 0; i < numberOfLists(); i++) {
			getDeleteButtons().get(i).click();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		}

	}

}
