package QA.Test;

import QA.BrowserTestBase;
import org.junit.jupiter.api.Assertions;

public abstract class Abd_A_CommonFeatures extends BrowserTestBase{


    public void assertAutomationExerciseExists() {
        //System.out.println("Assert Automation");
        Assertions.assertTrue(elements.getHomePage().AutomationExercise.isDisplayed());
    }

    public String getSubscriptionText() {
       // System.out.println("get subscription");
        return elements.getHomePage().Subscription.getText();
    }

    public String getSubscriptionTextColor() {
        //System.out.println("get subscription color");
        return elements.getHomePage().Subscription.getCssValue("background-color");
    }


    public abstract String getHeaderText();


    public abstract String getHeaderColor();
    }





