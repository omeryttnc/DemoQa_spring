package QA.Test;

import QA.utilities.ReadTxt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class read {
    @Test
    public void sss() {
        String path = System.getProperty("user.home") + "\\Downloads";
        String fileName = "\\invoice.txt";
        String returntitle = ReadTxt.returntitle(path + fileName);
        System.out.println(returntitle);

        String expectedText= "Hi sadsad sadsad, Your total purchase amount is 1500. Thank you";
        Assertions.assertEquals(expectedText,returntitle);
    }
}
