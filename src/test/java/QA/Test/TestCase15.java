package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.USERINFO;
import QA.utilities.ReusableMethods;
import QA.utilities.driver.DriverFactoryImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCase15 extends BrowserTestBase {
//    Test Case 15: Place Order: Register before Checkout
//1.



    @Test
    void registerAndPlaceOrder() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Signup / Login' button
//5. Fill all details in Signup and create account
//6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//7. Verify ' Logged in as username' at top


        String name=faker.name().firstName();
        String lastname=faker.name().lastName();
        String email=name+"@mailsac.com";
        String gender="male";
        String password="12345";
        String day="10";
        String month="5";
        String year="1985";
        String company="My Company";
        String address1="Somewhere streeet";
        String addrsess2="6";
        String country="India";
        String state="California";
        String city="Los Angeles";
        String zipcode="95100";
        String mobileNumber="0684111111";
        String expectedAddress= " Mr.";
        TestCase1_2 register=new TestCase1_2();
        register.goToLogin_SignUpPage();


        elements.getlogin_signUpPAGE().signUpName.sendKeys(name);
        elements.getlogin_signUpPAGE().signUpEmail.sendKeys(email);
        elements.getlogin_signUpPAGE().signUpButton.click();

        //USERINFO.ALICI
        elements.getlogin_signUpPAGE().fillAccountInfoDetails(gender,name, email, password, day, month ,year, name,
                lastname, company, address1, addrsess2, state, city, zipcode, country, mobileNumber);
        expectedAddress=expectedAddress+" "+name+" "+lastname+" "+company+" "+address1+" "+addrsess2+" "+city+" "+state+" "+zipcode+" "+country+" "+mobileNumber;
        elements.getlogin_signUpPAGE().continueButton.click();
        Assertions.assertTrue(elements.getlogin_signUpPAGE().loggedInAs.isDisplayed(),"Verify that 'Logged in as username' is visible");
        Assertions.assertEquals("Logged in as "+name,elements.getlogin_signUpPAGE().loggedInAs.getText(),"Verify that 'Logged in as username' is visible");

        ReusableMethods.scrollDownByPixel(1,"500");


//8. Add products to cart
        ReusableMethods.wait(1);
        //actions.moveToElement(elements.getProductPage().ProductInfoPage("Blue Top","add to cart")).build().perform();

        String productName="Blue Top";
        ReusableMethods.clickWithJS(elements.getProductPage().ProductInfoPage(productName,"add to cart"));
        //elements.getProductPage().addToCartButton.click();
//9. Click 'Cart' button
        elements.getProductPage().viewCart.click();
//10. Verify that cart page is displayed
        Assertions.assertEquals("https://www.automationexercise.com/view_cart",
                DriverFactoryImplementation.getInstance().getDriver().getCurrentUrl());

        //String productPrice=elements.getProductPage().ProductInfoPage("Blue Top","price").getText();
        String productPrice=elements.getCartPage().ProductInfoCartPage(productName,"price").getText();
        //String productQuantity=elements.getProductPage().ProductInfoPage("Blue Top","quantity").getText();
        String productQuantity=elements.getCartPage().ProductInfoCartPage(productName,"quantity").getText();

//11. Click Proceed To Checkout
        elements.getCartPage().proceedToCheckout.click();
//12. Verify Address Details and Review Your Order
        StringBuilder ADDRESS= new StringBuilder();
        for (int i = 1; i <  elements.getCartPage().adressInfo.size(); i++) {
            ADDRESS.append(" ").append(elements.getCartPage().adressInfo.get(i).getText());

        }
        Assertions.assertEquals(expectedAddress,ADDRESS.toString());

        ReusableMethods.scrollDownByPixel(1,"500");

Assertions.assertEquals(productName,elements.getCartPage().productName1.getText());
Assertions.assertEquals(productPrice,elements.getCartPage().ProductInfoCartPage(productName,"price").getText());
Assertions.assertEquals(productQuantity,elements.getCartPage().ProductInfoCartPage(productName,"quantity").getText());

//13. Enter description in comment text area and click 'Place Order'
//14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//15. Click 'Pay and Confirm Order' button
//16. Verify success message 'Your order has been placed successfully!'

        ReusableMethods.scrollDownByPixel(1,"200");

        elements.getCartPage().textarea.sendKeys("iYI GUNLERDE KULLANIN!!!");
        ReusableMethods.clickWithJS(elements.getCartPage().placeOrder);

        elements.getCartPage().nameOnCard.sendKeys(name);
        elements.getCartPage().cardNumber.sendKeys("123456789");
        elements.getCartPage().CVC.sendKeys("311");
        elements.getCartPage().expirationMonth.sendKeys("12");
        elements.getCartPage().expirationYear.sendKeys("2026");
        ReusableMethods.clickWithJS(elements.getCartPage().payAndComfirmOrder);
        Assertions.assertEquals("Congratulations! Your order has been confirmed!",elements.getCartPage().OrderConfirmed.getText());

    }
    void enumtest(USERINFO userinfo){
        String email=userinfo.getEmail();
        String name=userinfo.getUserName();
        String lat=userinfo.getLat();
        String password=userinfo.getPassword();
        System.out.println("password = " + password+ " "+ email+ lat+name);
    }

    @Test
    void name() {
        enumtest(USERINFO.ALICI);
    }
}
