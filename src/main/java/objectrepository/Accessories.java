package objectrepository;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accessories {

	public Accessories(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='product-title']/a")
	private List<WebElement> accNames;

	@FindBy(xpath = "//div[@class='prices']/span")
	private List<WebElement> accPrices;

	@FindBy(id = "products-orderby")
	private WebElement sortByDropDown;

	@FindBy(id = "products-pagesize")
	private WebElement displayDropDown;

	@FindBy(xpath = "//a[contains(text(),'Under')]")
	private WebElement filterByPriceUnder100;

	@FindBy(xpath = "//a[contains(text(),'Over')]")
	private WebElement filterByPriceOver100;

	@FindBy(linkText = "Remove Filter")
	public WebElement removeFilterLink;

	public List<WebElement> getAccNames() {
		return accNames;
	}

	public List<WebElement> getAccPrices() {
		return accPrices;
	}

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}

	public WebElement getDisplayDropDown() {
		return displayDropDown;
	}

	public WebElement getFilterByPriceUnder100() {
		return filterByPriceUnder100;
	}

	public WebElement getFilterByPriceOver100() {
		return filterByPriceOver100;
	}

	public WebElement getRemoveFilterLink() {
		return removeFilterLink;
	}

	public List<String> getAllAccNames() {
		return getAccNames().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<Double> getAllAccPricesInDecimal() {
		return getAccPrices().stream().map(WebElement::getText).map(Double::parseDouble).collect(Collectors.toList());
	}

	public List<String> getAllAccPricesInString() {
		return getAccPrices().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public void clickRemoveFilter() {
		getRemoveFilterLink().click();
	}

	public void clickFilterByPriceUnder100() {
		getFilterByPriceUnder100().click();
	}

	public void clickFilterByPriceOver100() {
		getFilterByPriceOver100().click();
	}
}
