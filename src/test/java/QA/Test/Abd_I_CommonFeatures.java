package QA.Test;

import QA.BrowserTestBase;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public interface Abd_I_CommonFeatures {
        WebElement element = null;
        void assertAutomationExerciseExists();
        String getHeaderText();
        String getHeaderColor();
        String getSubscriptionText();
        String getSubscriptionTextColor();


}
