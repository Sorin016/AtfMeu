package stepDefinition;

import forDataTable.ErrorMessages;
import forDataTable.RegisterNewUserFields;
import forDataTable.Store;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import stepDefinition.Important.AbstractStepDefinifion;
import util.DataKey;

import java.util.List;
import java.util.Map;

import static actions.Actions.click;

import static actions.Actions.sendKey;
import static org.junit.Assert.*;
import static util.DataKey.USERNAME;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;
import static util.WaitUntil.waitUnitCondition;

public class RegisterNewUser extends AbstractStepDefinifion {
    private static Store store = new Store();

    @Given("User navigates to the home page")
    public void userNavigatesToTheHomePage() {

    }

    @And("User clicks on {} button")
    public void userClicksOnButton(String buttonName) throws InterruptedException {
        switch (buttonName) {
            case "Register":
                click(homePage.getRegisterLink());
                break;
            default:
                System.out.println("alegeti butonul potrivit");
        }

        assertEquals("Signing up is easy!",
                registerPage.getSigningUpIsEasyTextOnRegisterPage().getText());
    }

    @And("User insert all necessary information for register page")
    public void user_insert(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> testDataForRegistrationNewUser =
                dataTable.asMaps(String.class, String.class);
        if (dataTable.asMaps().get(0).keySet().contains("firstName")) {
            for (Map<String, String> colums : testDataForRegistrationNewUser) {
                store.addInputFieldsValues(new RegisterNewUserFields(
                        colums.get("firstName"),
                        colums.get("lastName"),
                        colums.get("address"),
                        colums.get("city"),
                        colums.get("state"),
                        colums.get("zipCode"),
                        colums.get("phone"),
                        colums.get("ssn")
                ));
                sendKey(registerPage.getFirstNameField(), colums.get("firstName"));
                sendKey(registerPage.getLastNameField(), colums.get("lastName"));
                sendKey(registerPage.getAddressField(), colums.get("address"));
                sendKey(registerPage.getCityField(), colums.get("city"));
                sendKey(registerPage.getStateField(), colums.get("state"));
                sendKey(registerPage.getZipCodeField(), colums.get("zipCode"));
                sendKey(registerPage.getPhoneField(), colums.get("phone"));
                sendKey(registerPage.getSsnField(), colums.get("ssn"));
                click(registerPage.getRegisterButton());
            }
        }
    }

    @And("User has {} message")
    public void useHrasErrorMessage(String errorMessage, DataTable dataTable) throws InterruptedException {
        if (errorMessage.equalsIgnoreCase("Complite all mandatory fields")) {
            List<Map<String, String>> errorsMessagesOnRegistrationPage =
                    dataTable.asMaps(String.class, String.class);

            for (Map<String, String> errorsMessages : errorsMessagesOnRegistrationPage) {
                store.addErrorMessageValues(new ErrorMessages(
                        errorsMessages.get("userNameIsRequired"),
                        errorsMessages.get("passwordIsRequired"),
                        errorsMessages.get("confirmPasswordIsRequired")
                ));
                assertEquals(errorsMessages.get("userNameIsRequired"),
                        errorsMessagesRegistrationPage.getUsernameErrorMessageOnRegisrationPage().getText());
                assertEquals(errorsMessages.get("passwordIsRequired"),
                        errorsMessagesRegistrationPage.getPasswordErrorMessageOnRegisrationPage().getText());
                assertEquals(errorsMessages.get("confirmPasswordIsRequired"),
                        errorsMessagesRegistrationPage.getRepeatPasswordErrorMessageOnRegisrationPage().getText());
            }
        }
    }

    @And("User insert {} and {}")
    public void userInsertFildAndFild(String userName, String password) throws InterruptedException {
        sendKey(registerPage.getUserNameField(), userName);
        sendKey(registerPage.getPasswordField(), password);
        sendKey(registerPage.getRepeatedPasswordField(), password);
        saveData(USERNAME, userName);
        saveData(DataKey.PASSWORD, password);
        click(registerPage.getRegisterButton());
    }

    @Then("User has a {}")
    public void userHasMessage(String successfulyRegistrationText) {
        successfulyRegistrationText = "Welcome " + getData(USERNAME);
        assertEquals(registerWithSuccessPage.getWelcomeText().getText(),successfulyRegistrationText);
        waitUnitCondition(registerWithSuccessPage.getWelcomeText());
    }
}
