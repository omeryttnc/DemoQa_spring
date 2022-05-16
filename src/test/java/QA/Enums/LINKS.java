package QA.Enums;

public enum LINKS {
    GOOGLE("https://www.google.co.uk/"),




    ;
    private String links;

    LINKS(String links) {
        this.links = links;
    }

    public String getLinks() {
        return links;
    }
}
