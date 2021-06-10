package automationPracticeTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import automationPracticePages.HomePage;
import automationPracticePages.LoginPage;
import automationPracticePages.MyAccountPage;


public class BaseTests {

	
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	ExcelReader citacIzExcela;
	String homeUrl;
	
	
	@BeforeClass
	public void preSihTestova() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homePage = new HomePage (driver);
		loginPage= new LoginPage (driver);
		myAccountPage= new MyAccountPage (driver);
		
		citacIzExcela =  new ExcelReader("data/Selenijum Projekat.xlsx");
		homeUrl = "http://automationpractice.com/index.php";

	}
	@AfterClass
	public void posleSihTestova() {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
}
