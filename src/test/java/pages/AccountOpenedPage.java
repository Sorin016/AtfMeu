package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountOpenedPage extends PageObject {

    @FindBy(xpath = "//h1[@class='title' and text()='Account Opened!']")
    WebElement accountOpenedText;

    @FindBy(xpath = "//p[text()='Congratulations, your account is now open.']")
    WebElement congratulationsYourAccountIsNowOpenText;

    @FindBy(xpath = "//b[text()='Your new account number:']")
    WebElement yourNewAccountNumberText;

    @FindBy(xpath = "//a[@id='newAccountId']")
    WebElement yourNewAccountNumber;

    public AccountOpenedPage(WebDriver driver) {
        super(driver);
    }
}
