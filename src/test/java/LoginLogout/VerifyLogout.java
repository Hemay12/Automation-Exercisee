package LoginLogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.verifyLoginCred.verifyCurrentUrl;

public class VerifyLogout {

    @Test(groups = "login")
    public void logout(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        verifyCurrentUrl(driver,"https://automationexercise.com/");

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        String str = driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
        Assert.assertEquals("Login to your account",str);

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dummyuserrr321012@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Dummy@123");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        Assert.assertEquals("https://automationexercise.com/login",driver.getCurrentUrl());
        driver.quit();

    }
}