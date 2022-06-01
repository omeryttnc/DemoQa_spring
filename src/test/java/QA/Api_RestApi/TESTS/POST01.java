package QA.Api_RestApi.TESTS;

import QA.Api_RestApi.POJOS.USER_CREATE;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import QA.Api_RestApi.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class POST01 extends TestBase {
    /*
     * POST ICIN:
     * 1- endpoint sart
     * 2- request body sart
     * 3- Authorization sart
     * 4- Accepttaype istege bagli
     * 5- Content-Type istege bagli
     * */

    //1. yol gönderecegim body 'i string in icine atarak body i olusturabilirim
    //2. yol bir pojo class olusturabilirim.
    //3. yol Json Objeleri olusturabilirim:
    //JSONObject jsonBookingBody = new JSONObject();
    //jsonBookingBody.put("firstname","Sally");
    //bu objeyi post ederken de boyd kismina string yaparak koyuyorum .body(jsonRequestBody.toString).when().post();

    Response response;
    String endpoint = "https://demoqa.com/Account/v1/Authorized";
    USER_CREATE pojo = new USER_CREATE();
    @Test
    public void POST01() {

        String jsonRequestBody = "{\n" +
                "    \"firstname\": \"very\",\n" +
                "    \"lastname\": \"Smith\",\n" +
                "    \"totalprice\": 929,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-08-07\",\n" +
                "        \"checkout\": \"2021-01-22\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        Response responce = given().
                accept(ContentType.JSON).
                spec(spec01).
                auth().basic("admin", "password123").
                body(jsonRequestBody).
                when().
                post("/booking");
        System.out.println(responce.statusCode());
    }

    @Test
    public void POST02() {
        pojo.setUserName("TRY");
        pojo.setPassword("123456");
        response = given().contentType(ContentType.JSON).
                auth().basic("ZEHRA","12345678").
                body(pojo).when().post();
        response.prettyPrint();

    }
}
