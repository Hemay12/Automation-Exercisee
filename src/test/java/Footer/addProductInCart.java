package Footer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class addProductInCart {

    @Test
    public void addProduct() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement x = driver.findElement(By.xpath("//div[@class='productinfo text-center']"));
        js.executeScript("arguments[0].scrollIntoView(true)",x);
        Actions actions = new Actions(driver);
        actions.moveToElement(x).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default add-to-cart']")));
        addToCartButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"))));
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();


//        driver.findElement(By.xpath("a[@data-product-id='2']"));
    }
}
