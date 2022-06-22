package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Jenkins.RegressionTest;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class Abd_InterfaceTest extends BrowserTestBase implements Abd_I_CommonFeatures {

@BeforeEach
    public void visitURL() {
        ReusableMethods.visitURL(LINKS.HOME);
    }


    @RegressionTest
    public void test(){
        assertAutomationExerciseExists();
        System.out.println("getHeaderText() = " + getHeaderText());
        System.out.println("getHeaderColor() = " + getHeaderColor());
        System.out.println("getSubscriptionText() = " + getSubscriptionText());
        System.out.println("getSubscriptionTextColor() = " + getSubscriptionTextColor());

    }
//interface oldugu icin tum methodlar abstract gibi. Yani body olamadan override ile cagrikmak zorunda.
//Obje olusturmadan implement ederek kullaniyoruz, tum sayfalarda test etmek istedigimiz ayni isimli fonksiyonlari
//override ile body degistirerek kullanabiliyoruz.
    @Override
    public void assertAutomationExerciseExists() {

        Assertions.assertTrue(elements.getHomePage().AutomationExercise.isDisplayed());
    }

    @Override
    public String getHeaderText() {
        return elements.getHomePage().header.getText();
    }

    @Override
    public String getHeaderColor() {
        return elements.getHomePage().header.getCssValue("color");
    }

    @Override
    public String getSubscriptionText() {
        return elements.getHomePage().Subscription.getText();
    }

    @Override
    public String getSubscriptionTextColor() {
        return elements.getHomePage().Subscription.getCssValue("background-color");
    }
}
