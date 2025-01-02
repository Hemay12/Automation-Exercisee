package LoginLogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterExistingUser {

    @Test(groups ="login")
    public void registerExistingUserMethod(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String str = driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
        Assert.assertEquals("Login to your account",str);

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Charles");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("dummy321012@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        String incorrectString = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        Assert.assertEquals("Email Address already exist!",incorrectString);

        driver.quit();
    }
}
