package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Jenkins.RegressionTest;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestCase6 extends BrowserTestBase {
    @BeforeEach
    public void goToLoginSignUpPage() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully


        //ReusableMethods.visitURL(LINKS.REGISTER);
        ReusableMethods.visitURL(LINKS.CONTACT_US);
        Assertions.assertEquals(LINKS.CONTACT_US.getLinks(), Driver.getDriver().getCurrentUrl(), "actual Link is" + Driver.getDriver().getCurrentUrl());
        ;

    }

    // 4. Click on 'Contact Us' button
    @RegressionTest
    public void ContactUsClick() {
        elements.getContactUsFormPage().contactUSButton.click();
        Assertions.assertTrue(elements.getContactUsFormPage().contactUSButton.isEnabled());

    }

    // 5. Verify 'GET IN TOUCH' is visible
    @RegressionTest
    public void getInTouchVerify() {
        Assertions.assertTrue(elements.getContactUsFormPage().getInTouchHeader.isDisplayed());

    }
    // 6. Enter name, email, subject and message
    // 8. Click 'Submit' button
    @RegressionTest
    public void inputNameEmailSubjectInGetInTouchsButtonsAndSubmitClickAndSuccessMessageVerify() {

        ReusableMethods.wait(1);
        elements.getContactUsFormPage().getInTouchButtons.get(0).sendKeys("Example");
        ReusableMethods.wait(1);
        elements.getContactUsFormPage().getInTouchButtons.get(1).sendKeys("example@gmail.com");
        ReusableMethods.wait(1);
        elements.getContactUsFormPage().getInTouchButtons.get(2).sendKeys("example@gmail.com");
        ReusableMethods.wait(1);
        elements.getContactUsFormPage().messageAreaBox.sendKeys("Contact will be made");
        // 8. Click 'Submit' button
        elements.getContactUsFormPage().submitButton.click();
        // 9. Click OK button
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.wait(2);
        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assertions.assertTrue(elements.getContactUsFormPage().successfullyMessageText.isDisplayed());
        ReusableMethods.wait(2);
        // 11. Click 'Home' button and verify that landed to home page successfully
        elements.getContactUsFormPage().homeButton.click();
        String actualTitle = Driver.getDriver().getTitle();
        Assertions.assertEquals("Automation Exercise", actualTitle);


    }

    // 7. Upload file
    @RegressionTest
    public void upLoadFile() {
        elements.getContactUsFormPage().allFourBoxes.get(2).click();
        // Path file = Paths.get("C:\\Users\\ilhan\\Desktop\\ContactUs.txt)");
        String filepath = "C:\\Users\\ilhan\\Desktop\\ContactUs.txt";
        elements.getContactUsFormPage().allFourBoxes.get(3).sendKeys(filepath);
        ReusableMethods.wait(1);
        elements.getContactUsFormPage().submitButton.click();
        ReusableMethods.wait(1);
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.wait(1);
        // Assertions.assertTrue(elements.getContactUsFormPage().successfullyMessageText.isDisplayed());
        Assertions.assertTrue(elements.getContactUsFormPage().successfullyMessageText.isDisplayed());


    }

}
