package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsCategoryNavigation {

	
	WebDriver driver;

	public ProductsCategoryNavigation(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebElement womanTab;

	public WebElement getWomanTab() {
		return driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
	}

	// Metode za klik

	public void WomanTabClick() {
		this.getWomanTab().click();
	}

}
