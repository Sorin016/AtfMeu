package stepDefinition.Important;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import util.PropretyLoader;

import java.util.logging.Logger;

public class AbstractStepDefinifion  {
    protected static WebDriver driver;
    protected static String chromeDriver = PropretyLoader.loadProperty("chromeDriver");
    protected static String geckodriver = PropretyLoader.loadProperty("geckodriver");
    protected static String homePageUrl = PropretyLoader.loadProperty("homePageUrl");


    public HomePage homePage=new HomePage(driver);
    public RegisterPage registerPage=new RegisterPage(driver);

}
