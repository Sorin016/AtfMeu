package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ErrorsMessagesRegistrationPage extends PageObject {
    @FindBy(xpath = "//span[@id='customer.username.errors']")
    WebElement usernameErrorMessageOnRegisrationPage;

    @FindBy(xpath = "//span[@id='customer.password.errors']")
    WebElement passwordErrorMessageOnRegisrationPage;

    @FindBy(xpath = "//span[@id='repeatedPassword.errors']")
    WebElement repeatPasswordErrorMessageOnRegisrationPage;

    public ErrorsMessagesRegistrationPage(WebDriver driver) {
        super(driver);
    }
}
