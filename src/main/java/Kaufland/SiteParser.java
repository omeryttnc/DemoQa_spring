package Kaufland;

public interface SiteParser {

    public String getSize();
    public String getProductImage(CrawlerJob job);
    String getProductNr();
    double getPrice();
    double getTotlPrice();
    boolean isPriceavailable();
    String getProducer();
    String getCategories();
    String getShopNmae();



}
