package QA.Test;

import QA.Enums.LINKS;
import QA.Jenkins.RegressionTest;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class Abd_AbstractTest {

@BeforeEach
    public void visitURL() {
        ReusableMethods.visitURL(LINKS.HOME);
    }


    @RegressionTest
    public void test(){
        abd_a_commonFeatures.assertAutomationExerciseExists();
        System.out.println("abd_a_commonFeatures.getSubscriptionText() = " + abd_a_commonFeatures.getSubscriptionText());
        System.out.println("abd_a_commonFeatures.getSubscriptionTextColor() = " + abd_a_commonFeatures.getSubscriptionTextColor());
        Assertions.assertEquals("AutomationExercise",abd_a_commonFeatures.getHeaderText());
        Assertions.assertEquals("rgba(180, 177, 171, 1)",abd_a_commonFeatures.getHeaderColor());

}

    Abd_A_CommonFeatures abd_a_commonFeatures=new Abd_A_CommonFeatures() {
    @Override
    public String getHeaderText() {
        return elements.getHomePage().header.getText();
    }

    @Override
    public String getHeaderColor() {
        return elements.getHomePage().header.getCssValue("color");
    }

};

}




//extend yaparak Abstract kullandim obje olusturmadim.
//Zorunlu olarak abstract methodlarim override oldu. Ayni fonksiyonlari farkli method body ile test etmek istiyorum.
//Cunku Abstract methodlarimi  extend ettigim tum pagelerde kullanmak istiyorum.


 class contactUsTest extends Abd_A_CommonFeatures{

    @BeforeEach
     public void visitURL(){
        ReusableMethods.visitURL(LINKS.CONTACT_US);
    }

    @RegressionTest
    public void test(){
        assertAutomationExerciseExists();
        System.out.println("abd_a_commonFeatures.getSubscriptionText() = " + getSubscriptionText());
        System.out.println("abd_a_commonFeatures.getSubscriptionTextColor() = " + getSubscriptionTextColor());
        Assertions.assertEquals("CONTACT US",getHeaderText());
        Assertions.assertEquals("rgba(254, 152, 15, 1)",getHeaderColor());
    }


     @Override
     public String getHeaderText() {
         return elements.getContactUsPage().headerContactUs.getText();
     }

     @Override
     public String getHeaderColor() {
         return elements.getContactUsPage().headerContactUs.getCssValue("color");
     }
 }