package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.Important.AbstractStepDefinifion;


public class PageObject extends AbstractStepDefinifion {
    protected static WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
