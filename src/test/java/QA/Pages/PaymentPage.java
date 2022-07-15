package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    public PaymentPage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(css = "[name=\"name_on_card\"]")
    public WebElement name_On_Card;

    @FindBy(css = "[name=\"card_number\"]")
    public WebElement card_number;

    @FindBy(css = "[name=\"cvc\"]")
    public WebElement cvc;

    @FindBy(css = "[name=\"expiry_month\"]")
    public WebElement expiry_month;

    @FindBy(css = "[name=\"expiry_year\"]")
    public WebElement expiry_year;

    @FindBy(css = "#submit")
    public WebElement payAndConfirmOrder;

    @FindBy(xpath = "//h2[@data-qa=\"order-placed\"]/../p")
    public WebElement congratulations;

 @FindBy(xpath = "//a[text()=\"Download Invoice\"]")
    public WebElement download_invoice;




}
