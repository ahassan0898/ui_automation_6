package testng_knowledge;

import org.testng.annotations.Test;

public class _02_Test_Dependency {


    @Test (priority = 2, dependsOnMethods = "test2")
    public void test1(){
        System.out.println("This is test1");

    }

    @Test
    public void test2(){
        System.out.println("This is test2");
    }

    @Test
    public void test3(){
        System.out.println("This is test3");
    }
}
