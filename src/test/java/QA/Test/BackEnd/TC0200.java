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

        response = given().
                contentType(ContentType.JSON)


                .body(

                        "{\"userName\": \"omer1\", \"password\":\"omerOMER1234,.$\"   }"


                )


//                .body("{\"userName\":\"omer1\",\"password\":\"omerOMER1234,.$\"}")
                .post(ENDPOINTS.GET_TOKEN.getEndPoint());

        response.prettyPrint();
        //jsonPath = response.jsonPath();
        Assertions.assertEquals(response.statusCode(), 200);
        Assertions.assertNotNull(response.jsonPath().getString("expires"));
        Assertions.assertEquals(response.jsonPath().getString("result"), "User authorized successfully.");
        Assertions.assertEquals(response.jsonPath().getString("status"), "Success");
    }

    @Test
    public void tc0203() {
//
//        response = given().
//                contentType(ContentType.JSON)
//                .body("{\"userName\":\"omer1\",\"password\":\"ome4rOMER1234,.$\"}")
//                .post(ENDPOINTS.GET_TOKEN.getEndPoint());
        response = getResponse("omer1", "ome4rOMER1234,.$");
        response.prettyPrint();
        jsonPath = response.jsonPath();
        Assertions.assertEquals(response.statusCode(), 200);

        Assertions.assertEquals(jsonPath.getString("status"), "Failed");
        Assertions.assertEquals(jsonPath.getString("result"), "User authorization failed.");
        Assertions.assertNull(jsonPath.getString("token"));
        Assertions.assertNull(jsonPath.getString("expires"));
    }


    Response getResponse(String userName, String passw) {
        return given().
                contentType(ContentType.JSON)
                .body("{\"userName\":\" " + userName + "\",\"password\":\"" + passw + "\"}")
                .post(ENDPOINTS.GET_TOKEN.getEndPoint());

    }

    @Test
    public void tc0204() {


        response = getResponse("","");

//        response = given().
//                contentType(ContentType.JSON)
//                .body("{\"userName\":\"\",\"password\":\"\"}")
//                .post(ENDPOINTS.GET_TOKEN.getEndPoint());

        response.prettyPrint();
        jsonPath = response.jsonPath();
        Assertions.assertEquals(response.statusCode(), 400);

        Assertions.assertEquals(jsonPath.getString("code"), "1200");
        Assertions.assertEquals(jsonPath.getString("message"), "UserName and Password required.");

    }

    @Test
    public void alternative() {

        ENDPOINTS.Inner_class omer1 = ENDPOINTS.method.m_login("omer1", "omerOMER1234,.$", 200);
        Assertions.assertNotNull(omer1.getExpires());
        Assertions.assertEquals(omer1.getResult(),"User authorized successfully.");
        Assertions.assertEquals("Success",omer1.getStatus());







        // 201
        ENDPOINTS.Inner_class positive = omer1;
        Assertions.assertEquals(positive.getStatus(), "Success");
        Assertions.assertEquals(positive.getResult(), "User authorized successfully.");

        //203
        ENDPOINTS.Inner_class yanlis = ENDPOINTS.method.m_login("yanlis", "omerOMER1234,.$", 200);
        Assertions.assertNull(yanlis.getToken());
        Assertions.assertNull(yanlis.getExpires());
        Assertions.assertEquals(yanlis.getStatus(), "Failed");
        Assertions.assertEquals(yanlis.getResult(), "User authorization failed.");

        //204
        ENDPOINTS.Inner_class bos = ENDPOINTS.method.m_login("", "", 400);
        Assertions.assertEquals(bos.getCode(), "1200");
        Assertions.assertEquals(bos.getMessage(), "UserName and Password required.");

    }

    @Test
    public void register() {
        Faker faker = new Faker();

        var register1 = ENDPOINTS.method.m_register(faker.name().username(), "omerOMER1234,.$", 201);
        System.out.println(register1.getUserID());
        System.out.println(register1.getUserName());
    }


}
