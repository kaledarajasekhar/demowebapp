package genaricutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectrepository.Desktop;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.RegisterPage;

public class BaseClass {

	public SeleniumUtility selUtil;
	public PropertiesUtility propUtil;
	public ExcelUtility excel = new ExcelUtility();
	public HomePage homePage;
	public LoginPage loginPage;
	public RegisterPage regPage;
	public Desktop desk;
	public JavaUtility javaUtil;
	public WebDriver driver = null;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launch(@Optional("chrome") String browser) throws Throwable {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		}

		DriverManager.setDriver(driver);

		propUtil = new PropertiesUtility();
		selUtil = new SeleniumUtility(driver);
		selUtil.maximizeWindow();
		selUtil.implicitWait(10);
		selUtil.launchApplication(propUtil.getPropertyValue("url"));
		homePage = new HomePage(driver);
		desk = new Desktop(driver);
		javaUtil = new JavaUtility();
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		selUtil.closeApplication();
	}
}
