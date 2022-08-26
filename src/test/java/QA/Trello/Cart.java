package QA.Trello;

import QA.Enums.TRELLO;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Cart  {
    String baseUrl = "https://trello.com";
    Response response;
    Faker faker = new Faker();

    @Test
    void name() {

        response = given()
                .contentType(ContentType.JSON)
                .queryParam("idList", TRELLO.CARTS.LISTE1KART1.getIdList())
                .queryParam("key", TRELLO.USER.OMER.getKey())
                .queryParam("token", TRELLO.USER.OMER.getToken())
                .queryParam("name", faker.name().firstName())
                .post(baseUrl+"/1/cards");

    }
    @Test
    void card() {

        response = given()
                .contentType(ContentType.JSON)
                .queryParam("idList", TRELLO.CARTS.LISTE1KART1.getIdList())
                .queryParam("key", TRELLO.USER.SELMAN.getKey())
                .queryParam("token", TRELLO.USER.SELMAN.getToken())
                .queryParam("name", faker.name().firstName())
                .post(baseUrl+"/1/cards");




    }

}
