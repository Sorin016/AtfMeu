package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountDetailsPage extends PageObject{

    @FindBy (xpath = "//h1[@class='title' and text()='Account Details']")
    WebElement accountDetailsText;

    @FindBy (xpath = "//td[@id='accountType']")
    WebElement accountType;

    @FindBy (xpath = "//td[@id='accountId']")
    WebElement accountId;

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }
}
