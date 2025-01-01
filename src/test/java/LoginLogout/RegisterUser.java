package LoginLogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser {

    @Test (groups = "Login")
    public void userRegisteration(){

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        driver.findElement(By.cssSelector("a[href='/login']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Charles");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("");
    }
}
