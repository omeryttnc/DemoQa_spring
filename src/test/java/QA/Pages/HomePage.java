package QA.Pages;

import QA.utilities.driver.DriverFactory;
import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='col-12 Sidebar_section_btn__1sp6i '])[1]")
    public WebElement Address;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement Signup_loginButton;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement product_button;


    @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
    public WebElement AutomationExercise;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement Subscription;

    @FindBy(xpath = "(//h1)[1]")
    public WebElement header;

    @FindBy(xpath = "(//a[@data-product-id=\"1\"])[1]")
    public WebElement first_product;

    @FindBy(xpath = "(//a[@data-product-id=\"1\"])[2]")
    public WebElement first_product_pop;

    @FindBy(css = ":last-of-type>h2.title")
    public WebElement recommended_items_title;

    @FindBy(css = "a[href=\"/delete_account\"]")
    public WebElement delete_account;

    @FindBy(css = "button[data-dismiss]")
    public WebElement continue_shopping;
    @FindBy(css = "p>a[href='/view_cart']")
    public WebElement view_cart_pop_up;

    @FindBy(css = "#recommended-item-carousel>div>div>div>div>div>div>p")
    public List<WebElement> recommended_items_name;
    @FindBy(css = "a[data-product-id]")
    public List<WebElement> cart_product_id;

    @FindBy(css = "#recommended-item-carousel>div>div>div>div>div>div>a")
    public List<WebElement> recommended_items_add_to_cart;

    @FindBy(css = "#recommended-item-carousel>div>div>div>div>div>div>h2")
    public List<WebElement> recommended_items_price;

    public WebElement ProductInfo(String productName, String priceViewProductAddToCart) {
        WebElement webElement;
        switch (priceViewProductAddToCart.toLowerCase()) {
            case "price":
                webElement = DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//p[text()='" + productName + "']//..//h2"));
                break;

            case "view product":
                webElement = DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//p[text()='" + productName + "']//..//..//..//*[text()='View Product']"));
                break;

            case "add to cart":
                webElement = DriverFactoryImplementation.getInstance().getDriver().
                        findElement(By.xpath("//p[text()='" + productName + "']//../a"));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + priceViewProductAddToCart);
        }
        return webElement;


    }
}