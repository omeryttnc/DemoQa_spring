package QA.Java_Calisma.Generics;

public class PrinterDouble {
    Double thingToPrint;

    public PrinterDouble(Double thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
