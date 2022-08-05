package QA.Enums;

public enum LINKS {
    GOOGLE("https://www.google.co.uk/"),
    REGISTER("https://www.automationexercise.com/login"),
    HOME("https://www.automationexercise.com/"),
    PRODUCTS("https://www.automationexercise.com/products"),
    CONTACT_US("https://www.automationexercise.com/contact_us"),
    PRODUCTS("https://www.automationexercise.com/products"),


    ;
    private String links;

    LINKS(String links) {
        this.links = links;
    }


    public String getLinks() {
        return links;
    }
}
