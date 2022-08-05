package QA.Pages;

import QA.BrowserTestBase;
import QA.utilities.ReusableMethods;
import QA.utilities.driver.DriverFactoryImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class LoginSignUpPage extends BrowserTestBase {
    public LoginSignUpPage() {PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(),this);
    }

    //SIGNUP LOCATORS
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement NewUserSignupText;

    @FindBy(xpath = "//p[@style]")
    public WebElement emailAddressExist;

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='name']")
    public WebElement signUpName;

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='email']")
    public WebElement signUpEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement enterAccountInformationText;

    @FindBy(xpath = "//input[@name='title']")
    public List<WebElement> genderTitleButton;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement MrGenderRadioButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement MrsGenderRadioButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement accountName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement accountEmail;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement accountPassword;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement day_accountDateOfBirth;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement month_accountDateOfBirth;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement year_accountDateOfBirth;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement signUpForOurNewsletter;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement recieveSpecialOffers;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName_AddressInfo;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName_AddressInfo;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement company_AddressInfo;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement street_PO_Box_AddressInfo;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement restOfAddress_AddressInfo;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement country_AddressInfo;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement state_AddressInfo;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city_AddressInfo;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipCode_AddressInfo;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobileNumber_AddressInfo;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement accountCreated;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//i[contains(@class,'fa-user')]/..")
    public WebElement loggedInAs;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//body")
    public WebElement accountDeletedPageBody;

    //create account methods

    public void fillAccountInfoDetails(String gender,String name, String email, String password, String day_DateOfBirth,
                                       String month_DateOfBirth, String year_DateOfBirth, String firstName, String lastName,
                                       String company, String address1, String address2, String state, String city, String zipcode,String country, String mobileNumber){


        ReusableMethods.scrollDownByPixel(1,"100");
        switch (gender){
            case "male":
                elements.getlogin_signUpPAGE().genderTitleButton.get(0).click();
                break;
        case "female":
                elements.getlogin_signUpPAGE().genderTitleButton.get(1).click();
                break;
            default:
                elements.getlogin_signUpPAGE().genderTitleButton.get(random.nextInt(2)).click();
        }





        //ReusableMethods.cleanTextInBox(elements.getlogin_signUpPAGE().accountName);
        //elements.getlogin_signUpPAGE().accountName.sendKeys(name);
        ReusableMethods.scrollDownByPixel(1,"100");
          elements.getlogin_signUpPAGE().accountPassword.sendKeys(password);

        String actualEmail=elements.getlogin_signUpPAGE().accountEmail.getAttribute("value");

        Select select=new Select(elements.getlogin_signUpPAGE().day_accountDateOfBirth);
        select.selectByVisibleText(day_DateOfBirth);


        select=new Select(elements.getlogin_signUpPAGE().month_accountDateOfBirth);
        select.selectByValue(month_DateOfBirth);

        select=new Select(elements.getlogin_signUpPAGE().year_accountDateOfBirth);
        select.selectByVisibleText(year_DateOfBirth);
        ReusableMethods.scrollDownByPixel(1,"100");
        elements.getlogin_signUpPAGE().signUpForOurNewsletter.click();
        elements.getlogin_signUpPAGE().recieveSpecialOffers.click();

        ReusableMethods.scrollDownByPixel(1,"100");
        elements.getlogin_signUpPAGE().firstName_AddressInfo.sendKeys(firstName);
        elements.getlogin_signUpPAGE().lastName_AddressInfo.sendKeys(lastName);
        ReusableMethods.scrollDownByPixel(1,"100");
        elements.getlogin_signUpPAGE().company_AddressInfo.sendKeys(company);
        elements.getlogin_signUpPAGE().street_PO_Box_AddressInfo.sendKeys(address1);
        ReusableMethods.scrollDownByPixel(1,"100");
        elements.getlogin_signUpPAGE().restOfAddress_AddressInfo.sendKeys(address2);

        select=new Select(elements.getlogin_signUpPAGE().country_AddressInfo);
        System.out.println("select.getOptions().size() = " + select.getOptions().size());
        if(country.equalsIgnoreCase("India")){ select.selectByIndex(0);
        }else{
        select.selectByIndex(random.nextInt(7));}


       // elements.getlogin_signUpPAGE().country_AddressInfo.sendKeys(country);
        elements.getlogin_signUpPAGE().state_AddressInfo.sendKeys(state);
        ReusableMethods.scrollDownByPixel(1,"100");
        elements.getlogin_signUpPAGE().city_AddressInfo.sendKeys(city);
        elements.getlogin_signUpPAGE().zipCode_AddressInfo.sendKeys(zipcode);
        ReusableMethods.scrollDownByPixel(1,"100");
        elements.getlogin_signUpPAGE().mobileNumber_AddressInfo.sendKeys(mobileNumber);

        Assertions.assertEquals(email,actualEmail);
        ReusableMethods.clickWithJS(elements.getlogin_signUpPAGE().createAccountButton);
        //elements.getlogin_signUpPAGE().createAccountButton.click();

    }

    //LOGIN LOCATORS
    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement incoorectEmailOrPasswordMessage_Login;

}
