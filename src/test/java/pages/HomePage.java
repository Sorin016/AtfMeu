package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class HomePage extends PageObject{

    @FindBy(xpath = "//h1[@class='title' and normalize-space(text())='Accounts Overview']")
    WebElement accountQverviewHomePageText;

    @FindBy(xpath = "//a[@href='openaccount.htm' and text()='Open New Account']")
    WebElement openNewAccountHomeLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
