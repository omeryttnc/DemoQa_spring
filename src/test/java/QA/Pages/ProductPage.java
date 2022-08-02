package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(){PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);}

    @FindBy(css = "#quantity")
    public WebElement productquantity;

    @FindBy(xpath = "//button[contains(@class,'btn-default cart')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//a[@href='/view_cart']/u")
    public WebElement viewCart;

    @FindBy(xpath = "//div[@class='product-details']")
    public WebElement productDetailsCart;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName;

    public WebElement ProductInfoPage(String productName, String priceQuantityAddToCart) {
        WebElement webElement;
        switch (priceQuantityAddToCart.toLowerCase()){
            case  "price":
                webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//h2[text()='"+productName+"']//../span/span"));
                break;

            case  "quantity":
                webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//h2[text()='"+productName+"']//..//input[@id='quantity']"));
                break;

                case  "add to cart":
                webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//h2[text()='"+productName+"']//..//button"));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + priceQuantityAddToCart);
        }
        return webElement;
    }
}
