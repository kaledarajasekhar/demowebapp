package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricutilities.SeleniumUtility;

public class HomePage {

	@FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='account']")
	private WebElement emailText;

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(linkText = "Log in")
	public WebElement loginLink;

	@FindBy(linkText = "Log out")
	public WebElement logoutLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Computers')]")
	private WebElement computersLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Desktops')]")
	private WebElement DesktopsLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Notebooks')]")
	private WebElement notebooksLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Accessories')]")
	private WebElement accessoriesLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getDesktopsLink() {
		return DesktopsLink;
	}

	public WebElement getNotebooksLink() {
		return notebooksLink;
	}

	public WebElement getAccessoriesLink() {
		return accessoriesLink;
	}

	public WebElement getEmailText() {
		return emailText;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void clickOnDesktopFromComputersOption(WebDriver driver) {
		new SeleniumUtility(driver).moveElement(getComputersLink());
		getDesktopsLink().click();
	}

	public void clickOnAccessoriesFromDeskTopOptions(WebDriver driver) {
		new SeleniumUtility(driver).moveElement(getComputersLink());
		getAccessoriesLink().click();
	}

}
