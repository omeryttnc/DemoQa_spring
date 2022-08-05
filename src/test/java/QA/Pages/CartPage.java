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

//    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
//    public WebElement proceedToCheckout;

    @FindBy(xpath = "//ul[contains(@class,'address item box')]/li")
    public List<WebElement> adressInfo;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement productName1;

    @FindBy(xpath = "//a[@href='/product_details/2']")
    public WebElement productName2;

    @FindBy(xpath = "//textarea")
    public WebElement textarea;

    @FindBy(xpath = "//a[@href='/payment']")
    public WebElement placeOrder;

    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement nameOnCard;

    @FindBy(xpath = "//input[@name='card_number']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement CVC;

    @FindBy(xpath = "//input[@name='expiry_month']")
    public WebElement expirationMonth;

    @FindBy(xpath = "//input[@name='expiry_year']")
    public WebElement expirationYear;

    @FindBy(id ="submit" )
    public WebElement payAndComfirmOrder;

    @FindBy(xpath = "//h2[@data-qa]")
    public WebElement OrderPlaced;

    @FindBy(xpath = "(//div//p)[1]")
    public WebElement OrderConfirmed;

    /**
     *
     * @param productName
     * @param priceQuantityTotal price,quantity veya total hangi webelement araniyora o yazilir.
     * @return price,quantity veya total webelement olarak doner.
     */
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
