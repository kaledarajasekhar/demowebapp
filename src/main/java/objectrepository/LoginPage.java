package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "Email")
	public WebElement emailTf;

	@FindBy(id = "Password")
	public WebElement passwordTf;

	@FindBy(id = "RememberMe")
	public WebElement rememberCheckBox;

	@FindBy(xpath = "//input[@value='Log in']")
	public WebElement loginButton;

	@FindBy(xpath = "//input[@value='Register']")
	public WebElement registerButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTf() {
		return emailTf;
	}

	public WebElement getPasswordTf() {
		return passwordTf;
	}

	public WebElement getRememberCheckBox() {
		return rememberCheckBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public void login(String email, String password) {
		getEmailTf().sendKeys(email);
		getPasswordTf().sendKeys(password);
		getRememberCheckBox().click();
		getLoginButton().click();

	}
}
