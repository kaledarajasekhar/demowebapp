package genaricutilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get(); // returns driver for CURRENT THREAD ONLY
	}

	public static void setDriver(WebDriver driverRef) {
		driver.set(driverRef); // assigns driver to specific thread
	}

}
