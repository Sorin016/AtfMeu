package util;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class WaitUntil {

    private static long DEFAULT_RETRY_INTERVAL_MS = 2000;

    public static void waitForRetry(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static Object waitUnitCondition(WebElement condition) {
        if (condition.isDisplayed() == true)
            waitForRetry(DEFAULT_RETRY_INTERVAL_MS);
        return null;
    }
}
