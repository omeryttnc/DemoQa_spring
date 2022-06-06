package QA.Test.BackEnd;

import QA.Enums.ENDPOINTS;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TC0200 {
    Response response;
    JsonPath jsonPath;

    @Test
    public void tc0201() {
        Faker faker = new Faker();
        String username = faker.name().username();
        response = given().
                contentType(ContentType.JSON)
                .body("{\"userName\":\"omer1\",\"password\":\"omerOMER1234,.$\"}")
                .post(ENDPOINTS.GET_TOKEN.getEndPoint());

        response.prettyPrint();
        jsonPath = response.jsonPath();
        Assertions.assertEquals(response.statusCode(), 200);
        Assertions.assertNotNull(jsonPath.getString("expires"));
        Assertions.assertEquals(jsonPath.getString("result"), "User authorized successfully.");
    }

    @Test
    public void tc0203() {
        Faker faker = new Faker();
        String username = faker.name().username();
        response = given().
                contentType(ContentType.JSON)
                .body("{\"userName\":\"omer1\",\"password\":\"ome4rOMER1234,.$\"}")
                .post(ENDPOINTS.GET_TOKEN.getEndPoint());

        response.prettyPrint();
        jsonPath = response.jsonPath();
        Assertions.assertEquals(response.statusCode(), 200);

        Assertions.assertEquals(jsonPath.getString("status"), "Failed");
        Assertions.assertEquals(jsonPath.getString("result"), "User authorization failed.");
        Assertions.assertNull(jsonPath.getString("token"));
        Assertions.assertNull(jsonPath.getString("expires"));
    }

    @Test
    public void tc0204() {
        Faker faker = new Faker();
        String username = faker.name().username();
        response = given().
                contentType(ContentType.JSON)
                .body("{\"userName\":\"\",\"password\":\"\"}")
                .post(ENDPOINTS.GET_TOKEN.getEndPoint());

        response.prettyPrint();
        jsonPath = response.jsonPath();
        Assertions.assertEquals(response.statusCode(), 400);

        Assertions.assertEquals(jsonPath.getString("code"), "1200");
        Assertions.assertEquals(jsonPath.getString("message"), "UserName and Password required.");

    }

    @Test
    public void d() {
        // 201
        ENDPOINTS.Inner_class register = ENDPOINTS.method.getToken("omer1", "omerOMER1234,.$",200);
        Assertions.assertEquals(register.getStatus(),"Success");
        Assertions.assertEquals(register.getResult(),"User authorized successfully.");

        //203
        ENDPOINTS.Inner_class yanlis = ENDPOINTS.method.getToken("yanlis", "omerOMER1234,.$", 200);
        Assertions.assertNull(yanlis.getToken());
        Assertions.assertNull(yanlis.getExpires());
        Assertions.assertEquals(yanlis.getStatus(),"Failed");
        Assertions.assertEquals(yanlis.getResult(),"User authorization failed.");

        //204
        ENDPOINTS.Inner_class bos = ENDPOINTS.method.getToken("", "", 400);
        Assertions.assertEquals(bos.getCode(),"1200");
        Assertions.assertEquals(bos.getMessage(),"UserName and Password required.");


    }
}
