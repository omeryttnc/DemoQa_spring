package QA.Enums;

public enum USERINFO {
ALICI("omer","","","omer@gmail.com","",""),
ALICI_1("","","","","",""),
ALICI_2("","","","","",""),
ALICI_3("","","","","",""),
ALICI_4("","","","","",""),
ALICI_5("","","","","",""),





    ;

    private String lat;
    private String lng;
    private String email;
    private String password;
    private String userName;
    private String token;

    USERINFO(String userName, String lat, String lng, String email, String password, String token) {
        this.token = token;
        this.lat = lat;
        this.lng = lng;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    public static class methods{


        public static void login(USERINFO user) {
            System.out.println(user.getEmail() + " : " + user.getPassword());
            System.out.println(user.getToken());
        }

        public static void login2(String email,String password,String token) {
            System.out.println(email + " : " + password);
            System.out.println(token);
        }

        public static void writeInfo(USERINFO userinfo) {

            System.out.println(
                    "benim adim " + userinfo.getUserName() + "\n" +
                            "mailim " + userinfo.getEmail()
            );
        }


    }

}
