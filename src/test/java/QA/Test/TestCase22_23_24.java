package QA.Test;

import QA.BrowserTestBase;
import QA.Jenkins.Omer;
import QA.Jenkins.SmokeTest;
import QA.utilities.ReusableMethods;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class TestCase22_23_24 extends BrowserTestBase {
    Map<String, String> map = new HashMap<>();

    @Omer
    @Epic("Purchase")
    @Feature("Cart Page")
    @Story("TC_22")
    @Severity(value = SeverityLevel.BLOCKER)
    @Description(value = "user able to verify that product is displayed in cart page")
    @Owner(value = "OMER")
    @SmokeTest
    public void tc_22() {
        /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
         */

        Driver.getDriver().get("http://automationexercise.com");
        ReusableMethods.wait(5);

        actions.moveToElement(elements.getHomePage().recommended_items_title).perform();
        ReusableMethods.wait(2);
        Assertions.assertTrue(elements.getHomePage().recommended_items_title.isDisplayed());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(2);
        elements.getHomePage().recommended_items_add_to_cart.get(0).click();
        String eklenen_product_name = elements.getHomePage().recommended_items_name.get(0).getText();
        String eklenen_product_price = elements.getHomePage().recommended_items_price.get(0).getText();

        ReusableMethods.wait(2);
        Assertions.assertTrue(elements.getHomePage().view_cart_pop_up.isDisplayed());

        elements.getHomePage().view_cart_pop_up.click();
        ReusableMethods.wait(5);
        String gozuken_product_name = elements.getCartPage().productName.get(0).getText();
        String gozuken_product_price = elements.getCartPage().productPrice.get(0).getText();

        Assertions.assertEquals(eklenen_product_name, gozuken_product_name);
        Assertions.assertEquals(eklenen_product_price, gozuken_product_price);
        Assertions.assertEquals("https://automationexercise.com/view_cart", Driver.getDriver().getCurrentUrl());

    }



    @Omer
    @Epic("Purchase")
    @Feature("Delete user")
    @Story("TC_23")
    @Severity(value = SeverityLevel.BLOCKER)
    @Description(value = "user able to delete account")
    @Owner(value = "OMER")
    @SmokeTest
    public void tc_23() {
        /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
    8. Add products to cart
    9. Click 'Cart' button
    10. Verify that cart page is displayed
    11. Click Proceed To Checkout
    12. Verify that the delivery address is same address filled at the time registration of account
    13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
         */
        UserCreate newUser = createAccount();
        elements.getlogin_signUpPAGE().continueButton.click();
        ReusableMethods.wait(5);
        System.out.println("elements.getHomePage().user_name.getText() = " + elements.getHomePage().user_name.getText());
        System.out.println("newUser.firstName = " + newUser.firstName);
        System.out.println("newUser.lastName = " + newUser.lastName);
        System.out.println("newUser.fullName = " + newUser.fullName);

        Assertions.assertTrue(elements.getHomePage().user_name.getText().contains(newUser.fullName));
        Assertions.assertTrue(elements.getHomePage().delete_account.isDisplayed());
        elements.getHomePage().delete_account.click();
        ReusableMethods.wait(5);
        Assertions.assertEquals("https://automationexercise.com/delete_account", Driver.getDriver().getCurrentUrl());
    }


    @Omer
    @SmokeTest
    @Epic("Purchase")
    @Feature("Puchase")
    @Story("TC_23")
    @Severity(value = SeverityLevel.BLOCKER)
    @Description(value = "user able to download invoice")
    @Owner(value = "OMER")
    public void tc_24() {
        /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
20. Click 'Continue' button
    21. Click 'Delete Account' button
    22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
         */
        UserCreate newUser = createAccount();
        Driver.getDriver().get("http://automationexercise.com");
        ReusableMethods.wait(5);
        actions.moveToElement(elements.getHomePage().first_product).perform();
        ReusableMethods.wait(2);
        elements.getHomePage().first_product_pop.click();
        ReusableMethods.wait(2);

        elements.getHomePage().view_cart_pop_up.click();
        ReusableMethods.wait(2);
        elements.getCartPage().proceedToCheckout.click();
        ReusableMethods.wait(2);


        System.out.println("ui da gozuken : " + elements.getCheckoutPage().address_firstname_address_lastname.get(0).getText() + "\n" +
                "kullanicinin first name: " + newUser.getFirstName() + "\n" +
                "kullanicinin last name: " + newUser.getLastName() + "\n" +
                "kullanicinin fullName name: " + newUser.getFullName() + "\n"
        );


        // country
        Assertions.assertEquals("India", elements.getCheckoutPage().address_country_name.get(0).getText());

        //street
        Assertions.assertEquals(newUser.getStreet(), elements.getCheckoutPage().address_address_2_5.get(1).getText());

        //city state zipcode
        Assertions.assertEquals(newUser.getCity() + " " + newUser.getState() + " " + newUser.getZipcode(),
                elements.getCheckoutPage().address_city_address_state_name_address_postcode.get(0).getText());

        //phone number
        Assertions.assertEquals(newUser.getMobileNumber(), elements.getCheckoutPage().address_phone.get(0).getText());

        actions.moveToElement(elements.getCheckoutPage().placeOrder).perform();

        elements.getCheckoutPage().comment_box.sendKeys(faker.shakespeare().hamletQuote());
        ReusableMethods.wait(2);
        elements.getCheckoutPage().placeOrder.click();
        ReusableMethods.wait(5);
        elements.getPaymentPage().name_On_Card.sendKeys("we");
        elements.getPaymentPage().card_number.sendKeys("sds");
        elements.getPaymentPage().cvc.sendKeys("ww");
        elements.getPaymentPage().expiry_month.sendKeys("ww");
        elements.getPaymentPage().expiry_year.sendKeys("dd");
        elements.getPaymentPage().payAndConfirmOrder.click();

        ReusableMethods.wait(2);

        Assertions.assertEquals(elements.getPaymentPage().congratulations.getText(), "Congratulations! Your order has been confirmed!");
        //daha onceden indirilen dosya varsa onu siliyorum
        deleteFile();
        ReusableMethods.wait(3);

        elements.getPaymentPage().download_invoice.click();
        ReusableMethods.wait(3);
        //dosyanin localde oldugunun assertion i yapiyorum
        Assertions.assertTrue(isFileDownloaded());

        // indirdigim dosyayi siliyorum
        deleteFile();

    }

    /**
     * dosyanin yolu ve ismini vererek local bilgisayardan silmek icin kullandim
     * yol ve urun ismi ayni oldugundan degisken olarak atamadim
     */
    public void deleteFile() {
//    public void deleteFile(String path, String fileName) {
        String path = System.getProperty("user.home") + "\\Downloads";
        String fileName = "invoice.txt";

        File dir = new File(path);
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName)) {
                dir_contents[i].deleteOnExit();
            }

        }


    }


    /**
     * yolu ve ismi verilen dosyanin local de oldugunu gosteren bir method
     *
     * @return eger dosya var ise true dondurecek
     */
    public boolean isFileDownloaded() {
//    public boolean isFileDownloaded(String downloadPath, String fileName) {
        String downloadPath = System.getProperty("user.home") + "\\Downloads";
        String fileName = "invoice.txt";

        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }

        return flag;
    }

    /**
     * kartta olan urunlerin kaldirilmasi icin hazirlandi ama kullanmadim
     *
     * @param id        urunun id numarasi
     * @param csrftoken getAllCookies.get("csrftoken") seklinde alinabilir
     * @param sessionid getAllCookies.get("sessionid") seklinde alinabilir
     */

    public void removeCart(String id, String csrftoken, String sessionid) {
        Response response = given()
                .cookie("csrftoken", csrftoken)
                .cookie("sessionid", sessionid)
                .contentType(ContentType.JSON)

                .get("https://automationexercise.com/delete_cart/" + id);

        //response.prettyPrint();
    }


    /**
     * removeCart methodu icin yapildi csrftoken ve sessionid verilerini cekiyoruz
     *
     * @return yukari da ismi gecen verilerin cekilmesi icin map donduruyor
     */
    public Map<String, String> getAllCookies() {
        Driver.getDriver().get("https://automationexercise.com/view_cart");
        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();
        Iterator<Cookie> itr = cookies.iterator();
        while (itr.hasNext()) {

            Cookie cookie = itr.next();
            map.put(cookie.getName(), cookie.getValue());

        }
        return map;

    }

    /**
     * hesap olusturup gerekli assertion lari icerde yapyor
     *
     * @return hesap detaylarina erisebilecegimiz kullaniciyi return ediyor
     */
    public UserCreate createAccount() {

//        map.put("password", "sad234sdfe43r4");
//        map.put("firstName", faker.name().firstName());
//        map.put("lastName", faker.name().lastName());
//        map.put("street", "street");
//        map.put("state", "state");
//        map.put("city", "city");
//        map.put("zipcode", "zipcode");
//        map.put("mobile number", "mobile number");
//        map.put("emailAddress", faker.internet().emailAddress());
//        map.put("fullName", faker.name().fullName());
        UserCreate user = new UserCreate(
                faker.internet().emailAddress(),
                faker.name().fullName(),
                "sad234sdfe43r4",
                faker.name().firstName(),
                faker.name().lastName(),
                "street",
                "state",
                "city",
                "zipcode",
                "mobile number"
        );

        Driver.getDriver().get("http://automationexercise.com");
        ReusableMethods.wait(5);
        Dimension dimension = new Dimension(1200, 720);

        Driver.getDriver().manage().window().setSize(dimension);
        ReusableMethods.wait(5);
        Assertions.assertTrue(elements.getHomePage().Signup_loginButton.isDisplayed());
        elements.getHomePage().Signup_loginButton.click();
        ReusableMethods.wait(5);
        elements.getlogin_signUpPAGE().signUpEmail.sendKeys(user.getEmailAddress());
        elements.getlogin_signUpPAGE().signUpName.sendKeys(user.getFullName());
        elements.getlogin_signUpPAGE().signUpButton.click();
        ReusableMethods.wait(3);
        elements.getlogin_signUpPAGE().accountPassword.sendKeys(user.getPassword());
        elements.getlogin_signUpPAGE().firstName_AddressInfo.sendKeys(user.getFirstName());
        elements.getlogin_signUpPAGE().lastName_AddressInfo.sendKeys(user.getLastName());
        elements.getlogin_signUpPAGE().street_PO_Box_AddressInfo.sendKeys(user.getStreet());
        elements.getlogin_signUpPAGE().state_AddressInfo.sendKeys(user.getState());
        elements.getlogin_signUpPAGE().city_AddressInfo.sendKeys(user.getCity());
        elements.getlogin_signUpPAGE().zipCode_AddressInfo.sendKeys(user.getZipcode());
        elements.getlogin_signUpPAGE().mobileNumber_AddressInfo.sendKeys(user.getMobileNumber());
        elements.getlogin_signUpPAGE().createAccountButton.click();
        ReusableMethods.wait(5);
        Assertions.assertTrue(elements.getlogin_signUpPAGE().accountCreated.isDisplayed());
        Assertions.assertEquals("ACCOUNT CREATED!", elements.getlogin_signUpPAGE().accountCreated.getText());
        return user;
    }

    public static class UserCreate {
        private String emailAddress;
        private String fullName;
        private String password;
        private String firstName;
        private String lastName;
        private String street;
        private String state;
        private String city;
        private String zipcode;
        private String mobileNumber;

        public UserCreate(String emailAddress, String fullName, String password, String firstName, String lastName, String street, String state, String city, String zipcode, String mobileNumber) {
            this.emailAddress = emailAddress;
            this.fullName = fullName;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            this.street = street;
            this.state = state;
            this.city = city;
            this.zipcode = zipcode;
            this.mobileNumber = mobileNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public String getFullName() {
            return fullName;
        }

        public String getPassword() {
            return password;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getStreet() {
            return street;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }
    }

}
