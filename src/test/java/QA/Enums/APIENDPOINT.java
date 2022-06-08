package QA.Enums;

public enum APIENDPOINT {
    DEMO("https://restful-booker.herokuapp.com/booking/"),

    ;
    private String get;

    APIENDPOINT(String get) {
        this.get = get;
    }

    public String getGet() {
        return get;
    }
}
