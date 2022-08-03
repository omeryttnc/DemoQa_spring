package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Pages.AllElements;
import QA.Pages.HomePage;
import QA.Pages.Login_SignUpPAGE;
import QA.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deneme_1_Test extends BrowserTestBase {

    Response response;
    JsonPath json;
    ObjectMapper objectMapper;
    Map<String, String> map = new HashMap<>();
    Faker faker = new Faker();

    @Test
    public void sdasd() {
        ReusableMethods.visitURL(LINKS.PRODUCTS);
        // all_brands_button.forEach(t -> allBrandsList.add(t.getText()));
        // System.out.println(allBrandsList);
        List<WebElement> element = Driver.getDriver().findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked']/li/a"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText().split("\n")[1]);
        }
    }

    @Test
    public void createUser() {
        map.put("name", faker.name().fullName());
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
