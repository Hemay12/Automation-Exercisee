package Footer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FooterOfCartPage {

    @Test
    public void cartFooter(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        Assert.assertEquals("https://automationexercise.com/view_cart",driver.getCurrentUrl());

        WebElement x = driver.findElement(By.xpath("//div[@class='single-widget']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",x);

        String str = x.findElement(By.xpath("./h2")).getText();
        Assert.assertEquals("SUBSCRIPTION",str);


        driver.findElement(By.id("susbscribe_email")).sendKeys("dumy@gmail.com");
        WebElement arrow = driver.findElement(By.id("subscribe"));
        arrow.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("success-subscribe"))));
        String success = driver.findElement(By.id("success-subscribe")).getText();

        System.out.println(success);
    }
}
