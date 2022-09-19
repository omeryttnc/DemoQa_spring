package QA.Trello;

import QA.Enums.TRELLO;
import QA.utilities.ReadTxt;
import QA.utilities.WriteToTxt;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class CreateNewCard {

    String baseUrl = "https://trello.com";
    Response response;

    //@Test

//    public void createCard() {
//
//        given().contentType(ContentType.JSON).
//                queryParam("idList", TRELLO.CARTS.LISTE1KART1.getIdList()).
//                queryParam("key", TRELLO.USER.SELMAN.getKey()).
//                queryParam("token", TRELLO.USER.SELMAN.getToken()).
//                queryParam("name", "A new card is created").
//
//       when().  log().all().post(baseUrl + "/1/cards").
//
//       then().  statusCode(200).
//                header("Content-Type",equalTo("application/json; charset=utf-8")).
//                header("Content-Length",equalTo("1148")).
//                body("badges.attachmentsByType.trello.card",equalTo(0)).
//                body("closed", equalTo(false));
//
//    }

    @Test
    public void createCart2(){

        response = given().contentType(ContentType.JSON).
                            queryParam("idList", TRELLO.CARTS.LISTE1KART1.getIdList()).
                            queryParam("key", TRELLO.USER.SELMAN.getKey()).
                            queryParam("token", TRELLO.USER.SELMAN.getToken()).
                            queryParam("name", "New card is created").queryParam("desc", "this card is just new created").

                    when(). post(baseUrl + "/1/cards");

        JsonPath js = response.jsonPath();
       // Assert.assertEquals("0", response.path("badges.attachmentsByType.trello.card")); //
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
        Assert.assertEquals(0, js.getInt("badges.attachmentsByType.trello.card"));

        Map<String, Object> tmap = js.getMap("");
        System.out.println("tmap = " + tmap);

        System.out.println("tmap.get(\"badges.attachmentsByType.trello.card\") = " + tmap.get("badges.attachmentsByType.trello.card"));
        System.out.println("js.get(\"badges.attachmentsByType.trello.card\") = " + js.get("badges.attachmentsByType.trello.card"));

       //Map<String, Object> tmapBadge = (Map<String, Object>) tmap.get("badges");
      // System.out.println("tmapBadge = " + tmapBadge);

        WriteToTxt.saveTitle("idNumbers", js.getString("id" ));

  //Delete the just new created card
//        String id = response.path("id");
//        given().
//                contentType(ContentType.JSON).
//        and().
//                pathParam("id",id).
//                queryParam("idList", TRELLO.CARTS.LISTE1KART1.getIdList()).
//                queryParam("key", TRELLO.USER.SELMAN.getKey()).
//                queryParam("token", TRELLO.USER.SELMAN.getToken()).
//        when().
//                delete(baseUrl + "/1/cards/{id}");
//

    }
  @AfterEach
    public void deleteCard(){ // delete cart with id number

        given().
                contentType(ContentType.JSON).
        and().
                pathParam("id", ReadTxt.returntitle("idNumbers")).
                queryParam("idList", TRELLO.CARTS.LISTE1KART1.getIdList()).
                queryParam("key", TRELLO.USER.SELMAN.getKey()).
                queryParam("token", TRELLO.USER.SELMAN.getToken()).
        when().
                delete(baseUrl + "/1/cards/{id}");



    }




}
