package QA.Enums;

public enum LINKS {
    GOOGLE("https://www.google.co.uk/"),
    REGISTER("https://www.automationexercise.com/login"),
    HOME("https://www.automationexercise.com/"),
    CONTACT_US("https://www.automationexercise.com/contact_us"),


    ;
    private String links;


    LINKS(String links) {
        this.links = links;
    }



    public String getLinks() {
        return links;
    }
}
