package testcaserepo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genaricutilities.BaseClass;
import objectrepository.Accessories;

public class Test_Computers_Accessories extends BaseClass {

	public Accessories acc;

	@BeforeMethod(alwaysRun = true)
	public void generic() {
		homePage.clickOnAccessoriesFromDeskTopOptions(driver);
		acc = new Accessories(driver);
	}

	@Test(priority = 1, groups = { "Smoke" })
	public void clickAccssoriesPrintAllProducts() {
		List<String> allAccNames = acc.getAllAccNames();
		List<Double> allAccPricesInDecimal = acc.getAllAccPricesInDecimal();
		for (int i = 0; i < allAccNames.size(); i++) {
			System.out.println(allAccNames.get(i));
			System.out.println(allAccPricesInDecimal.get(i));
		}
	}

	@Test(priority = 2 ,groups = {"Smoke"})
	public void sortAccessoriesInA_Z() {
		selUtil.selectOptionByVisibleText(acc.getSortByDropDown(), "Name: A to Z");
		List<String> allAccNames = acc.getAllAccNames();
		List<String> sortAllAccNamesA_Z = javaUtil.sortStringA_Z(allAccNames);
		for (int i = 0; i < allAccNames.size(); i++) {
			Assert.assertEquals(allAccNames.get(i), sortAllAccNamesA_Z.get(i));
		}
	}

	@Test(priority = 3,groups = {"Smoke"})
	public void sortAccssoriesInZ_A() {
		selUtil.selectOptionByVisibleText(acc.getSortByDropDown(), "Name: Z to A");
		List<String> allAccNames = acc.getAllAccNames();
		List<String> sortAllNames = javaUtil.sortStringZ_A(allAccNames);
		for (int i = 0; i < allAccNames.size(); i++) {
			Assert.assertEquals(allAccNames.get(i), sortAllNames.get(i));
		}
	}

	@Test(priority = 4,groups = {"Regression"})
	public void sortAccessoriesByPriceInLow_High() {
		selUtil.selectOptionByVisibleText(acc.getSortByDropDown(), "Price: Low to High");
		List<String> accPrices = acc.getAllAccPricesInString();
		List<Double> sort = javaUtil.sortDoubleLow_High(acc.getAllAccPricesInDecimal());
		for (int i = 0; i < sort.size(); i++) {
			Assert.assertEquals(accPrices.get(i), sort.get(i) + "0");
		}
	}

	@Test(priority = 5,groups = {"Regression"})
	public void sortAccessoriesInHigh_Low() {
		selUtil.selectOptionByVisibleText(acc.getSortByDropDown(), "Price: High to Low");
		List<String> pricesInString = acc.getAllAccPricesInString();
		List<Double> sort = javaUtil.sortDoubleHigh_Low(acc.getAllAccPricesInDecimal());
		for (int i = 0; i < sort.size(); i++) {

			Assert.assertEquals(pricesInString.get(i), sort.get(i) + "0");
		}
	}

	@Test(priority = 6,groups = {"Regression"})
	public void displayAccessoriesPerPage() {
		selUtil.selectOptionByVisibleText(acc.getDisplayDropDown(), "4");
		Assert.assertTrue(acc.getAccPrices().size() == 4);
	}

	@Test(priority = 7,groups = {"Sanity"})
	public void filterByPriceUnder100() {
		acc.clickFilterByPriceUnder100();
		Assert.assertTrue(acc.getAccPrices().size() == 0);
		acc.clickRemoveFilter();
	}

	@Test(priority = 8,groups = {"Sanity"})
	public void filterByPriceOver100() {
		selUtil.selectOptionByVisibleText(acc.getDisplayDropDown(), "8");
		acc.clickFilterByPriceOver100();
		Assert.assertTrue(acc.getAccPrices().size() == 7);
		acc.clickRemoveFilter();
	}

}
