package QA.Java_Calisma.Annotations.ClassAnnotation;

import QA.Java_Calisma.Annotations.FieldAnnotaion.RunField;
import QA.Java_Calisma.Annotations.MethodAnnotation.RunImmideatly;
import QA.Java_Calisma.Annotations.ParameterAnnotation.RunParameter;
import QA.Java_Calisma.Annotations.VeryImportant;

@VeryImportant
public class Cat {
    String name;
    int age;

    public Cat(String name) {
        this.name = name;
    }

    @RunImmideatly
    public void meow() {
        System.out.println("cat meow");
    }


    @RunParameter(times = 3)
    public void eat() {
        System.out.println("cat eat");
    }


}
