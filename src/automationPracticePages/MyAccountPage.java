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
	
	
   WebElement signOut;

  public WebElement getSignOut() {
	return  driver.findElement(By.className("logout"));
  }
	
	
	//Metoda za String
  
  public String textFromSignOut () {
	  
	  return this.getSignOut().getText();
  }
	
	
	
}
