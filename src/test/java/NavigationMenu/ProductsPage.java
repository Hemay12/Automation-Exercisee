package NavigationMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    @Test
    public void products(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Assert.assertEquals("https://automationexercise.com/products",driver.getCurrentUrl());

        List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        Assert.assertTrue(!list_products.isEmpty(),"The product list is empty!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(list_products.get(0)));

        WebElement firstProduct = list_products.get(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);

        WebElement addToCartButton = firstProduct.findElement(By.xpath(".//a[@class='btn btn-default add-to-cart']"));
        addToCartButton.click();

        Assert.assertEquals("https://automationexercise.com/product_details/1",driver.getCurrentUrl());

        WebElement name = driver.findElement(By.xpath("//div[@class='product-information']/p[text()='Category: Women > Tops']"));
        wait.until(ExpectedConditions.visibilityOf(name));
        Assert.assertTrue(name.isDisplayed());

        WebElement cat = driver.findElement(By.xpath("//div[@class='product-information']/scan/scan[text() = 'Rs. 500']"));
        wait.until(ExpectedConditions.visibilityOf(cat));
        Assert.assertTrue(cat.isDisplayed());

//        WebElement name = driver.findElement(By.xpath("//div[@class='product-information']/h2"));
//        wait.until(ExpectedConditions.visibilityOf(name));
//        Assert.assertTrue(name.isDisplayed());
    }
}
