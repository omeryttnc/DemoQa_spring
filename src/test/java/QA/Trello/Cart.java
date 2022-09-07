package QA.Trello;

import QA.Enums.TRELLO;
import QA.Java.Pojo.GetActions.GetActionsClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Cart  {
    String baseUrl = "https://trello.com";
    Response response;
    Faker faker = new Faker();
ObjectMapper objectMapper =new ObjectMapper();
JsonPath jsonPath;

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

    @Test
    void getAction() throws JsonProcessingException {

        response = given()
                .contentType(ContentType.JSON)
                .queryParam("key", TRELLO.USER.OMER.getKey())
                .queryParam("token", TRELLO.USER.OMER.getToken())
                .get(baseUrl+"/1/actions/"+TRELLO.CARTS.LISTE1KART1.getId());


        // object mapper
        GetActionsClass actionsClass ;
        actionsClass = objectMapper.readValue(response.asString(),GetActionsClass.class);
        System.out.println("object Mapper : " + actionsClass.getDisplay().getEntities().getCard().getId());

        // jsonPath
        jsonPath = response.jsonPath();
        System.out.println("json : " + jsonPath.getString("display.entities.card.id"));

    }
}
