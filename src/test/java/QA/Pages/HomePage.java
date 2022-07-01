package QA.Pages;

import QA.utilities.driver.DriverFactory;
import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(),this);
    }
    @FindBy(xpath = "(//a[@class='col-12 Sidebar_section_btn__1sp6i '])[1]")
    public WebElement Address;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement  Signup_loginButton;

    @FindBy(xpath ="//a[@href='/products']")
    public WebElement product_button;




    @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
    public WebElement  AutomationExercise;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement  Subscription;

    @FindBy(xpath = "(//h1)[1]")
    public WebElement  header;

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


    }}