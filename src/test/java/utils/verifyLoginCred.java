package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class verifyLoginCred {

    public static void verifyCurrentUrl(WebDriver driver, String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL does not match the expected value.");
    }

}
