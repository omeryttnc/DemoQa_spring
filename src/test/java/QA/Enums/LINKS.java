package QA.Enums;

public enum LINKS {
    GOOGLE("https://www.google.co.uk/",""),
    REGISTER("https://www.automationexercise.com/login"),
    HOME("https://www.automationexercise.com/","")


    ;
    private String links;
    private String links2;

    LINKS(String links2) {
        this.links2 = links2;
    }

    LINKS(String links, String links2) {
        this.links = links;
        this.links2 = links2;
    }

    public String getLinks() {
        return links;
    }
}
