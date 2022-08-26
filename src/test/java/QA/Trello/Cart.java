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
//        HttpResponse<JsonNode> response = Unirest.post("https://api.trello.com/1/cards")
//                .header("Accept", "application/json")
//                .queryString("idList", "5abbe4b7ddc1b351ef961414")
//                .queryString("key", "APIKey")
//                .queryString("token", "APIToken")
//                .asJson();

        response = given()
                .contentType(ContentType.JSON)
                .queryParam("idList", TRELLO.OMER.getIdList())
                .queryParam("key", TRELLO.OMER.getKey())
                .queryParam("token", TRELLO.OMER.getToken())
                .queryParam("name", faker.name().firstName())
                .post(baseUrl+"/1/cards");
//        response.prettyPrint();

//        String id = response.jsonPath().getString("id");
//        Driver.getDriver().get(baseUrl+"cards"+"/"+id);
//        System.out.println("Driver.getDriver().findElement(By.xpath(\"//body\")).getText() = " + Driver.getDriver().findElement(By.xpath("//body")).getText());
    }
    @Test
    void card() {

        response = given()
                .contentType(ContentType.JSON)
                .queryParam("idList", TRELLO.Selman.getIdList())
                .queryParam("key", TRELLO.Selman.getKey())
                .queryParam("token", TRELLO.Selman.getToken())
                .queryParam("name", faker.name().firstName())
                .post(baseUrl+"/1/cards");




    }

}
