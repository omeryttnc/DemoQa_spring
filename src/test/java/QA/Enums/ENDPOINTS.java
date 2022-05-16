package QA.Enums;

public enum ENDPOINTS {
    POST("something goes here"),

    ;
    private String endPoint;

    ENDPOINTS(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }
}
