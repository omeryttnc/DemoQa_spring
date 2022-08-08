package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Jenkins.RegressionTest;
import QA.Jenkins.SmokeTest;
import QA.utilities.ConfigReader;
import QA.utilities.ConfigurationReader;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class TestCase16 extends BrowserTestBase {

    @BeforeEach
    public void goToLoginSignUpPage() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully


        ReusableMethods.visitURL(LINKS.CONTACT_US);
        Assertions.assertEquals(LINKS.CONTACT_US.getLinks(), Driver.getDriver().getCurrentUrl(), "actual Link is" + Driver.getDriver().getCurrentUrl());
        ;
    }
       // 4. Click 'Signup / Login' button
       // TODO: 08/08/2022 icinin doldurulmasi gerekiyor!!!
        @Test
        public void signUpLoginButtonClick() {
            elements.getContactUsFormPage().shopMenuList.get(3).click();
        }

       // 5. Fill email, password and click 'Login' button
       // 6. Verify 'Logged in as username' at top
       // 7. Add products to cart
       // 8. Click 'Cart' button
       // 9. Verify that cart page is displayed
       // 10. Click Proceed To Checkout
       // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
       // 14. Click 'Pay and Confirm Order' button
       // 15. Verify success message 'Your order has been placed successfully!'
       // 16. Click 'Delete Account' button
       // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
       @RegressionTest
       public void productReceivingProcessFunctionTesting() {
           elements.getContactUsFormPage().shopMenuList.get(3).click();
           elements.getAddProductsInCartPage().emailInputBox.sendKeys(ConfigurationReader.getProperty("userNameMail"));
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().passwordInputBox.sendKeys(ConfigurationReader.getProperty("userPassword"));
           ReusableMethods.wait(2);
           elements.getAddProductsInCartPage().loginButtons.get(0).click();
           ReusableMethods.wait(1);
           elements.getContactUsFormPage().shopMenuList.get(2).click();
           ReusableMethods.wait(2);
           elements.getAddProductsInCartPage().proceedToCheckoutButton.click();
           ReusableMethods.wait(1);
           Assertions.assertTrue(elements.getAddProductsInCartPage().deliveryAdress.isDisplayed());
           ReusableMethods.wait(2);
           actions.sendKeys(Keys.PAGE_DOWN).perform();
           actions.moveToElement(elements.getAddProductsInCartPage().descriptionAreaAndComment).click();
           ReusableMethods.wait(2);
           //elements.getAddProductsInCartPage().descriptionAreaAndComment.sendKeys("Thanks a lot ");
           elements.getAddProductsInCartPage().placeOrderButton.click();
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().nameOnCardButton.sendKeys("Visa");
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().cardNumberButton.sendKeys("123456789");
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().cvcButton.sendKeys("123");
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().expirationMonthButton.sendKeys("01");
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().expirationYearButton.sendKeys("2024");
           ReusableMethods.wait(1);
           elements.getAddProductsInCartPage().payAndConfirmButton.click();
           ReusableMethods.wait(1);
          // elements.getAddProductsInCartPage().orderSuccessfullyMessage.isDisplayed();

       }

        @Test
        public void addProductsToCart() {
            elements.getContactUsFormPage().shopMenuList.get(2).click();
            ReusableMethods.wait(1);
            Assertions.assertTrue(elements.getContactUsFormPage().shopMenuList.get(2).isDisplayed());
            elements.getAddProductsInCartPage().addToCardButton.click();
           /* ReusableMethods.wait(1);
            elements.getAddProductsInCartPage().proceedToCheckoutButton.click();
            Assertions.assertTrue(elements.getAddProductsInCartPage().deliveryAdress.isDisplayed());*/


        }

       // 11. Verify Address Details and Review Your Order
       @Test
       public void verifyDeliveryAddress() {
           elements.getContactUsFormPage().shopMenuList.get(2).click();
           ReusableMethods.wait(1);
           Assertions.assertTrue(elements.getAddProductsInCartPage().deliveryAdress.isDisplayed());
       }
       // 12. Enter description in comment text area and click 'Place Order'
       @Test
       public void inTextAreaWriteAndPlaceOrderButtonClick() {
           elements.getContactUsFormPage().shopMenuList.get(2).click();
           ReusableMethods.wait(1);
           Assertions.assertTrue(elements.getAddProductsInCartPage().deliveryAdress.isDisplayed());
       }

    }


