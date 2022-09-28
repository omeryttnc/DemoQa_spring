package QA.Java_Calisma.Annotations.FieldAnnotaion;

import QA.Java_Calisma.Annotations.ClassAnnotation.Dog;

import java.lang.reflect.Field;

public class FieldDeneme {
    public static void main(String[] args) throws IllegalAccessException {
        Dog myDog = new Dog("I was a dog");

        for (Field field : myDog.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(RunField.class)) {
//                Object objectValue = field.get(myDog);
//                String stringValue = (String)
                System.out.println(field.get(myDog));
//                if(objectValue instanceof String stringValue){
//                    System.out.println(stringValue.toLowerCase());
//                }

//                System.out.println(stringValue);
            }
        }
    }
}
