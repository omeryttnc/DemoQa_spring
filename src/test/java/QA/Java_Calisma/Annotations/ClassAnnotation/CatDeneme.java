package QA.Java_Calisma.Annotations.ClassAnnotation;

import QA.Java_Calisma.Annotations.VeryImportant;

public class CatDeneme {
    public static void main(String[] args) {
        Cat myCat = new Cat("Stella");
        Dog myDog = new Dog("aa");
        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("is important");
        } else {
            System.out.println("is not important");
        }
    }
}
