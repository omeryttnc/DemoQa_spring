package QA.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Products {
    private final HUBS hubs;
    private final String productName;
    private final double productPrice;
    private int productQuantity;
    private final boolean isAvailable;
    private final boolean isOrganic;

    public Products(HUBS hubs, String productName, double productPrice, int productQuantity, boolean isAvailable, boolean isOrganic) {
        this.hubs = hubs;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.isAvailable = isAvailable;
        this.isOrganic = isOrganic;
    }

    public HUBS getHubs() {
        return hubs;
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

    public int setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
        return productQuantity;
    }

    private static final List<Products> allProduct = new ArrayList<>();

    public static void addProduct(HUBS hubs, String productName, double productPrice, int productQuantity, boolean isAvailable, boolean isOrganic) {
        allProduct.add(new Products(hubs, productName, productPrice, productQuantity, isAvailable, isOrganic));
    }

    public static List<Products> getProduct() {
        return allProduct;
    }

    public static int sellItem(String products, int productQuantity) {

        final int[] kalan = new int[1];
        if (allProduct.stream().filter(t -> t.productName.equals(products)).map(Products::getProductQuantity).collect(Collectors.toList()).get(0) > 0) {

            allProduct.stream()
                    .filter(t -> t.productName.equals(products))
                    .forEach(t -> kalan[0] =  t.setProductQuantity(t.getProductQuantity() - productQuantity)

            );
        } else {
            System.out.println("you dont have enought prodcut");
        }
        return kalan[0];
    }

    public static double total(String productName, int productQuantity) {
        List<Double> collect = allProduct.stream()
                .filter(t -> t.getProductName()
                        .equals(productName))
                .map(Products::getProductPrice)
                .collect(Collectors.toList());
        return collect.get(0)* productQuantity;
    }
}


