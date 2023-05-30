package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _10_TGRadioButtonTest extends Base{

    /*

    TEST CASE 1
Go to https://techglobal-training.com/frontend/
Click on the "Radio Buttons" card
Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
Select "Java" and validate it is selected but the other 2 are deselected
Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElements(By.id("card-6"));


    }
    @Test
    public void radioButtonTest(){
        List<WebElement> buttonLabels = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
        List<WebElement> buttonInput= driver.findElements(By.cssSelector("#radio-button-group_1 label"));

        buttonInput.forEach(radioButtonTest-> {
            Assert.assertTrue(radioButtonTest.isDisplayed());
            Assert.assertFalse(radioButtonTest.isSelected());
            Assert.assertTrue(radioButtonTest.isEnabled());
        });


    }
}
