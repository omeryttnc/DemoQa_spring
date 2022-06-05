package QA.Enums;

import QA.BrowserTestBase;
import com.github.javafaker.Faker;

public enum USERINFO{


ALICI("omer","","","omer@gmail.com","sifre",""),
ALICI_1("","","","email","sifre2",""),
ALICI_2("","","","email2","",""),
ALICI_3("","","","email23","",""),
ALICI_4("","","","email24","",""),
ALICI_5("","","","email25","",""),


    //https://www.automationexercise.com/   login testte kullanilmak uzere olusturuldu. Abdullah
LOGIN_TEST("Eusebia","","","Eusebia@mailsac.com","12345","")




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
