package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage extends PageObject {
    @FindBy(xpath = "//*[@class='title' and text()='Signing up is easy!']")
    WebElement signingUpIsEasyTextOnRegisterPage;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    WebElement addressField;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    WebElement stateField;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    WebElement ssnField;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
