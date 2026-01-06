package testcaserepo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genaricutilities.BaseClass;

//@Listeners(genaricutilities.TestListeners.class)
public class Test_Computers_Desktop extends BaseClass {

	@Test
	public void clickDesktopProductsAndPrint() {
		homePage.clickOnDesktopFromComputersOption(driver);
		List<WebElement> names = desk.getComputerNames();
		List<WebElement> prices = desk.getComputerprices();
		for (int i = 0; i < names.size(); i++) {
			System.out.println("Name " + names.get(i).getText());
			System.out.println("Price " + prices.get(i).getText());
		}
	}

	@Test
	public void sortDesktopProductsInA_Z() {
		selUtil.selectOptionByVisibleText(desk.getSortByDropDown(), "Name: A to Z");
		List<WebElement> names = desk.getComputerNames();
		List<String> sortItem = desk.getAllComputerNames().stream().sorted().collect(Collectors.toList());
		for (int i = 0; i < sortItem.size(); i++) {
			Assert.assertEquals(names.get(i).getText(), sortItem.get(i));
		}
	}

	@Test
	public void sortDesktopProductsZ_A() {
		selUtil.selectOptionByVisibleText(desk.getSortByDropDown(), "Name: Z to A");
		List<WebElement> names = desk.getComputerNames();
		List<String> sorted = desk.getAllComputerNames().stream().sorted((i1, i2) -> -i1.compareTo(i2))
				.collect(Collectors.toList());
		for (int i = 0; i < sorted.size(); i++) {
			Assert.assertEquals(names.get(i).getText(), sorted.get(i));
		}
	}

	@Test
	public void sortDesktopProductsByPriceLow_High() {
		selUtil.selectOptionByVisibleText(desk.getSortByDropDown(), "Price: Low to High");
		List<WebElement> prices = desk.getComputerprices();
		List<Double> sorted = desk.getAllComputerPrices().stream().sorted().collect(Collectors.toList());
		for (int i = 0; i < sorted.size(); i++) {
			Assert.assertEquals(prices.get(i).getText(), sorted.get(i) + "0");
		}
	}

	@Test
	public void sortDeskTopProductsByPriceHigh_Low() {
		selUtil.selectOptionByVisibleText(desk.getSortByDropDown(), "Price: High to Low");
		List<WebElement> prices = desk.getComputerprices();
		List<Double> sorted = desk.getAllComputerPrices().stream().sorted((i1, i2) -> -i1.compareTo(i2))
				.collect(Collectors.toList());
		for (int i = 0; i < prices.size(); i++) {

			Assert.assertEquals(prices.get(i).getText(), sorted.get(i) + "0");
		}

	}

	@Test
	public void displayItems() {
		selUtil.selectOptionByVisibleText(desk.getDisplayDropDown(), "4");
		Assert.assertEquals(desk.getComputerNames().size(), 4);
	}

	@Test
	public void filterByPriceUnder1000() {
		desk.filterByPriceUnder1000();
		List<Double> allComputerPrices = desk.getAllComputerPrices();
		for (Double price : allComputerPrices) {
			Assert.assertTrue(price <= 1000);
		}
		desk.removeFilter();
	}

	@Test
	public void filterByPriceBetween1000_1200() {
		desk.filterByPriceBetween1000_1200();
		List<Double> allComputerPrices = desk.getAllComputerPrices();
		for (Double price : allComputerPrices) {
			Assert.assertTrue(price >= 1000 && price <= 1200);
		}
		desk.removeFilter();
	}

	@Test
	public void filterByPriceOver1200() {

		desk.filterByPriceOver1200();
		List<Double> allComputerPrices = desk.getAllComputerPrices();
		for (Double price : allComputerPrices) {
			Assert.assertTrue(price >= 1200);
		}
		desk.removeFilter();
	}
}
