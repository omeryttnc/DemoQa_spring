package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage(){PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);}

    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    public WebElement productquantity;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//*[contains(@id,\"product\")]//h4/a")
    public List<WebElement> productName;
    @FindBy(xpath = "//*[contains(@class,\"cart_price\")]/p")
    public List<WebElement> productPrice;

    public WebElement ProductInfoCartPage(String productName, String priceQuantityTotal) {
        WebElement webElement;
        switch (priceQuantityTotal.toLowerCase()){
            case  "price":
                 webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//a[text()='"+productName+"']//..//..//..//td[@class='cart_price']/p"));
                break;

                case  "quantity":
                 webElement=DriverFactoryImplementation.getInstance().getDriver().
                         findElement(By.xpath("//a[text()='"+productName+"']//..//..//..//td[@class='cart_quantity']/button"));
                break;

                case  "total":
                 webElement=DriverFactoryImplementation.getInstance().getDriver().
                         findElement(By.xpath("//a[text()='"+productName+"']//..//..//..//td[@class='cart_total']/p"));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + priceQuantityTotal);
        }
        return webElement;
    }
}
