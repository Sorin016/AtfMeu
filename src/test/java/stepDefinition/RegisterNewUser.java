package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import stepDefinition.Important.AbstractStepDefinifion;

import static actions.Actions.click;

public class RegisterNewUser extends AbstractStepDefinifion {

    @Given("User navigates to the home page")
    public void userNavigatesToTheHomePage() {

    }
    @And("User clicks on {} button")
    public void userClicksOnButton() {
        click(homePage.registerLink());
    }
    @And("User insert")
    public void user_insert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
