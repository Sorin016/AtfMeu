package stepDefinition.UI_Classes;

import io.cucumber.java.en.And;
import stepDefinition.Important.AbstractStepDefinifion;

import static actions.Actions.*;
import static org.junit.Assert.assertEquals;
import static util.DataKey.*;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;
import static util.WaitUntil.waitForRetry;
import static util.WaitUntil.waitUnitCondition;

public class OpenNewAccount extends AbstractStepDefinifion {
    @And("User find and inserts {} and {}")
    public void userInsertVlidsFildAndFild(String userName, String password) throws InterruptedException {
        sendKey(loginPage.getUsernameFileHomePage(), userName);
        sendKey(loginPage.getPasswordFileHomePage(), password);
        saveData(USERNAME, userName);
        saveData(PASSWORD, password);
    }

    @And("User select {}")
    public void userSelectAccountType(String accountType) throws InterruptedException {
        if (accountType.equalsIgnoreCase("CHECKING")) {
            click(openNewAccountPage.getOpenNewCheckingAccount());
            waitUnitCondition(openNewAccountPage.getOpenNewCheckingAccount());
            saveData(ACCOUNT_TYPE, accountType);
        } else {
            click(openNewAccountPage.getOpenNewSaveingAccount());
            waitUnitCondition(openNewAccountPage.getOpenNewSaveingAccount());
            saveData(ACCOUNT_TYPE, accountType);
        }
    }

    @And("User choose last existing account to transfer funds into the new account")
    public void useChooseLastExistingAccountToTransferFundsIntoTheNewAccount() throws InterruptedException {
        click(openNewAccountPage.getAccouuntFromWhereNewAccountWillBeCreated());
    }

    @And("User has opened an account")
    public void userHasOpenedAnAccount() {
        isDisplayed(accountOpenedPage.getAccountOpenedText());
        isDisplayed(accountOpenedPage.getCongratulationsYourAccountIsNowOpenText());
        isDisplayed(accountOpenedPage.getYourNewAccountNumberText());
        saveData(NEW_OPENED_ACCOUNT, accountOpenedPage.getYourNewAccountNumber().getText());
    }

    @And("User checks the new account details")
    public void userChecksTheNewAccountDetails() throws InterruptedException {
        click(accountOpenedPage.getYourNewAccountNumber());
        waitUnitCondition(accountDetailsPage.getAccountDetailsText());
        isDisplayed(accountDetailsPage.getAccountDetailsText());
        waitForRetry(3000);
        String accountId =getData(NEW_OPENED_ACCOUNT).toString() ;
        String accountType = getData(ACCOUNT_TYPE).toString();

        assertEquals(accountId, accountDetailsPage.getAccountId().getText());
        assertEquals(accountType,accountDetailsPage.getAccountType().getText());
    }
}
