package QA.Java_Calisma.Annotations.MethodAnnotation;

import QA.Java_Calisma.Annotations.ClassAnnotation.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MethodDeneme {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("I am a cat");

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmideatly.class)) {
                method.invoke(myCat);
            }
        }

    }
}
