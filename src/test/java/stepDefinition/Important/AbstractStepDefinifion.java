package stepDefinition.Important;

import actions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import util.PropretyLoader;

import java.util.logging.Logger;

public class AbstractStepDefinifion  {
    protected static WebDriver driver;
    protected static String chromeDriver = PropretyLoader.loadProperty("chromeDriver");
    protected static String geckodriver = PropretyLoader.loadProperty("geckodriver");
    protected static String homePageUrl = PropretyLoader.loadProperty("homePageUrl");


    public HomePage homePage=new HomePage(driver);

}
