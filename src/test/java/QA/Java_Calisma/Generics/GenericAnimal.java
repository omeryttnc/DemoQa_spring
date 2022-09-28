package QA.Java_Calisma.Generics;

import QA.Java_Calisma.Bird;
import org.junit.jupiter.api.Test;

public class GenericAnimal<T extends Bird> {
    T things;

    @Test
    public void print() {
        things.fly();
        things.eat();
    }
}
