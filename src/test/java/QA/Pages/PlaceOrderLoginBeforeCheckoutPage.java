package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlaceOrderLoginBeforeCheckoutPage {
    PlaceOrderLoginBeforeCheckoutPage(){
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);}

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    public List<WebElement> loginButtons;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "(//a[@data-product-id=1])[1]")
    public WebElement addToCardButton;

    @FindBy(xpath = "//div[2]/p[2]/a")  //(//a[@href='/view_cart'])[2]
    public WebElement viewCartButton;

    @FindBy(xpath = "//ul[@id='address_delivery']")
    public WebElement deliveryAdress;

    @FindBy(xpath = "//div[@id='ordermsg']")
    public WebElement descriptionAreaAndComment;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement nameOnCardButton;

    @FindBy(xpath = "//input[@name='card_number']")
    public WebElement cardNumberButton;

    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement cvcButton;

    @FindBy(xpath = "//input[@name='expiry_month']")
    public WebElement expirationMonthButton;

    @FindBy(xpath = "//input[@name='expiry_year']")
    public WebElement expirationYearButton;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement payAndConfirmButton;

    @FindBy(xpath = "(//div[@class='alert-success alert'])[1]")
    public WebElement orderSuccessfullyMessage;


}
