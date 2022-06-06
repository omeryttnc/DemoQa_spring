package QA.Api_RestApi.TESTS;

import QA.Api_RestApi.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class INS_2 extends TestBase {
    Response response;

    @Test
    public void get01(){
        response = given().spec(spec01).when().get();
        response.prettyPrint();

        //söyle de yazabiliriz:
        //bunu get icine uzun query paramlar yazmak yerine kullaniriz
        Response response1 = given().
                spec(spec01).queryParam("firstname","Mark").
                when().
                get();

    }
    @Test
    public void get02() {
        response = given().spec(spec01).when().get("/booking/7");
        response.prettyPrint();

        //JSON PAth objesi olusturma //JSON formati datalarin icinde seyati kolaylastirir
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("firstname"));
       // assertEquals(//mesaj,//expected,//value);
        assertEquals("Mark",jsonPath.getString("firstname"),"firstname Mark degil");
        System.out.println(" isim Mark");


        System.out.println(jsonPath.getBoolean("depositpaid"));
        assertTrue(jsonPath.getBoolean("depositpaid"));




        //JSON json.getList --> verileri list in icine atar
        jsonPath.getList("firstname");
    }
    }
