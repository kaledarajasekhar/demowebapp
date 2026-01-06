package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='gender']/label[text()='Male']")
	private WebElement maleButton;

	@FindBy(xpath = "//div[@class='gender']/label[text()='Female']")
	private WebElement femaleButton;

	@FindBy(id = "FirstName")
	private WebElement firstNameTf;

	@FindBy(id = "LastName")
	private WebElement lastNameTf;

	@FindBy(id = "Email")
	private WebElement emailTf;

	@FindBy(id = "Password")
	private WebElement passwordTf;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTf;

	@FindBy(id = "register-button")
	private WebElement registerButton;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerMessage;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public void register(String gender, String firstName, String lastName, String email, String password,
			String confirmPassword) {

		if (gender.equalsIgnoreCase("Male"))
			maleButton.click();
		else
		femaleButton.click();
		firstNameTf.sendKeys(firstName);
		lastNameTf.sendKeys(lastName);
		emailTf.sendKeys(email);
		passwordTf.sendKeys(password);
		confirmPasswordTf.sendKeys(confirmPassword);
		registerButton.click();

	}

	public WebElement getMaleButton() {
		return maleButton;
	}

	public void setMaleButton(WebElement maleButton) {
		this.maleButton = maleButton;
	}

	public WebElement getFemaleButton() {
		return femaleButton;
	}

	public void setFemaleButton(WebElement femaleButton) {
		this.femaleButton = femaleButton;
	}

	public WebElement getFirstNameTf() {
		return firstNameTf;
	}

	public void setFirstNameTf(WebElement firstNameTf) {
		this.firstNameTf = firstNameTf;
	}

	public WebElement getLastNameTf() {
		return lastNameTf;
	}

	public void setLastNameTf(WebElement lastNameTf) {
		this.lastNameTf = lastNameTf;
	}

	public WebElement getEmailTf() {
		return emailTf;
	}

	public void setEmailTf(WebElement emailTf) {
		this.emailTf = emailTf;
	}

	public WebElement getPasswordTf() {
		return passwordTf;
	}

	public void setPasswordTf(WebElement passwordTf) {
		this.passwordTf = passwordTf;
	}

	public WebElement getConfirmPasswordTf() {
		return confirmPasswordTf;
	}

	public void setConfirmPasswordTf(WebElement confirmPasswordTf) {
		this.confirmPasswordTf = confirmPasswordTf;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(WebElement registerButton) {
		this.registerButton = registerButton;
	}

	public WebElement getRegisterMessage() {
		return registerMessage;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

}
