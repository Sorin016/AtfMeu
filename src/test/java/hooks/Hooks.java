package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepDefinition.Important.AbstractStepDefinifion;

import static driverManager.DriverManagerFactory.getDriver;
import static driverManager.DriverManagerFactory.quitDriver;
import static driverManager.DriverType.CHROME;
import static driverManager.DriverType.FIREFOX;


public class Hooks extends AbstractStepDefinifion {

    @Before("@UI")
    public void beforeTest() {
        getDriver(CHROME);
    }

    @After("@UI")
    public void afterTest() {
        quitDriver();
    }
}
