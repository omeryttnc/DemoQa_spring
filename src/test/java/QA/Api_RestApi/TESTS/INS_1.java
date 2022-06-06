package QA.Api_RestApi.TESTS;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class INS_1 {
    Response response;

    @Test
    public void getMethod(){
         given().
                when().
                get("https://restful-booker.herokuapp.com/booking/7").prettyPrint();

    }
    @Test
    public void getMethod2(){
        response = given().
                when().
                get("https://restful-booker.herokuapp.com/booking/7");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().assertThat().contentType("application/json");

        //KONU ANL:

        //responce consola yazdirma:
        //responce.prettyPrint();

        //status code consaldaa görmek:
        System.out.println(response.getStatusCode());

        //statusline i yazdirma
        System.out.println(response.getStatusLine());

        //contenttyp i yazdirma
        System.out.println(response.contentType());

        //headers daki tüm bilgileri alma:
        System.out.println(response.getHeaders());

        //headersdaki istenen specifik bilgi:
        System.out.println("server bilgisi: " + response.getHeader("Server"));

    }
     /*
    A POZITIVE SCENARIO:
    when() Bir GET Request asagida verilen Endpoint'e yollanir.
           https://restful-booker.herokuapp.com/booking
    and() Accept Type'i "applications/json" dir
    then() statuscodu 200 dür
    and() content type "application/json" dir.
    * */

    @Test
    public void get02(){
        response = given().
                accept(ContentType.JSON).
                when().
                get("https://restful-booker.herokuapp.com/booking/5");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().assertThat().contentType("application/json");

    }
    @Test
    public void get03() {
        /*Negative Scenario
         when() Bir GET Request asagida verilen Endpoint'e yollanir.
           https://restful-booker.herokuapp.com/booking/1001
    then() statuscodu 404 dür
    and() Response body de "Not Found" var
    and() Response body de "Celikkal" yok
        */
        response = given().
                accept(ContentType.JSON).
                when().
                get("https://restful-booker.herokuapp.com/booking/5");
        response.prettyPrint();

        assertEquals(404,response.statusCode());
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("Calikkal"));

    }

    //MATCHERS Class ve Body icindeki verileri dogrulama
    @Test
    public void get04() {
        /*
        when() Bir GET Request asagida verilen Endpoint'e yollanir.
        https://restful-booker.herokuapp.com/booking/7
        status code, content type ve body icindeki verileri dogrulayalim
        */
        response = given().
                when().
                get("https://restful-booker.herokuapp.com/booking/7");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat().body("firstname", Matchers.equalTo("Mark"));


        //size alma - sayisini alma
//        response.then().assertThat().body("data.id",Matchers.hasSize(24));

        // .... isim de biri varmi?  böyle bir data var mi?
 //       response.then().assertThat().body("data.employee_name",Matchers.hasItem("Ashton Cox"));

        // .... uzunluk ölcme
 //       response.then().assertThat().body("data.employee_name[1]",Matchers.hasLength(15));
        response.then().assertThat().body("firstname", Matchers.equalTo("Mark"),
                "lastname",Matchers.equalTo("Ericsson"));



    }
}
