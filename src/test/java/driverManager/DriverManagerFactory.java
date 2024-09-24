package driverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import stepDefinition.Important.AbstractStepDefinifion;

import static driverManager.DriverType.CHROME;
import static driverManager.DriverType.FIREFOX;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;


public class DriverManagerFactory extends AbstractStepDefinifion {
    //singleton
    public static void getDriver(DriverType browserName) {
        if (null == driver) {
            if (browserName.toString().equalsIgnoreCase(CHROME.toString())) {
                System.setProperty(CHROME_DRIVER_EXE_PROPERTY, chromeDriver);
                driver = new ChromeDriver();
                driver.get(homePageUrl);
                driver.manage().window().maximize();
            } else if (browserName.toString().equalsIgnoreCase(FIREFOX.toString())) {
                System.setProperty(GECKO_DRIVER_EXE_PROPERTY, geckodriver);
                driver = new FirefoxDriver();
                driver.get(homePageUrl);
                driver.manage().window().maximize();
            }
        }
        driver.manage().deleteAllCookies();
    }

    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
