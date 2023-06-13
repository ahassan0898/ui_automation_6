package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _04_Soft_Hard_Assertions {


    @Test
    public void test1(){

        Assert.assertEquals("hello", "world");
        System.out.println("The rest of the test");
    }

    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("hello", "world");
        System.out.println("The rest of the test");
        softAssert.assertAll();
    }
}
