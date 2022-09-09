package QA.Trello;

import QA.Enums.TRELLO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class GetCheckItemsOnACard  {
    /*curl --request GET \
  --url 'https://api.trello.com/1/cards/{id}/checkItemStates?key=APIKey&token=APIToken'*/

    String baseUrl="https://api.trello.com";
    Response response;

    @Test
    public void getCheckItemsOnACard(){
        response=given().contentType(ContentType.JSON)
                .queryParam("id", TRELLO.CARTS.YUSUFlISTCARD.getId())
                .queryParam("key", TRELLO.USER.YUSUF.getKey())
                .queryParam("token", TRELLO.USER.YUSUF.getToken())
                .when().get(baseUrl + "/1/cards/631a62f891f867018228d293/checkItemStates?key=APIKey&token=APIToken");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200, response.statusCode());


        System.out.println(jsonPath.getList("idCheckItem").get(1));
        System.out.println(jsonPath.getList("idCheckItem").get(5));
        Assert.assertEquals("631a633e5cac0103685df3a3", jsonPath.getList("idCheckItem").get(0));
        Assert.assertEquals("complete", jsonPath.getList("state").get(0));

    }

}
