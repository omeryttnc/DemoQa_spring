package QA.Test;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deneme_1_Test {
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
}
