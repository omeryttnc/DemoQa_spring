package QA.Java_Calisma.Annotations.ClassAnnotation;

import QA.Java_Calisma.Annotations.FieldAnnotaion.RunField;

public class Dog {

    @RunField
    String name;
    int age;

    public Dog(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("dog bark");
    }



    public void eat() {
        System.out.println("dog eat");
    }
}
