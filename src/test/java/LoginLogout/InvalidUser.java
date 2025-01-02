package LoginLogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidUser {

    @Test(groups = "Login")
    public void InvalidUserVerify(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String str = driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
        Assert.assertEquals("Login to your account",str);

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dummy321012@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Dummy@123");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        String incorrectString = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        Assert.assertEquals("Your email or password is incorrect!",incorrectString);
    }
}