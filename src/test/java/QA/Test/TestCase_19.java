package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCase_19 extends BrowserTestBase {
/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products */

    @BeforeEach
    public void goToHomePage() {

        //ReusableMethods.visitURL(LINKS.HOME);
        Driver.getDriver().get(LINKS.HOME.getLinks());
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);

        Assertions.assertEquals(LINKS.HOME.getLinks(), currentUrl, "the link is" + LINKS.HOME.getLinks());
    }

    @Test
    public void goToProductPage(){
        elements.getHomePage().product_button.click();
        ReusableMethods.isElementVisible(elements.getProductsPage().brand_header);
        Assertions.assertTrue(elements.getProductsPage().isAllBrandVisible());
        elements.getProductsPage().clickAnyBrand("Allen Solly Junior");




    }

}
