package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(css = ".address_firstname.address_lastname")
    public List<WebElement> address_firstname_address_lastname;

    @FindBy(css = "li.address_address1.address_address2")
    public List<WebElement> address_address_2_5;

    @FindBy(css = ".address_city.address_state_name.address_postcode")
    public List<WebElement> address_city_address_state_name_address_postcode;

    @FindBy(css = ".address_country_name")
    public List<WebElement> address_country_name;

    @FindBy(css = ".address_phone")
    public List<WebElement> address_phone;


    @FindBy(css = ".form-control")
    public WebElement comment_box;


    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement placeOrder;


}
