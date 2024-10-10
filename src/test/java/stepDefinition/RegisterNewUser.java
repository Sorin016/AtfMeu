package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import stepDefinition.Important.AbstractStepDefinifion;

import static actions.Actions.click;
import static actions.Actions.sendKey;
import static org.junit.Assert.*;

public class RegisterNewUser extends AbstractStepDefinifion {

    @Given("User navigates to the home page")
    public void userNavigatesToTheHomePage() {

    }
    @And("User clicks on {} button")
    public void userClicksOnButton(String buttonName) throws InterruptedException {
        switch (buttonName){
            case "Register":
                click(homePage.getRegisterLink());
                break;
            default:
                System.out.println("alegeti butonul potrivit");
        }

        assertEquals("Signing up is easy!" ,
                registerPage.getSigningUpIsEasyTextOnRegisterPage().getText());
    }
    @And("User insert {},{}")
    public void user_insert(String firstName,String lastName,String city,String address){
            sendKey(registerPage.getFirstNameField(),firstName);
            sendKey(registerPage.getLastNameField(),lastName);
            sendKey(registerPage.getAddressField(),address);
            sendKey(registerPage.getCityField(),city);
//            sendKey(registerPage.getLastNameField(),lastName);
//            sendKey(registerPage.getLastNameField(),lastName);
//            sendKey(registerPage.getLastNameField(),lastName);
//            sendKey(registerPage.getLastNameField(),lastName);
    }

}
