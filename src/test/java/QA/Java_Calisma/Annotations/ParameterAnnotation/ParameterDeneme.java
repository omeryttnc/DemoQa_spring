package QA.Java_Calisma.Annotations.ParameterAnnotation;

import QA.Java_Calisma.Annotations.ClassAnnotation.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ParameterDeneme {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("I am a cat");

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunParameter.class)) {

                RunParameter parameter = method.getAnnotation(RunParameter.class);
                for (int i = 0; i < parameter.times(); i++) {

                method.invoke(myCat);
                }
            }
        }

    }
}
