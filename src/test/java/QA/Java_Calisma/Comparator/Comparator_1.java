package QA.Java_Calisma.Comparator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator_1 {
    @Test
    void name() {
        List<String> stringList = new ArrayList<>();
        stringList.add("omer");
        stringList.add("ali");
        stringList.add("okkes");
        stringList.add("huseyin");
        stringList.add("hasan");
        System.out.println("before : " + stringList);
        Collections.sort(stringList);
        System.out.println("after : " + stringList);


    }
}
