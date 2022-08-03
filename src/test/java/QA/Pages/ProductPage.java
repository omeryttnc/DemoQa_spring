package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    public ProductPage(){PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);}

    @FindBy(css = "#quantity")
    public WebElement productquantity;

    @FindBy(css = ".btn.btn-default.add-to-cart")
    public List<WebElement> addToCartButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    public List<WebElement> productNameInContainer;

    @FindBy(xpath = "//div[@class='productinfo text-center']/h2")
    public List<WebElement> productPriceInContainer;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//a[@href='/view_cart']/u")
    public WebElement viewCart;

    @FindBy(xpath = "//div[@class='product-details']")
    public WebElement productDetailsCart;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName;

    /**
     *
     * @param productName urun adina gore asagidaki webelementleri donduruyor
     * @param priceQuantityAddToCart "price", "quantity" veya "add to cart" yazilir.
     * @return price, quantity veya add to cart webelement olarak dondurur
     */

    public WebElement ProductInfoPage(String productName, String priceQuantityAddToCart) {
        WebElement webElement;
        switch (priceQuantityAddToCart.toLowerCase()){
            case  "price":
                webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("(//p[text()='\"+productName+\"'])[1]//../h2"));
                break;

            case  "quantity":
                webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//h2[text()='"+productName+"']//..//input[@id='quantity']"));
                break;

                case  "add to cart":
                webElement=DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("(//p[text()='"+productName+"'])[3]//..//a/i"));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + priceQuantityAddToCart);
        }
        return webElement;
    }
}
