package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends PageObject {

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//input[@class='button' and @value='Log In']")
    WebElement loginButtonHomePage;

    @FindBy(xpath = "//input[@class='input' and @name='username']")
    WebElement usernameFileHomePage;

    @FindBy(xpath = "//input[@class='input' and @name='password']")
    WebElement passwordFileHomePage;



    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
