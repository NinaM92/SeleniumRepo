package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IdentityPage {

	WebDriver driver;

	public IdentityPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Web elementi i getteri

	WebElement mrsRadioButton;
	WebElement FirstName;
	WebElement LastName;
	WebElement dayOfBirth;
	WebElement monthOfBirth;
	WebElement yearOfBirth;
	WebElement saveButton;
	WebElement oldPassword;
	WebElement updatePersonalInfoSuccess;

	public WebElement getOldPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getUpdatePersonalInfoSuccess() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span"));
	}

	public WebElement getDayOfBirth() {
		return driver.findElement(By.id("days"));
	}

	public WebElement getMonthOfBirth() {
		return driver.findElement(By.id("months"));
	}

	public WebElement getYearOfBirth() {
		return driver.findElement(By.id("years"));
	}

	public WebElement getFirstName() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getMrsRadioButton() {
		return driver.findElement(By.id("id_gender2"));
	}

	// Metoda za klik
	public void MrsRadioButtonClick() {

		this.getMrsRadioButton().click();
	}

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	// Metode za popunu polja

	public void InsertFirstName(String firstName) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
	}

	public void InsertLastName(String lastName) {
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
	}

	public void InsertOldPassword(String oldPassword) {
		this.getOldPassword().clear();
		this.getOldPassword().sendKeys(oldPassword);
	}

	// Metode za odabir iz drop down

	public void chooseDayOfBirth(int index) {
		Select dayOfBirth = new Select(getDayOfBirth());
		dayOfBirth.selectByIndex(index);

	}

	public void chooseMonth(int index) {
		Select monthOfBirth = new Select(getMonthOfBirth());
		monthOfBirth.selectByIndex(index);
	}

	public void chooseYearOfBirth(int index) {
		Select yearOfBirth = new Select(getYearOfBirth());
		yearOfBirth.selectByIndex(index);
	}

}
