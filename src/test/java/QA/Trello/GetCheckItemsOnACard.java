package QA.Trello;

import QA.Enums.TRELLO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class GetCheckItemsOnACard  {
    /*curl --request GET \
  --url 'https://api.trello.com/1/cards/{id}/checkItemStates?key=APIKey&token=APIToken'*/

    String baseUrl="https://trello.com";
    Response response;

    @Test
    public void getCheckItemsOnACard(){
        response=given().contentType(ContentType.JSON)
                .queryParam("id", TRELLO.CARTS.YUSUFlISTCARD.getId())
                .queryParam("key", TRELLO.USER.YUSUF.getKey())
                .queryParam("token", TRELLO.USER.YUSUF.getToken())
                .when().get(baseUrl + "/1/cards/" + "id" + "/checkItemStates?" + "key" + "token");

        //Assert.assertEquals(200, response.getStatusCode());

    }




}
