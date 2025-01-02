package LoginLogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUser {

    @Test(groups = "Login")
    public void login(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        String str = driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
        Assert.assertEquals("Login to your account",str);

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dummyuser321012@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Dummy@123");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        WebElement usernameElement = driver.findElement(By.xpath("//li//b"));
        String username = usernameElement.getText();

        String fullText = driver.findElement(By.xpath("//li[contains(., 'Logged in as')]")).getText();

        String expectedText = "Logged in as " + username;
        Assert.assertEquals(fullText, expectedText);

        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        String acc_delete = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        Assert.assertEquals("Account Deleted!",acc_delete);

    }
}
