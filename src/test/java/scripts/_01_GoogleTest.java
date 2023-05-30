package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest {

    /*

    Go to https://www.Google.com/
    Validate that the user sees a search input box
     */

    @Test
    public void validateSearchBar()throws InterruptedException{
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver

        WebDriver driver = new ChromeDriver(); // Launch a Chrome Driver

        driver.manage().window().maximize(); //makes the window maximized
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // this will wait for element to wait to be displayed for 30 seonds

        driver.get("https://www.google.com/");

        WebElement searchInputBox = driver.findElement(By.id("APjFqb"));
        Assert.assertTrue(searchInputBox.isDisplayed()); // assert means validate

        Thread.sleep(5000);

        driver.quit();
    }
}
