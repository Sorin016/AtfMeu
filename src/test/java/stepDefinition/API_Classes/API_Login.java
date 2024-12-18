package stepDefinition.API_Classes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import util.DataKey;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;
import static stepDefinition.Important.AbstractStepDefinifion.*;
import static util.DataKey.*;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;

@Test
public class API_Login {

    RequestSpecification requestSpecification =
            new RequestSpecBuilder()
                    .setBaseUri(homePageUrl)
                    .addHeader("Content-Type", "application/json")
                    .build();

    @Given("User login on the site with {} and {}")
    public void userLoginOnTheSite(String username, String password) {

        saveData(USERNAME, username);
        saveData(PASSWORD, password);
        given()
                .spec(requestSpecification)
                .when()
                .queryParam("username", username)
                .queryParam("password", password)
                .get(APILogin)
                .then()
                .statusCode(SC_OK)
                .log().all();
    }

    @And("User opens new {} and {} for {}")
    public void userOpensNewAccount(String accountType, int accountID, int customerID) {
        if (accountType.equalsIgnoreCase("saveing")) {
            given()
                    .spec(requestSpecification)
                    .when().auth().basic(getData(USERNAME).toString(), getData(PASSWORD).toString())
                    .queryParam("customerId", customerID)
                    .queryParam("newAccountType", 1)
                    .queryParam("fromAccountId", accountID)
                    .post(APIOpenNewAccount)
                    .then()
                    .statusCode(SC_OK)
                    .log().all();
            saveData(API_CUSTOMER_ID, customerID);
        } else {
            given()
                    .spec(requestSpecification)
                    .when().auth().basic(getData(USERNAME).toString(), getData(PASSWORD).toString())
                    .queryParam("customerId", customerID)
                    .queryParam("newAccountType", 0)
                    .queryParam("fromAccountId", accountID)
                    .post("/parabank/services_proxy/bank/createAccount")
                    .then()
                    .statusCode(SC_OK)
                    .log().all();
            saveData(API_CUSTOMER_ID, customerID);
        }
        saveData(API_ACCOUNT_TYPE, accountType);


    }

    @When("User checks that new account was created with success")
    public void userChecksThatNewAccountWasCreatedWithSuccess() {
        given()
                .spec(requestSpecification)
                .when().auth().basic(getData(USERNAME).toString(), getData(PASSWORD).toString())
                .get(APIAccountsOverview + getData(API_CUSTOMER_ID) + "/accounts")
                .then()
                .body("customerId[1]", equalTo(getData(API_CUSTOMER_ID)))
                .statusCode(SC_OK)
                .log().all();
        assertTrue(given()
                .spec(requestSpecification)
                .when().auth().basic(getData(USERNAME).toString(), getData(PASSWORD).toString())
                .get(APIAccountsOverview + getData(API_CUSTOMER_ID) + "/accounts").body().prettyPrint().toString()
                .equalsIgnoreCase(getData(API_ACCOUNT_TYPE).toString()));
    }

}
