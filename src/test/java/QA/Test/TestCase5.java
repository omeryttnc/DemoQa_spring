package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Jenkins.Abdullah;
import QA.Jenkins.RegressionTest;
import QA.utilities.ReusableMethods;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;


public class TestCase5 extends BrowserTestBase {


//Test Case 5: Register User with existing email
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible
@Epic("Account")
@Feature("Register")
@Story("User able to register")
@Severity(value = SeverityLevel.BLOCKER)
@Description(value = "user able to register")
@Owner(value = "ABDULLAH")
        @Abdullah
        @RegressionTest
        public void TC05_RegisterWithExistingEmail(){
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            //3. Verify that home page is visible successfully

            //ReusableMethods.visitURL(LINKS.REGISTER);
            ReusableMethods.visitURL(LINKS.HOME);
            Assertions.assertEquals(LINKS.HOME.getLinks(), Driver.getDriver().getCurrentUrl(), "actual Link is" + Driver.getDriver().getCurrentUrl());

            //4. Click on 'Signup / Login' button
            elements.getHomePage().Signup_loginButton.click();

            //5. Verify 'New User Signup!' is visible
            Assertions.assertTrue(elements.getlogin_signUpPAGE().NewUserSignupText.isDisplayed(), "'New User Signup!' is NOT visible");

            String name=faker.name().firstName();
            String email=name+"@mailsac.com";
            System.out.println(name);
            System.out.println(email);
            elements.getlogin_signUpPAGE().signUpName.sendKeys(name);
            elements.getlogin_signUpPAGE().signUpEmail.sendKeys(email);
            elements.getlogin_signUpPAGE().signUpButton.click();
            elements.getlogin_signUpPAGE().fillAccountInfoDetails(" ",name, email, "12345", "10",
                    "5", "1985", name, faker.name().lastName(), "My Company",
                    "Somewhere streeet", "6", "California", "Los Angeles",
                    "95100"," ", "0684111111");

            Assertions.assertTrue(elements.getlogin_signUpPAGE().accountCreated.isDisplayed(),"Verify that 'ACCOUNT CREATED!' is visible");
            Assertions.assertEquals("ACCOUNT CREATED!",elements.getlogin_signUpPAGE().accountCreated.getText(),"Verify that 'ACCOUNT CREATED!' is visible");

            elements.getHomePage().HomeButton.click();
            elements.getHomePage().LogoutButton.click();
            elements.getHomePage().Signup_loginButton.click();
            Assertions.assertTrue(elements.getlogin_signUpPAGE().NewUserSignupText.isDisplayed(), "'New User Signup!' is NOT visible");


            //6. Enter name and already registered email address
            //7. Click 'Signup' button
            //8. Verify error 'Email Address already exist!' is visible
            elements.getlogin_signUpPAGE().signUpName.sendKeys(name);
            elements.getlogin_signUpPAGE().signUpEmail.sendKeys(email);
            elements.getlogin_signUpPAGE().signUpButton.click();
            Assertions.assertEquals("Email Address already exist!",elements.getlogin_signUpPAGE().emailAddressExist.getText());
        }

}
