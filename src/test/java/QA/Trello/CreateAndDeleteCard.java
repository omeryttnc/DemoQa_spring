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
                queryParam("name", "Create and delete a card").queryParam("desc", "this card is just new created").

                when().post(baseUrl + "/1/cards");

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(null, jsonPath.getString("badges.trello.card"));

        WriteToTxt.saveTitle("idNumbers", jsonPath.getString("id"));

    }

   @AfterEach
    public void deleteCard() { // delete card with id number

        response=given().
                contentType(ContentType.JSON).
                pathParam("id", ReadTxt.returntitle("idNumbers")).
                queryParam("key", TRELLO.USER.YUSUF.getKey()).
                queryParam("token", TRELLO.USER.YUSUF.getToken()).
                delete(baseUrl + "/1/cards/{id}");
       System.out.println("*");
                response.prettyPrint();


        //Assert.assertEquals(true, response.asString().equals(" \"limits\": {\n" +
              


    }

}
