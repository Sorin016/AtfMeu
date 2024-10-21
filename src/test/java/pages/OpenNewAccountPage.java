package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class OpenNewAccountPage extends PageObject {

    @FindBy(xpath = "//h1[@class='title' and text()='Open New Account']")
    WebElement openNewAccountText;

    @FindBy(xpath = "//select[@id='type' and @class='input' or text()='CHECKING']//option[1]")
    WebElement openNewCheckingAccount;

    @FindBy(xpath = "//select[@id='type' and @class='input' or text()='SAVINGS']//option[2]")
    WebElement openNewSaveingAccount;

    @FindBy(xpath = "//select[@id='fromAccountId' and @class='input']//option[last()]")
    WebElement accouuntFromWhereNewAccountWillBeCreated;

    @FindBy(xpath = "//input[@class='button' and @value='Open New Account']")
    WebElement openNewAccountButton;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }
}
