package stepDefinition.Important;

import org.openqa.selenium.WebDriver;
import pages.*;
import util.PropretyLoader;


public class AbstractStepDefinifion {
    protected static WebDriver driver;
    protected static String chromeDriver = PropretyLoader.loadProperty("chromeDriver");
    protected static String geckodriver = PropretyLoader.loadProperty("geckodriver");
    public static String homePageUrl = PropretyLoader.loadProperty("homePageUrl");
    public static String APILogin = PropretyLoader.loadProperty("APILogin");
    public static String APIOpenNewAccount = PropretyLoader.loadProperty("APIOpenNewAccount");
    public static String APIAccountsOverview = PropretyLoader.loadProperty("APIAccountsOverview");


    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);
    public OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver);
    public RegisterPage registerPage = new RegisterPage(driver);
    public ErrorsMessagesRegistrationPage errorsMessagesRegistrationPage = new ErrorsMessagesRegistrationPage(driver);
    public RegisterWithSuccessPage registerWithSuccessPage = new RegisterWithSuccessPage(driver);
    public AccountOpenedPage accountOpenedPage=new AccountOpenedPage(driver);
    public AccountDetailsPage accountDetailsPage=new AccountDetailsPage(driver);

}
