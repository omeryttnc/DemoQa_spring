package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class TestCase_09 extends BrowserTestBase {
/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8.
  */


    @BeforeEach
    public void goToHomePage() {
        //ReusableMethods.visitURL(LINKS.HOME);
        Driver.getDriver().get(LINKS.HOME.getLinks());
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);

        Assertions.assertEquals(LINKS.HOME.getLinks(), currentUrl, "the link is" + LINKS.HOME.getLinks());
    }

    @Test
    public void goToProductPage() {
        elements.getHomePage().product_button.click();
        Assertions.assertTrue(elements.getProductsPage().all_products.isDisplayed(), "ALL PRODUCTS IS NOT DISPLAYED");

        String productName = elements.getProductsPage().enterProduct();
        System.out.println(productName);

        elements.getProductsPage().search_products_button.sendKeys(productName);
        elements.getProductsPage().submit_search_button.click();

        System.out.println(elements.getProductsPage().getProductName());
        elements.getProductsPage().isVisible(elements.getProductsPage().getProductName());

        Assertions.assertEquals(productName,elements.getProductsPage().getProductName());




    }
}

