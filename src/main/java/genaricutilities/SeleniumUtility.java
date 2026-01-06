package genaricutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumUtility {

	public WebDriver driver;
	public Actions action;

	public SeleniumUtility(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
	}

	public void launchApplication(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

	}

	public void moveElement(WebElement element) {
		action.moveToElement(element).perform();
	}

	public void selectOptionByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void closeApplication() {
		driver.quit();
	}
	
	public String captureWebpageScreenshot(String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(IPathUtility.screenshotPath + screenshotName + ".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
}
