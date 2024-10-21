package stepDefinition.API_Classes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import util.DataKey;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;
import static stepDefinition.Important.AbstractStepDefinifion.*;
import static util.DataKey.PASSWORD;
import static util.DataKey.USERNAME;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;

@Test
public class API_Login {

    RequestSpecification requestSpecification =
            new RequestSpecBuilder().setBaseUri(homePageUrl).addHeader("Content-Type", "application/json").build();
//    RequestSpecification basicAuth = new RequestSpecBuilder()
//            .addRequestSpecification(requestSpecification)  // Use baseSpec as a base
//            .addHeader(getData(USERNAME).toString(), getData(PASSWORD).toString())  // Add authentication header
//            .build();

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
    public void userOpensNewAccount(String accountType, int accountID,int customerID) {
        if (accountType.equalsIgnoreCase("saveing")) {
            given()
                    .spec(requestSpecification)
                    .when().auth().basic(getData(USERNAME).toString(), getData(PASSWORD).toString())
                    .queryParam("customerId", customerID)
                    .queryParam("newAccountType",0)
                    .queryParam("fromAccountId", accountID)
                    .post(APIOpenNewAccount)
                    .then()
                    .statusCode(SC_OK)
                    .log().all();
        } else {
            given()
                    .spec(requestSpecification)
                    .when().auth().basic(getData(USERNAME).toString(), getData(PASSWORD).toString())
                    .queryParam("customerId", customerID)
                    .queryParam("newAccountType", 1)
                    .queryParam("fromAccountId", accountID)
                    .post("/parabank/services_proxy/bank/createAccount")
                    .then()
                    .statusCode(SC_OK)
                    .log().all();
        }

    }

}
