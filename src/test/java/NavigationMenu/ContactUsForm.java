package NavigationMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactUsForm {

    @Test
    public void formFill(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");

    }
}
