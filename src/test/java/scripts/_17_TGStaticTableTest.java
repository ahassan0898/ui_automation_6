package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_TGStaticTableTest extends Base{


    @BeforeMethod
    public void setPage(){
       driver.get("https://techglobal-training.com/frontend");
       driver.findElement(By.id("card-11")).click();
    }
        /*

        TEST CASE 1
    Verify the headers of the table
    Go to https://techglobal-training.com/frontend/
    Click on the "Static Tables" card
    Check that the headers of the table are "Rank", "Company", "Employees", and "Country"
    Verify the rows of the table
         */


    @Test
    public void validateTableHeader(){

        List<WebElement> tableHeader = driver.findElements(By.cssSelector(".header"));
        String [] expectedResults = {"Rank", "Company", "Employees", "Country"};

        for (int i = 0; i < tableHeader.size(); i++) {
            Assert.assertEquals(tableHeader.get(i).getText(), expectedResults);
        }

    }


            /*

            TEST CASE 2
        Go to https://techglobal-training.com/frontend/
        Click on the "Static Tables" card
        Check that the first row of the table has the values "1", "Amazon", "1,523,000", and "USA"
        Verify the columns of the table
             */

    @Test
    public void validateFirstRow(){
        List<WebElement> rowOne = driver.findElements(By.cssSelector("tr:first-child td"));
        String[] expectedResults = {"1", "Amazon", "1,523,000", "USA"};

        for(int i = 0; i < rowOne.size(); i++){
            Assert.assertEquals(rowOne.get(i).getText(), expectedResults[i]);
        }
    }


            /*

            TEST CASE 3
        Go to https://techglobal-training.com/frontend/
        Click on the "Static Tables" card
        Check that the "Country" column of the table has the values "USA", "China", "USA", "USA", "S. Korea"
        Verify the entire table
             */

    @Test
    public void validateCountryColumn(){

        List<WebElement> column = driver.findElements(By.cssSelector("td:last-child"));

        String[] expectedResult = {"USA", "China", "USA", "USA", "S. Korea"};

        for (int i = 0; i < column.size(); i++) {
            Assert.assertEquals(column.get(i).getText(), expectedResult[i]);
        }
    }

    @Test
    public void validateEachCell(){
        WebElement mainTable = driver.findElement(By.id("company_table"));
        List<List<WebElement>> tableData = TableHandler.getTableData(mainTable);

        for (List<WebElement> row: tableData){
            for (WebElement cell : row){
                System.out.println(cell.getText());
            }
        }

        List<List<String>> table = new ArrayList<>();
        table.add(Arrays.asList("1" , "Amazon", "1,523,00", "USA"));
    }
}
