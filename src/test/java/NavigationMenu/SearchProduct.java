package NavigationMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchProduct {

    @Test
    public void Product(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Assert.assertEquals("https://automationexercise.com/products",driver.getCurrentUrl());

        driver.findElement(By.id("search_product")).sendKeys("Jeans");
        driver.findElement(By.id("submit_search")).click();

        String str = driver.findElement(By.xpath("//div[@class='features_items']/h2")).getText();
        Assert.assertEquals("SEARCHED PRODUCTS",str);

        boolean x = false;
        List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if(wait.until(ExpectedConditions.visibilityOf(list_products.get(0))).isDisplayed()){
            x =true;
        };

        Assert.assertTrue(x,"NOT visible ");
    }
}
