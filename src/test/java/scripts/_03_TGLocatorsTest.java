package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _03_TGLocatorsTest {

    /*
    Test Case 1:

    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "kiwi" paragraph //assert is another keyword for validate

     */
    public static WebDriver driver; // declaration

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(); // initialization

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://techglobal-training.com/frontend/locators");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void validateKiwiParagraph(){
        WebElement kiwi_paragraph = driver.findElement(By.id("item_kiwi"));

        Assert.assertTrue(kiwi_paragraph.isDisplayed());
        Assert.assertEquals(kiwi_paragraph.getText(), "Kiwi"); //expectation is Kiwi
    }

    /*

   Test case 2:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Orange" Paragraph
     */

    @Test
    public void validateOrangeParagraph(){
        WebElement orange_paragraph = driver.findElement(By.name("item_orange"));

        Assert.assertTrue(orange_paragraph.isDisplayed());
        Assert.assertEquals(orange_paragraph.getText(), "Orange");

        System.out.println(orange_paragraph.getText()); //Orange
        System.out.println(orange_paragraph.getAttribute("name"));


    }

    /*
    Test Case 3:

    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Grapes" paragraph

     */

    @Test
    public void validateGrapesParagraph(){
        WebElement grapes_paragraph = driver.findElement(By.className("item_grapes"));
        Assert.assertTrue(grapes_paragraph.isDisplayed());
        Assert.assertEquals(grapes_paragraph.getText(), "Grapes");

    }

    /*
    Test Case 4:

    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Kiwi", "Grapes", "Orange" paragraph

     */

    @Test

    public void validateAllParagraphs() {

        List<WebElement> allParagraphs = driver.findElements(By.tagName("p"));

        System.out.println(allParagraphs.size());// 5
        String[] expectedTexts = {"Kiwi", "Orange", "Grapes"};
        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allParagraphs.get(i).isDisplayed());
            Assert.assertEquals(allParagraphs.get(i).getText(), expectedTexts[i]);
        }


    }

     /*
    Test Case 5:

    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Red Apple" link (displayed and enabled)
    Validate it navigates user to the "https://en.wikipedia.org/wiki/Red_apple"


     */
}
