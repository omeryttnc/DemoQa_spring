package QA.Api_RestApi.TESTS;

import QA.Api_RestApi.POJOS.USER_CREATE;
import QA.Api_RestApi.POJOS.UserCreate;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class US01 {

    Response response;
    String endpoint = "https://demoqa.com/Account/v1/Authorized";
    UserCreate pojoBody = new UserCreate();

   Map<String,String> mapBody = new HashMap<>();




    @Test
    public void post01(){
        //1-Responce 2-String-entpoint  3-Body(String-POJO-MAP)

                /*1-body string
                2- map den body
                3- pojo*/
       //1_YOL
       // String bodyString ="{\n" +
       //         "  \"userName\": \"ttrycatch\",\n" +
        //        "  \"password\": \"JQ3iPpTEKTLjSQJ!\"\n" +
        //        "}";
       //2_YOL
        //mapBody.put("userName","ttrycatch");
        //mapBody.put("password","JQ3iPpTEKTLjSQJ!");
        //3_YOL
        //POJO yu olusur. pojodan obje olusturmam setter lar ile name ve password bigilerini gir.

        pojoBody.setUserName("ttrycatch");
        pojoBody.setPassword("JQ3iPpTEKTLjSQJ!");

        response = given().
                    contentType(ContentType.JSON)
                    .auth().basic("Elif","1234!Name").
                    body(pojoBody).
                   when().
                   post(endpoint);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().contentType(ContentType.JSON);
        assertEquals("true",response.asString());
    }

    @Test
    public void post02(){
        pojoBody.setUserName("ewrefd");
        pojoBody.setPassword("JQ3iPpTEKTLjSQJ!");

        response = given().
                    auth().basic("Elif","1234!Name").
                    body(pojoBody).
                    when().
                    post(endpoint);

        response.prettyPrint();
        System.out.println(response.statusCode());
        response.then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);

    }



    @Test
    public void post03(){

        pojoBody.setUserName("123456");
        pojoBody.setPassword("Abcd");

        response = given().
                contentType(ContentType.JSON).
                auth().basic("Elif","1234!Name").
                body(pojoBody).
                when().
                post(endpoint);

        response.prettyPrint();
        System.out.println(response.statusCode());
        response.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
        response.then().assertThat().body("message", Matchers.equalTo("User not found!"));

    }

    @Test
    public void post04(){
        pojoBody.setUserName("");
        pojoBody.setPassword("");

        response = given().
                contentType(ContentType.JSON).
                auth().basic("Elif","1234!Name").
                body(pojoBody).
                when().
                post(endpoint);

        response.prettyPrint();
        response.then().assertThat().statusCode(400).body("message",Matchers.equalTo("UserName and Password required."));


    }



}
