package objectrepository;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricutilities.SeleniumUtility;

public class Desktop {

	@FindBy(xpath = "//div[@class='details']/h2/a")
	public List<WebElement> computerNames;

	@FindBy(xpath = "//div[@class='details']/div/div[@class='prices']/span")
	private List<WebElement> Computerprices;

	@FindBy(xpath = "//select[@id='products-orderby']")
	private WebElement sortByDropDown;

	@FindBy(xpath = "//select[@id='products-pagesize']")
	public WebElement displayDropDown;

	@FindBy(xpath = "//a[contains(text(),'Under')]")
	private WebElement filterByPriceUnder1000;

	@FindBy(xpath = "//a[text()=' - ']")
	private WebElement filterByPricebetween1000_1200;

	@FindBy(xpath = "//a[contains(text(),'Over')]")
	private WebElement filterByPriceOver1200;

	@FindBy(linkText = "Remove Filter")
	private WebElement removeFilter;

	public WebElement getFilterByPriceUnder1000() {
		return filterByPriceUnder1000;
	}

	public WebElement getFilterByPricebetween1000_1200() {
		return filterByPricebetween1000_1200;
	}

	public WebElement getFilterByPriceOver1200() {
		return filterByPriceOver1200;
	}

	public WebElement getRemoveFilter() {
		return removeFilter;
	}

	public List<WebElement> getComputerNames() {
		return computerNames;
	}

	public List<WebElement> getComputerprices() {
		return Computerprices;
	}

	public Desktop(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}

	public WebElement getDisplayDropDown() {
		return displayDropDown;
	}

	public void removeFilter() {
		getRemoveFilter().click();
	}

	public void filterByPriceUnder1000() {
		getFilterByPriceUnder1000().click();
	}

	public void filterByPriceBetween1000_1200() {
		getFilterByPricebetween1000_1200().click();
	}

	public void filterByPriceOver1200() {
		getFilterByPriceOver1200().click();
	}

	public List<Double> getAllComputerPrices() {
		return getComputerprices().stream().map(WebElement::getText).map(Double::parseDouble)
				.collect(Collectors.toList());
	}

	public List<String> getAllComputerNames() {
		return getComputerNames().stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
