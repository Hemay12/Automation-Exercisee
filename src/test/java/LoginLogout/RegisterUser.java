package LoginLogout;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterUser {

    @Test (groups = "Login")
    public void userRegisteration(){

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        driver.findElement(By.cssSelector("a[href='/login']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Charles");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("dummyuser321012@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='radio']"))));
        driver.findElement(By.xpath("//input[@type='radio']")).click();
        String x = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).getText();
        Assert.assertEquals(x,"ENTER ACCOUNT INFORMATION");
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Dummy@123");
        Select days = new Select(driver.findElement(By.id("days")));
        Select month = new Select(driver.findElement(By.id("months")));
        Select year = new Select(driver.findElement(By.id("years")));
        days.selectByIndex(10);
        month.selectByValue("10");
        year.selectByValue("1998");
        driver.findElement(By.id("first_name")).sendKeys("Dummy");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("address1")).sendKeys("India");
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("India");
        driver.findElement(By.id("state")).sendKeys("Gujarat");
        driver.findElement(By.id("city")).sendKeys("Gujarat");
        driver.findElement(By.id("zipcode")).sendKeys("788978");
        driver.findElement(By.id("mobile_number")).sendKeys("7889785624");
        Actions ac = new Actions(driver);
//        WebElement ele = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        ac.sendKeys(Keys.TAB).perform();
        ac.sendKeys(Keys.ENTER).perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-qa='continue-button']"))));
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"))));
//        String x1 = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).getText();
//        Assert.assertEquals(x1,"ACCOUNT CREATED!");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-success']"))));
        WebElement usernameElement = driver.findElement(By.xpath("//li//b"));
        String username = usernameElement.getText();

        String fullText = driver.findElement(By.xpath("//li[contains(., 'Logged in as')]")).getText();
        String loggedInAs = fullText.split(username)[0].trim();

        String combined = loggedInAs + username;
        Assert.assertEquals("Logged in as" + username, combined);

        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();


    }
}
