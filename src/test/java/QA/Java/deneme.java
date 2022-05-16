package QA.Java;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Enums.USERINFO;
import QA.Jenkins.RegressionTest;
import QA.Jenkins.SmokeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class deneme extends BrowserTestBase {
    @SmokeTest
    public void a() {
        Driver.getDriver().get(LINKS.GOOGLE.getLinks());
        USERINFO.methods.writeInfo(USERINFO.ALICI);
        System.out.println("I am smoke");
    }

    @RegressionTest
    @DisplayName("I am regression")
    public void iAmRegression() {
        System.out.println("I am regression");
    }
}
