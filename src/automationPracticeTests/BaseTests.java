package automationPracticeTests;

import java.awt.Desktop.Action;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import automationPracticePages.LoginPage;
import automationPracticePages.MyAccountPage;
import automationPracticePages.AddressesPage;
import automationPracticePages.MyWishlistsPage;
import automationPracticePages.ProductsCategoryNavigation;
import automationPracticePages.UpperNavigationBar;
import automationPracticePages.WomanCategoryPage;
import automationPracticePages.IdentityPage;


public class BaseTests {
	
	WebDriver driver;
	Actions actions;
	LoginPage loginPage;
	UpperNavigationBar upperNavigationBar;
	MyAccountPage myAccountPage;
	AddressesPage myAddresses;
	IdentityPage yourPersonal_Information;
	MyWishlistsPage myWishLists;
	ProductsCategoryNavigation productsCategoryNavigation;
	WomanCategoryPage womanCategoryPage;
	ExcelReader citacIzExcela;
	String homeUrl;

	@BeforeClass
	public void preSihTestova() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		upperNavigationBar = new UpperNavigationBar(driver);
		myAddresses = new AddressesPage(driver);
		yourPersonal_Information = new IdentityPage(driver);
		myWishLists = new MyWishlistsPage(driver);
		productsCategoryNavigation = new ProductsCategoryNavigation(driver);
		womanCategoryPage = new WomanCategoryPage(driver);
		actions = new Actions(driver);

		citacIzExcela = new ExcelReader("data/Selenijum Projekat.xlsx");
		homeUrl = "http://automationpractice.com/index.php";

	}

	public void successfulLogin() {

		String emailAddress = citacIzExcela.getStringData("LOGIN", 5, 3);
		String password = citacIzExcela.getStringData("LOGIN", 6, 3);
		upperNavigationBar.SignInButtonClick();
		loginPage.insertEmailAddress(emailAddress);
		loginPage.insertPassword(password);
		loginPage.signInButtonClick();
	}

	@AfterClass
	public void posleSihTestova() {
		driver.close();
	}
	
	
	
	
}
