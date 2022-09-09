package QA.Trello;

import QA.utilities.ReadTxt;
import QA.utilities.WriteToTxt;
import org.junit.jupiter.api.Test;

public class DenemeTest {
    @Test
    void name() {
        WriteToTxt.saveTitle("dosya","ilk id");
        System.out.println(ReadTxt.returntitle("dosya"));
    }
}
