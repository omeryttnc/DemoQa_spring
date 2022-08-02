package QA.Enums;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public enum ENDPOINTS {
    CREATE_USER("https://demoqa.com/Account/v1/User"),
    GET_TOKEN("https://demoqa.com/Account/v1/GenerateToken"),

    ;

    private String endPoint;

    ENDPOINTS(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }


    public static class method {
        static Response response;
        static JsonPath jsonPath;

        public static Inner_class m_login(String username, String password, int statucCode) {
            Inner_class user = new Inner_class(username, password,statucCode);
            response = given().
                    contentType(ContentType.JSON)
                    .body("{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}")
                    .post(ENDPOINTS.GET_TOKEN.getEndPoint());
            jsonPath = response.jsonPath();
            Assertions.assertEquals(response.statusCode(),statucCode);
            user.setToken(jsonPath.getString("token"));
            user.setExpires(jsonPath.getString("expires"));
            user.setStatus(jsonPath.getString("status"));
            user.setResult(jsonPath.getString("result"));
            user.setCode(jsonPath.getString("code"));
            user.setMessage(jsonPath.getString("message"));
            return user;
        }

        public static Inner_class m_register(String username, String password, int statucCode) {
            Inner_class user = new Inner_class(username, password,statucCode);
            response = given().
                    contentType(ContentType.JSON)
                    .body("{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}")
                    .post(ENDPOINTS.CREATE_USER.getEndPoint());
            jsonPath = response.jsonPath();
            Assertions.assertEquals(response.statusCode(),statucCode);
            user.setUserID(jsonPath.getString("userID"));
            user.setUserName(jsonPath.getString("username"));
            return user;
        }
    }
    public static class Inner_class {
        private String result;
        private String status;
        private String token;
        private String expires;
        private String code;
        private String message;
        private String userName;
        private String password;
        private String userID;
        private int statusCode;

        public Inner_class(String userName, String password, int statusCode) {
            this.userName = userName;
            this.password = password;
            this.statusCode = statusCode;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setExpires(String expires) {
            this.expires = expires;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }


        public String getResult() {
            return result;
        }

        public String getStatus() {
            return status;
        }

        public String getToken() {
            return token;
        }

        public String getExpires() {
            return expires;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }

}
