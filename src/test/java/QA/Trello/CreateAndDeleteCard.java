package QA.Trello;

import QA.Enums.TRELLO;
import QA.utilities.ReadTxt;
import QA.utilities.WriteToTxt;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

public class CreateAndDeleteCard {
    String baseUrl = "https://trello.com";
    Response response;


    @Test
    public void createCart2() {

        response = given().contentType(ContentType.JSON).
                queryParam("idList", TRELLO.CARTS.YUSUFlISTCARD.getIdList()).
                queryParam("key", TRELLO.USER.YUSUF.getKey()).
                queryParam("token", TRELLO.USER.YUSUF.getToken()).
                queryParam("name", "Yusuf card is created").queryParam("desc", "this card is just new created").

                when().post(baseUrl + "/1/cards");

        JsonPath js = response.jsonPath();
        Assert.assertEquals(200, response.statusCode());
        WriteToTxt.saveTitle("idNumbers", js.getString("id"));

    }

    @AfterEach
    public void deleteCard() { // delete card with id number

        given().
                contentType(ContentType.JSON).
                pathParam("id", ReadTxt.returntitle("idNumbers")).
                queryParam("idList", TRELLO.CARTS.YUSUFlISTCARD.getIdList()).
                queryParam("key", TRELLO.USER.YUSUF.getKey()).
                queryParam("token", TRELLO.USER.YUSUF.getToken()).
                delete(baseUrl + "/1/cards/{id}");

        //Assert.assertEquals(true, response.asString().equals(empty()));

        System.out.println(response.asString());

    }

}