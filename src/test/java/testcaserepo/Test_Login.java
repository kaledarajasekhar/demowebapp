package testcaserepo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genaricutilities.BaseClass;
import genaricutilities.ExcelUtility;
import objectrepository.HomePage;
import objectrepository.LoginPage;

//@Listeners(genaricutilities.TestListeners.class)

public class Test_Login extends BaseClass {

	@Test
	public void login() throws Throwable {
		
		int row = Integer.parseInt(propUtil.getPropertyValue("loginrow"));

		String email = excel.getCellData("Login", row, 1);
		String password = excel.getCellData("Login", row, 2);
		homePage = new HomePage(driver);
		homePage.getLoginLink().click();
		loginPage = new LoginPage(driver);
		loginPage.login(email, password);
		System.out.println(System.getProperty("username"));
		Assert.assertEquals(homePage.getEmailText().getText(), email);
	}

	@Test(dependsOnMethods = { "login" })
	public void logout() {

		homePage.logoutLink.click();
		Assert.assertTrue(homePage.getRegisterLink().isDisplayed());
	}
}
