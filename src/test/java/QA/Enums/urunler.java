package QA.Enums;

import QA.Database.HUBS;

public enum urunler {
    UZUM("uzum",25.5,10,true,false),
    KARPUZ("karpuz",56.8,2,true,false),
    MUZ("muz",89,6,false,false)

    ;
    private  String productName;
    private  double productPrice;
    private int productQuantity;
    private  boolean isAvailable;
    private  boolean isOrganic;

    urunler(String productName, double productPrice, int productQuantity, boolean isAvailable, boolean isOrganic) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.isAvailable = isAvailable;
        this.isOrganic = isOrganic;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isOrganic() {
        return isOrganic;
    }
}