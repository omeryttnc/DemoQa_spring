package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.utilities.ReusableMethods;
import QA.utilities.driver.DriverFactoryImplementation;
import com.google.common.base.Verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC012_AddProductsInCart extends BrowserTestBase {
//    Test Case 15: Place Order: Register before Checkout
//1.



    @Test
    void addProductInCart() {

        ReusableMethods.visitURL(LINKS.HOME);
        Assertions.assertEquals(LINKS.HOME.getLinks(), Driver.getDriver().getCurrentUrl(), "actual Link is" + Driver.getDriver().getCurrentUrl());



        ReusableMethods.scrollDownByPixel(1,"500");


//Add products to cart
        ReusableMethods.wait(1);

        String productName1=elements.getProductPage().productNameInContainer.get(0).getText();
        String productPrice1=elements.getProductPage().productPriceInContainer.get(0).getText();
        elements.getProductPage().addToCartButton.get(0).click();
        elements.getProductPage().continueShopping.click();
        ReusableMethods.wait(2);
        String productName2=elements.getProductPage().productNameInContainer.get(1).getText();
        //System.out.println("productName2 = " + productName2);
        String productPrice2=elements.getProductPage().productPriceInContainer.get(1).getText();
        //System.out.println("productPrice2 = " + productPrice2);
        ReusableMethods.clickWithJS( elements.getProductPage().addToCartButton.get(2));



// Click 'Cart' button
        elements.getProductPage().viewCart.click();

// Verify that cart page is displayed
        Assertions.assertEquals("https://www.automationexercise.com/view_cart",
                DriverFactoryImplementation.getInstance().getDriver().getCurrentUrl());


        String productPriceinCart1=elements.getCartPage().ProductInfoCartPage(productName1,"price").getText();
        String productPriceinCart2=elements.getCartPage().ProductInfoCartPage(productName2,"price").getText();

        String productQuantityinCart1=elements.getCartPage().ProductInfoCartPage(productName1,"quantity").getText();
        String productQuantityinCart2=elements.getCartPage().ProductInfoCartPage(productName2,"quantity").getText();


        Assertions.assertEquals(productName1,elements.getCartPage().productName1.getText());
        Assertions.assertEquals(productPrice1,productPriceinCart1);
        Assertions.assertEquals("1",productQuantityinCart1);

        Assertions.assertEquals(productName2,elements.getCartPage().productName2.getText());
        Assertions.assertEquals(productPrice2,productPriceinCart2);
        Assertions.assertEquals("1",productQuantityinCart2);




    }
}
