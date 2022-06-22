package QA.Pages;

import QA.utilities.driver.DriverFactoryImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    ContactUsPage(){PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);}

    @FindBy(xpath = "(//h2[contains(@class,'text-center')])[1]")
    public WebElement headerContactUs;
}
