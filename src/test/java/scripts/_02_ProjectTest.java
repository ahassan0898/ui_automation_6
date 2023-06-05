package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;

public class _02_ProjectTest extends Base {


    @BeforeMethod
    public void setUp(){
      driver.get("Navigate to https://techglobal-training.com/frontend/project-2");

    }


    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Validate that the username input box is displayed
Validate that the username input box is not required
Validate that the label of the username input box is “Please enter your username”
Validate that the password input box is displayed
Validate that the password input box is not required
Validate that the label of the password input box is “Please enter your password”
Validate the “LOGIN” button is displayed
Validate the “LOGIN” button is clickable
Validate that the button text is “LOGIN”
Validate the “Forgot Password?” link is displayed
Validate that the “Forgot Password?” link is clickable
Validate that the link text is “Forgot Password?”
     */

    @Test (priority = 1)
    public void validateUserNameInputBox(){

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement labelUsernameBox = driver.findElement(By.cssSelector( "div:nth-child(1) > label"));
        WebElement labelPasswordBox = driver.findElement(By.cssSelector("div:nth-child(2) > label"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3) > a"));

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertNotEquals(usernameInputBox.getAttribute("required"), "true");
        Assert.assertEquals(labelUsernameBox.getText(),"Please enter your username");
        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertNotEquals(passwordInputBox.getAttribute("required"), "true");
        Assert.assertEquals(labelPasswordBox.getText(),"Please enter your password");
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(),"LOGIN");

        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(),"Forgot Password?");
    }



    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “TechGlobal”
Enter the password as “Test1234”
Click on the “LOGIN” button
Validate the success message is displayed as “You are logged in”
Validate the logout button displayed with the text “LOGOUT”
     */
    @Test (priority = 2)
    public void validateUsernameAndPassword(){

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));


        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();

        WebElement successMessage = driver.findElement(By.id("success_lgn"));

        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(successMessage.getText(),"You are logged in");

        WebElement logoutButton = driver.findElement(By.id("logout"));
        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertEquals(logoutButton.getText(),"LOGOUT");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “TechGlobal”
Enter the password as “Test1234”
Click on the “LOGIN” button
Click on the “LOGOUT” button
Validate that the login form is displayed
     */


    @Test (priority = 3)

    public void validateInputUsernameAndPassword(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));


       usernameInputBox.sendKeys("TechGlobal");
       passwordInputBox.sendKeys("Test1234");
       loginButton.click();



        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();

        WebElement loginForm = driver.findElement(By.cssSelector("div>form"));
        Assert.assertTrue(loginForm.isDisplayed());
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Click on the “Forgot Password?” link
Validate that the modal heading “Reset Password” is displayed
Validate that the close button is displayed
Validate that the email input box is displayed
Validate that the label of the email input box is “Enter your email address and we'll send you a link to reset your password.”
Validate the “SUBMIT” button is displayed
Validate the “SUBMIT” button is clickable
Validate that the button text is “SUBMIT”
     */

    @Test (priority = 4)
    public void validateForgotPasswordLink(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3) > a"));
        forgotPassword.click();

        WebElement modalHeading = driver.findElement(By.id("modal_title"));
        WebElement closeBtn = driver.findElement(By.cssSelector("header button"));
        WebElement emailInputBox = driver.findElement(By.id("email"));
        WebElement inputBoxLabel = driver.findElement(By.cssSelector("section label"));
        WebElement submitBtn = driver.findElement(By.id("submit"));

        Assert.assertTrue(modalHeading.isDisplayed());
        Assert.assertTrue(closeBtn.isDisplayed());
        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertEquals(inputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(submitBtn.isDisplayed());
        Assert.assertTrue(submitBtn.isEnabled());
        Assert.assertEquals(submitBtn.getText(), "SUBMIT");


    }


    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Click on the “Forgot Password?” link
Validate that the “Reset Password” modal is displayed
Click on the close button
Validate that the “Reset Password” modal is closed
     */

    @Test (priority = 5)
    public void resetPassword(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3) > a"));
        forgotPassword.click();

        WebElement resetModal = driver.findElement(By.cssSelector(".modal-card"));
        Assert.assertTrue(resetModal.isDisplayed());

        WebElement closeBtn = driver.findElement(By.cssSelector("header button"));
        closeBtn.click();

        Assert.assertTrue(resetModal.isDisplayed());
    }



    /*

    Navigate to https://techglobal-training.com/frontend/project-2
Click on the “Forgot Password?” link
Enter an email
Click on the “SUBMIT” button
Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button
     */


    @Test (priority = 6)

    public void enterEmailLinkForResetPassword(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        emailInput.sendKeys("aabcd@gmail.com");
        submitBtn.click();

        WebElement resetFormMessage = driver.findElement(By.cssSelector("section p"));
        Assert.assertTrue(resetFormMessage.isDisplayed());
        Assert.assertEquals(resetFormMessage.getText(), "A link to reset your password has been sent to your email address.");

    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Leave username empty
Leave password empty
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Username entered!” above the form
     */


    @Test (priority = 7)

    public void emptyCredentials(){
        WebElement loginBtn = driver.findElement(By.id("login_btn"));
        loginBtn.click();
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “John”
Enter the password as “Test1234”
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Username entered!” above the form
     */

    @Test (priority = 8)

    public void validateFailureMessageForInvalidUsername(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("Test1234");
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “TechGlobal”
Enter the password as “1234”
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Password entered!” above the form
     */


    @Test (priority = 9)
    public void validateFailureMessageForInvalidPassword(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));


        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("1234");
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Password entered!");
    }

    /*
Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “John”
Enter the password as “1234”
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Username entered!” above the form
     */


    @Test (priority = 10)
    public void validateFailureMessage(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login_btn"));


        usernameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("1234");
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }


}
