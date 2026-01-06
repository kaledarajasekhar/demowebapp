package testcaserepo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import genaricutilities.BaseClass;
import genaricutilities.ExcelUtility;
import objectrepository.HomePage;
import objectrepository.RegisterPage;

@Listeners(genaricutilities.TestListeners.class)

public class Register extends BaseClass {

	int i = 0;

	@Test(groups = { "Regression" }, retryAnalyzer = genaricutilities.RetryAnalyzerImplementation.class)
	public void registerPage() throws Throwable {
		homePage = new HomePage(driver);
		homePage.getRegisterLink().click();
		int row = Integer.parseInt(propUtil.getPropertyValue("registerrow"));
		String gender = excel.getCellData("Register", row, 1);
		String firstNmae = excel.getCellData("Register", row, 2);
		String lastName = excel.getCellData("Register", row, 3);
		String email = excel.getCellData("Register", row, 4);
		String password = excel.getCellData("Register", row, 5);
		String confirmPassword = excel.getCellData("Register", row, 6);
		RegisterPage reg = new RegisterPage(driver);
		reg.register(gender, firstNmae, lastName, email, password, confirmPassword);
		if (i < 2) {
			i++;
			Assert.assertTrue(reg.getRegisterMessage().isDisplayed());
			String regemail = homePage.getEmailText().getText();
			Assert.assertEquals(regemail, email);
			propUtil.setPropertyValue("email", email);
			propUtil.setPropertyValue("password", password);
			homePage.getLogoutLink().click();
			Assert.assertTrue(homePage.getRegisterLink().isDisplayed());
		}
	}
}
