package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Enums.USERINFO;
import QA.Jenkins.Abdullah;
import QA.Jenkins.SmokeTest;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.*;

public class TC01_TC02_RegisterTest extends BrowserTestBase {
    @BeforeEach

    public void goToLogin_SignUpPage(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        //ReusableMethods.visitURL(LINKS.REGISTER);
        ReusableMethods.visitURL(LINKS.HOME);
        Assertions.assertEquals(LINKS.HOME.getLinks(), Driver.getDriver().getCurrentUrl(), "actual Link is" + Driver.getDriver().getCurrentUrl());

        //4. Click on 'Signup / Login' button
        elements.getHomePage().Signup_loginButton.click();




    }

        @SmokeTest
        @Abdullah
        public void NewUserSignupisVisiableTest() {
            //5. Verify 'New User Signup!' is visible
            Assertions.assertTrue(elements.getlogin_signUpPAGE().NewUserSignupText.isDisplayed(), "'New User Signup!' is NOT visible");
            //6. Enter name and email address
            //7. Click 'Signup' button
            //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            String name=faker.name().firstName();
            String email=name+"@mailsac.com";
            elements.getlogin_signUpPAGE().signUpName.sendKeys(name);
            elements.getlogin_signUpPAGE().signUpEmail.sendKeys(email);
            elements.getlogin_signUpPAGE().signUpButton.click();
            Assertions.assertTrue(elements.getlogin_signUpPAGE().enterAccountInformationText.isDisplayed(),"Verify that 'ENTER ACCOUNT INFORMATION' is visible");
            Assertions.assertEquals("ENTER ACCOUNT INFORMATION",elements.getlogin_signUpPAGE().enterAccountInformationText.getText(),"Verify that 'ENTER ACCOUNT INFORMATION' is visible");

            //9. Fill details: Title, Name, Email, Password, Date of birth
            //10. Select checkbox 'Sign up for our newsletter!'
            //11. Select checkbox 'Receive special offers from our partners!'
            //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            //13. Click 'Create Account button'
            //14. Verify that 'ACCOUNT CREATED!' is visible

            elements.getlogin_signUpPAGE().fillAccountInfoDetails(" ",name,email,"12345","10","5",
                    "1985",name,faker.name().lastName(),"My Company","Somewhere streeet","6",
                    "California","Los Angeles","95100"," ","0684111111");

            Assertions.assertTrue(elements.getlogin_signUpPAGE().accountCreated.isDisplayed(),"Verify that 'ACCOUNT CREATED!' is visible");
            Assertions.assertEquals("ACCOUNT CREATED!",elements.getlogin_signUpPAGE().accountCreated.getText(),"Verify that 'ACCOUNT CREATED!' is visible");

            //15. Click 'Continue' button
            //16. Verify that 'Logged in as username' is visible
            elements.getlogin_signUpPAGE().continueButton.click();
            Assertions.assertTrue(elements.getlogin_signUpPAGE().loggedInAs.isDisplayed(),"Verify that 'Logged in as username' is visible");
            Assertions.assertEquals("Logged in as "+name,elements.getlogin_signUpPAGE().loggedInAs.getText(),"Verify that 'Logged in as username' is visible");

                }

    @Test
    void DeleteAccount() {
        NewUserSignupisVisiableTest();
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        elements.getlogin_signUpPAGE().deleteAccount.click();

        Assertions.assertTrue(elements.getlogin_signUpPAGE().accountDeletedPageBody.getText().contains("ACCOUNT DELETED!"),"Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");

    }

    @SmokeTest
        @Abdullah
        public void loginTest_Positive(){
            //5. Verify 'Login to your account' is visible
            Assertions.assertTrue(elements.getlogin_signUpPAGE().loginToYourAccountText.isDisplayed(),"Verify 'Login to your account' is visible");
            Assertions.assertEquals("Login to your account",elements.getlogin_signUpPAGE().loginToYourAccountText.getText());

        //6. Enter correct email address and password
        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible

            elements.getlogin_signUpPAGE().loginEmail.sendKeys(USERINFO.LOGIN_TEST.getEmail());
            elements.getlogin_signUpPAGE().loginPassword.sendKeys(USERINFO.LOGIN_TEST.getPassword());
            elements.getlogin_signUpPAGE().loginButton.click();

            //************Asagidaki kisim manuel olarak gecmiyor.
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible

        }

        @Nested
        class NegativeLoginTest {
            @SmokeTest
            @Abdullah
            public void incorrectEmail() {

                //6. Enter incorrect email address and password
                //7. Click 'login' button
                //8. Verify error 'Your email or password is incorrect!' is visible
                elements.getlogin_signUpPAGE().loginEmail.sendKeys("incorrectemail@com");
                elements.getlogin_signUpPAGE().loginPassword.sendKeys(USERINFO.LOGIN_TEST.getPassword());
                elements.getlogin_signUpPAGE().loginButton.click();
                Assertions.assertTrue(elements.getlogin_signUpPAGE().incoorectEmailOrPasswordMessage_Login.isDisplayed(), "Verify error 'Your email or password is incorrect!' is visible//INcorrect Email Test");

                //************Asagidaki kisim manuel olarak gecmiyor.
                //9. Click 'Delete Account' button
                //10. Verify that 'ACCOUNT DELETED!' is visible
            }

            @SmokeTest
            @Abdullah
            public void incorrectPassword() {

                //6. Enter incorrect email address and password
                //7. Click 'login' button
                //8. Verify error 'Your email or password is incorrect!' is visible
                elements.getlogin_signUpPAGE().loginEmail.sendKeys(USERINFO.LOGIN_TEST.getEmail());
                elements.getlogin_signUpPAGE().loginPassword.sendKeys("IncorrectPassword");
                elements.getlogin_signUpPAGE().loginButton.click();
                Assertions.assertTrue(elements.getlogin_signUpPAGE().incoorectEmailOrPasswordMessage_Login.isDisplayed(), "Verify error 'Your email or password is incorrect!' is visible//INcorrect Password Test");

                //************Asagidaki kisim manuel olarak gecmiyor.
                //9. Click 'Delete Account' button
                //10. Verify that 'ACCOUNT DELETED!' is visible
            }
        }

    }

