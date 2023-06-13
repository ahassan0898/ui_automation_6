package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project2Page;
import utils.Driver;

public class _02_ProjectTest extends Base {


    @BeforeMethod
    public void setUp(){
      driver.get("Navigate to https://techglobal-training.com/frontend/project-2");
        project2Page = new Project2Page();
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

            Assert.assertTrue(project2Page.usernameInputBox.isDisplayed());
            Assert.assertTrue(project2Page.usernameInputBox.isEnabled());
            Assert.assertNotEquals(project2Page.usernameInputBox.getAttribute("required"), "true");
            Assert.assertTrue(project2Page.usernameInputBoxLabel.isDisplayed());
            Assert.assertEquals(project2Page.usernameInputBoxLabel.getText(), "Please enter your username");

            Assert.assertTrue(project2Page.passwordInputBox.isDisplayed());
            Assert.assertTrue(project2Page.passwordInputBox.isEnabled());
            Assert.assertNotEquals(project2Page.passwordInputBox.getAttribute("required"), "true");
            Assert.assertTrue(project2Page.passwordInputBoxLabel.isDisplayed());
            Assert.assertEquals(project2Page.passwordInputBoxLabel.getText(), "Please enter your password");

            Assert.assertTrue(project2Page.loginButton.isDisplayed());
            Assert.assertTrue(project2Page.loginButton.isEnabled());
            Assert.assertEquals(project2Page.loginButton.getText(), "LOGIN");

            Assert.assertTrue(project2Page.forgotPasswordLink.isDisplayed());
            Assert.assertTrue(project2Page.forgotPasswordLink.isEnabled());
            Assert.assertEquals(project2Page.forgotPasswordLink.getText(), "Forgot Password?");
        }



    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “TechGlobal”
Enter the password as “Test1234”
Click on the “LOGIN” button
Validate the success message is displayed as “You are logged in”
Validate the logout button displayed with the text “LOGOUT”
     */
    @Test(priority = 2, description = "Test Case 02 - Validate the valid login")
    public void validateTheValidLogin(){
        project2Page.login("TechGlobal", "Test1234");

        Assert.assertTrue(project2Page.successfulLoginMessage.isDisplayed());
        Assert.assertEquals(project2Page.successfulLoginMessage.getText(), "You are logged in");

        Assert.assertTrue(project2Page.logoutButton.isDisplayed());
        Assert.assertTrue(project2Page.logoutButton.isEnabled());
        Assert.assertEquals(project2Page.logoutButton.getText(), "LOGOUT");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “TechGlobal”
Enter the password as “Test1234”
Click on the “LOGIN” button
Click on the “LOGOUT” button
Validate that the login form is displayed
     */


    @Test(priority = 3, description = "Test Case 03 - Validate the logout")
    public void validateTheLogOut(){
        project2Page.login("TechGlobal", "Test1234");
        project2Page.logoutButton.click();
        Assert.assertTrue(project2Page.loginForm.isDisplayed());
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

    @Test(priority = 4, description = "Test Case 04 - Validate the Forgot Password? Link and Reset Password modal")
    public void validateTheForgotPasswordLinkAndResetPasswordModal(){
        project2Page.forgotPasswordLink.click();

        Assert.assertTrue(project2Page.resetPasswordModalTitle.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalTitle.getText(), "Reset Password");

        Assert.assertTrue(project2Page.resetPasswordModalCloseButton.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalCloseButton.isEnabled());

        Assert.assertTrue(project2Page.resetPasswordModalHeading.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalHeading.getText(), "Reset Password");

        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBoxLabel.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalEmailInputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");

        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBox.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBox.isEnabled());

        Assert.assertTrue(project2Page.resetPasswordModalSubmitButton.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalSubmitButton.isEnabled());
        Assert.assertEquals(project2Page.resetPasswordModalSubmitButton.getText(), "SUBMIT");
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


    @Test(priority = 6, description = "Test Case 06 - Validate the Reset Password form submission")
    public void validateTheResetPasswordFormSubmission(){
        project2Page.forgotPasswordLink.click();
        project2Page.resetPasswordModalEmailInputBox.sendKeys("johndoe@gmail.com");
        project2Page.resetPasswordModalSubmitButton.click();

        Assert.assertTrue(project2Page.resetPasswordModalMessage.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalMessage.getText(), "A link to reset your password has been sent to your email address.");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Leave username empty
Leave password empty
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Username entered!” above the form
     */


    @Test(priority = 7, description = "Test Case 07 - Validate the invalid login with the empty credentials")
    public void validateTheInvalidLoginWithEmptyCredentials(){
        project2Page.loginButton.click();

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “John”
Enter the password as “Test1234”
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Username entered!” above the form
     */


    @Test(priority = 8, description = "Test Case 08 - Validate the invalid login with the wrong username")
    public void validateTheInvalidLoginWithTheWrongUsername(){
        project2Page.login("John", "Test1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “TechGlobal”
Enter the password as “1234”
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Password entered!” above the form
     */


    @Test(priority = 9, description = "Test Case 09 - Validate the invalid login with the wrong password")
    public void validateTheInvalidLoginWithTheWrongPassword(){
        project2Page.login("TechGlobal", "1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Password entered!");
    }


    /*
Navigate to https://techglobal-training.com/frontend/project-2
Enter the username as “John”
Enter the password as “1234”
Click on the “LOGIN” button
Validate the failure message is displayed as “Invalid Username entered!” above the form
     */


    @Test(priority = 10, description = "Test Case 10 - Validate the invalid login with the wrong username and password")
    public void validateTheInvalidLoginWithTheWrongUsernameAndPassword(){
        project2Page.login("John", "1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }


}
