package QA.Pages;

import QA.utilities.driver.DriverFactory;
import QA.utilities.driver.DriverFactoryImplementation;
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

    @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
    public WebElement  AutomationExercise;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement  Subscription;

    @FindBy(xpath = "(//h1)[1]")
    public WebElement  header;
}
