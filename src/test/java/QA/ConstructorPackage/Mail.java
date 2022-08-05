package QA.ConstructorPackage;

import org.junit.jupiter.api.Test;

public class Mail {
    private String orderSubTotal, orderDeliveryCost, orderDateAndTime, senderName, buyerName;

    public Mail(String mail) {


        this.orderSubTotal = mail.split(":")[1].substring(0,mail.split(":")[1].indexOf(",")).trim();
        this.orderDeliveryCost = mail.split(":")[2].substring(0,mail.split(":")[2].indexOf(",")).trim();
        this.orderDateAndTime = mail.split(":")[3].substring(0,mail.split(":")[3].indexOf(",")).trim();
        this.senderName = mail.split(":")[4].substring(0,mail.split(":")[4].indexOf(",")).trim();
        this.buyerName = mail.split(":")[5].trim();

    }

    public String getOrderSubTotal() {
        return orderSubTotal;
    }

    public String getOrderDeliveryCost() {
        return orderDeliveryCost;
    }

    public String getOrderDateAndTime() {
        return orderDateAndTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getBuyerName() {
        return buyerName;
    }
}
class ss{
    @Test
    public void ssss() {
        String gelenMail= "Order Sub Total : 25 ," +
                "Order Delivery Cost: 5," +
                " Order Date and Time : 22/07/2022 , " +
                "Sender name : omer , " +
                "Buyer name : ali";
        Mail mail = new Mail(gelenMail);

        System.out.println("mail.getBuyerName() = " +
                mail.getBuyerName());
        System.out.println("mail.getOrderDateAndTime() = " +
                mail.getOrderDateAndTime());
        System.out.println("mail.getOrderDeliveryCost() = " +
                mail.getOrderDeliveryCost());
        System.out.println("mail.getSenderName() = " +
                mail.getSenderName());
        System.out.println("mail.getOrderSubTotal() = " +
                mail.getOrderSubTotal());
    }
}