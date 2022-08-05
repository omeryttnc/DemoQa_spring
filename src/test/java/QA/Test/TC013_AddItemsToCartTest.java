package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Jenkins.Abdullah;
import QA.Jenkins.RegressionTest;
import QA.utilities.ReusableMethods;
import QA.utilities.driver.DriverFactoryImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TC013_AddItemsToCartTest extends BrowserTestBase {

    @BeforeEach
    public void visitURL(){
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully

        ReusableMethods.visitURL(LINKS.HOME);
        Assertions.assertEquals("https://www.automationexercise.com/", DriverFactoryImplementation.getInstance().getDriver().getCurrentUrl());
    }
@RegressionTest
@Abdullah
    public void verifyproductDetailsIsOpened(){
//  4. Click 'View Product' for any product on home page
//5. Verify product detail is opened
        elements.getHomePage().ProductInfo("Blue Top","view product").click();
        Assertions.assertTrue(elements.getProductPage().productDetailsCart.isDisplayed());
        ReusableMethods.wait(10);
    }

    @RegressionTest
    @Abdullah
    public void verifyproductQuantityinCart(){
//6. Increase quantity to 4
//7. Click 'Add to cart' button
//8. Click 'View Cart' button
//9. Verify that product is displayed in cart page with exact quantity
        elements.getHomePage().ProductInfo("Blue Top","view product").click();
        elements.getProductPage().productquantity.clear();
        elements.getProductPage().productquantity.sendKeys("4");
        elements.getProductPage().ProductInfoPage("Blue Top","Add to cart").click();
        elements.getProductPage().viewCart.click();
        Assertions.assertEquals("4",elements.getCartPage().ProductInfoCartPage("Blue Top", "quantity").getText());

    }




}
