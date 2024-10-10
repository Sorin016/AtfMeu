package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends PageObject {

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;


    public HomePage(WebDriver driver) {
        super(driver);
    }
}
