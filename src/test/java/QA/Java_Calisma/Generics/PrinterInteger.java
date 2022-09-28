package QA.Java_Calisma.Generics;

public class PrinterInteger {
    Integer thingToPrint;

    public PrinterInteger(Integer thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
