package QA.Test;

import QA.BrowserTestBase;
import QA.Pages.AllElements;
import QA.Pages.HomePage;
import QA.Pages.Login_SignUpPAGE;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deneme_1_Test extends BrowserTestBase {

    Response response;
    JsonPath json;
    ObjectMapper objectMapper;
    Map<String,String>map = new HashMap<>();
    Faker faker = new Faker();

    @Test
    public void createUser() {
        map.put("name", faker.name().fullName() );
        response = given().
                contentType(ContentType.JSON)
                .body(map)
                .post("/api/v1/person");
        response.prettyPrint();

        json = response.jsonPath();
        System.out.println((char[]) json.get("name"));
    }

    @Test
    public void getUsers() {
        response = given().
                contentType(ContentType.JSON)
                .get("/api/v1/person");
        response.prettyPrint();

        json = response.jsonPath();
        System.out.println(json.getList("name"));
    }

    @Test
    public void a() {

        HomePage homePage = new HomePage();
        Login_SignUpPAGE login_signUpPAGE = new Login_SignUpPAGE();

        System.out.println("homePage.Address = " + homePage.Address);

        System.out.println("login_signUpPAGE.accountCreated = " + login_signUpPAGE.accountCreated);


        System.out.println("elements.getHomePage().Address = " + elements.getHomePage().Address);
        System.out.println("elements.getlogin_signUpPAGE().accountCreated = " + elements.getlogin_signUpPAGE().accountCreated);


    }
}
