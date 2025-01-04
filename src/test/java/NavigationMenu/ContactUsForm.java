package NavigationMenu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsForm {

    @Test
    public void formFill(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        String get = driver.findElement(By.xpath("//div[@class='contact-form']/h2")).getText();
        Assert.assertEquals("GET IN TOUCH",get);

        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("ABC");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("dummy@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("SUbject");
        driver.findElement(By.xpath("//textarea[@data-qa='message']")).sendKeys("message");

        WebElement fileInput = driver.findElement(By.xpath("//input[@name='upload_file']"));
        fileInput.sendKeys("C:\\Users\\rites\\Downloads\\sample.jpg");
        Actions action = new Actions(driver);
        WebElement x = driver.findElement(By.xpath("//input[@data-qa='submit-button']"));
        action.moveToElement(x).click().perform();

        Alert al = driver.switchTo().alert();
        al.accept();

        String success = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",success);

        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
    }
}
