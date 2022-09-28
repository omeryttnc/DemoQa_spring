package QA.Java_Calisma.Generics;

public class PrinterGeneric<T> {  // T -> type parameter -> Primeter type da calismiyor

    T thingToPrint;

    public PrinterGeneric(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
