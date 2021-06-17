package automationPracticePages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage {

	
	WebDriver driver;

	public AddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Update address- Web elementi i getteri
	WebElement updateButton;
	WebElement addANewAddressButton;
	WebElement inputAddressField;
	WebElement inputAddressLine2Field;
	WebElement cityInputField;
	WebElement stateDropDownMenu;
	WebElement zipInputField;
	WebElement homePhone;
	WebElement updateMainAddressInputField;
	WebElement updatedMainAddress;
	WebElement textUpdatedAddress;
	WebElement textUpdatedAddressLine2;
	WebElement textUpdatedCity;
	WebElement textUpdatedState;
	WebElement textUpdatedZip;
	WebElement saveButton;
	WebElement newAddressBox;
	List<WebElement> addressBoxes;
	List<WebElement> deleteButtonsOnBoxes;

	public List<WebElement> getDeleteButtonsOnBoxes() {
		return driver.findElements(By.cssSelector(".icon-remove.right"));
	}

	public List<WebElement> getAddressBoxes() {
		return driver.findElements(By.cssSelector(".col-xs-12.col-sm-6.address"));
	}

	public WebElement getNewAddressBox() {
		return driver.findElement(By.cssSelector(".last_item.alternate_item.box"));
	}

	public WebElement getAddANewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}

	public WebElement getTextUpdatedZip() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[3]"));
	}

	public WebElement getTextUpdatedAddress() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getTextUpdatedAddressLine2() {
		return driver.findElement(By.className("address_address2"));
	}

	public WebElement getTextUpdatedCity() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[1]"));
	}

	public WebElement getTextUpdatedState() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[2]"));
	}

	public WebElement getInputAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getInputAddressLine2Field() {
		return driver.findElement(By.id("address2"));
	}

	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateDropDownMenu() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getZipInputField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getHomePhone() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getUpdatedMainAddress() {
		return driver.findElement(By.className("page-subheading"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getUpdateMainAddressInputField() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]/span"));
	}

	// Metode za klik
	public void UpdateButtonClick() {
		this.getUpdateButton().click();
	}

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void addANewAddressClick() {
		this.getAddANewAddressButton().click();
	}

	// Metode za popunu polja

	public void updateMainAddressInsert(String novaAdresa) {
		this.getUpdateMainAddressInputField().clear();
		this.getUpdateMainAddressInputField().sendKeys(novaAdresa);
	}

	public void InputCity(String city) {
		getCityInputField().clear();
		getCityInputField().sendKeys(city);
	}

	public void InputZip_PostalCode(String zipPostalCode) {
		getZipInputField().clear();
		getZipInputField().sendKeys(zipPostalCode);
	}

	public void InputAddress1(String address1) {
		getInputAddressField().clear();
		getInputAddressField().sendKeys(address1);
	}

	public void InputAddress2(String address2) {
		getInputAddressLine2Field().clear();
		getInputAddressLine2Field().sendKeys(address2);
	}

	public void InputHomePhone(String homePhone) {
		getHomePhone().clear();
		getHomePhone().sendKeys(homePhone);
	}

	// Metoda za tekst

	public String textFromMainAddress() {

		return this.getUpdatedMainAddress().getText();
	}

	public String textFromUpdatedAddress() {

		return this.getTextUpdatedAddress().getText();
	}

	public String textFromUpdatedAddressLine2() {

		return this.getTextUpdatedAddressLine2().getText();
	}

	public String textFromUpdatedCity() {

		return this.getTextUpdatedCity().getText();
	}

	public String textFromUpdatedState() {

		return this.getTextUpdatedState().getText();
	}

	public String textFromUpdatedZip() {

		return this.getTextUpdatedZip().getText();
	}

	// Metode za odabir iz dropdown menu-a

	public void chooseState(int value) {
		Select stateFromDropDown = new Select(getStateDropDownMenu());
		stateFromDropDown.selectByIndex(value);
	}

	// Metoda za brisanje novododate adrese

	public void deleteNewAddressesBox() throws InterruptedException {
		getDeleteButtonsOnBoxes().get(1).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

	}

	// Broj članova liste
	public int numberOfAddressBoxes() {
		return getAddressBoxes().size();
	}
}


