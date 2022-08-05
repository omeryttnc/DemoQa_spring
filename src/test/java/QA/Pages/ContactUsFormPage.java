package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactUsFormPage {
    ContactUsFormPage(){
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);}

    @FindBy(xpath = "//a[@href=\"/contact_us\"]")
    public WebElement contactUSButton;

    @FindBy(xpath = "(//h2[contains(@class, 'title text-center')])[2]")
    public WebElement getInTouchHeader;

    @FindBy(xpath = "(//input[@class= 'form-control'])")
    public List<WebElement> getInTouchButtons;

    @FindBy(xpath = "//*[@id=\"message\"]")
    public WebElement messageAreaBox;

    @FindBy(xpath = "//div[@class=\"form-group col-md-12\"]")
    public List<WebElement> allFourBoxes;

    @FindBy(xpath = "(//div[@class=\"form-group col-md-12\"])[2]")
    public WebElement fileUpLoad;

    @FindBy(xpath = "//input[@type= 'submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class= 'status alert alert-success']")
    public WebElement successfullyMessageText;

    @FindBy(xpath = "//i[@class='fa fa-angle-double-left']")
    public WebElement homeButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    public List<WebElement> shopMenuList;









}
