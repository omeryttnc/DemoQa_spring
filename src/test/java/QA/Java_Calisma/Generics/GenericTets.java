package QA.Java_Calisma.Generics;

import QA.Java_Calisma.Cat;
import QA.Java_Calisma.Dog;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericTets {
    @Test
    void genericGiris() {
        // without generic
        PrinterDouble printerDouble = new PrinterDouble(320.5);
        printerDouble.print();

        PrinterInteger printerInteger = new PrinterInteger(45);
        printerInteger.print();

        //generic way
        PrinterGeneric<Integer> printer = new PrinterGeneric<>(30);
        printer.print();

        PrinterGeneric<Double> doublePrinterGeneric = new PrinterGeneric<>(45.6);
        doublePrinterGeneric.print();
    }

    @Test
    void genericCollection() {
        List<Integer> stringList = new ArrayList<>();
        //stringList.add("omer");
        stringList.add(2);

// we cant use object instead of Generic it wont be type safe


        List<Object> objectList = new ArrayList<>();

        objectList.add("isim");     //
        objectList.add(2);          //  type safe degil beni uyarmadi
        objectList.add(3.4);        //
        System.out.println("objectList = " + objectList);

        ArrayList<Object> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Dog());
        //  Cat myCat= (Cat) cats.get(1);
        // System.out.println("myCat = " + myCat);
    }


    // generic methods

    private <T, V> void shout(T thingToShout, V other) {
        System.out.println(thingToShout + " !!!!!!!!!!! " + other);
    }

    private <T, V> T shout2(T thingToShout, V other) {
        System.out.println(thingToShout + " !!!!!!!!!!! " + other);
        return thingToShout;
    }

// wild card
    private static void printList(List<Object> myList){
        System.out.println(myList);
    }

    private static void printList2(List<?> myList){
        System.out.println(myList);
    }
    @Test
    void wildCard() {
        List<Integer>integerList = new ArrayList<>();
        integerList.add(3);
        //printList(integerList);
        List<Integer>integerList1=new ArrayList<>();
        integerList1.add(3);
        printList2(integerList1);
    }

    @Test
    void genericExtend() {
        shout("omer", 23);
        shout(34, "dsd");
    }

    public static <T> Set<T> mergeSet(Set<T> a, Set<T> b) {

        // Adding all elements of respective Sets
        // using addAll() method
        return new HashSet<T>() {
            {
                addAll(a);
                addAll(b);
            }
        };
    }
}
