package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterWithSuccessPage extends PageObject{

    @FindBy(xpath = "//h1[@class='title' and contains(text(),'Welcome')]")
    WebElement welcomeText;

    @FindBy(xpath = "//p[starts-with(text(),'Your account was created successfully')]")
    WebElement yourAccountWasCreatedSuccessfullyText;

    public RegisterWithSuccessPage(WebDriver driver) {
        super(driver);
    }
}
