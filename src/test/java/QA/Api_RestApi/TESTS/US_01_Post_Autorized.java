package QA.Api_RestApi.TESTS;

import QA.Api_RestApi.POJOS.US01AutorisedPojo;
import com.sun.xml.bind.v2.TODO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class US_01_Post_Autorized {
    /*
     * Kullanici adi  "ttrycatch" ve sifresi "JQ3iPpTEKTLjSQJ!" olan
     *         * kullanicinin active edildigini
     *         * response un "application/json" tipinde oldugunu
     *         * Status kodunun un 200 oldugunu
     *     dogrulayiniz.
     */
    /**post ve gette hangi tip veriyi gönderdigimizi Apiye söyliyecez(Contenttype)
     * Aiutoritioni da bildirmek gerekir Apiye*/
    Response response;
    String endpoint = "https://demoqa.com/Account/v1/Authorized";

    @Test
    public void TC0101Deneme() {
        // 1.yol
       /* String body = "{\n" +
                "  \"userName\": \"ttrycatch\",\n" +
                "  \"password\": \"JQ3iPpTEKTLjSQJ!\"\n" +
                "}";*/
        // 2.Yol
        /*Map<String, String> body = new HashMap<>();
        body.put("userName", "ttrycatch");
        body.put("password", "JQ3iPpTEKTLjSQJ!");*/
        // 3.yol
        US01AutorisedPojo obje= new US01AutorisedPojo("ttrycatch", "JQ3iPpTEKTLjSQJ!");
        // 4.Yol

        // Eger String degilde intiger paasword vb gönderoirseniz Pojo klassdan Stringi ==> Object e cevir.
        US01AutorisedPojo yeniobje= new US01AutorisedPojo();
        yeniobje.setUserName("ttrycatch");
        yeniobje.setPassword("JQ3iPpTEKTLjSQJ!");

        response = given().contentType(ContentType.JSON)
                .auth().basic("samet1", "ABCabc987+%&")
                .body(yeniobje)
                .when()
                .post(endpoint);
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());


    }
    public Response myPostResponse(Object myBody){
        response = given().contentType(ContentType.JSON)
                .auth().basic("samet1", "ABCabc987+%&")
                .body(myBody)
                .when()
                .post(endpoint);
        response.prettyPrint();
        return response;


    }

    @Test
    public void TC0101() {
       US01AutorisedPojo obj= new US01AutorisedPojo();
       obj.setUserName("ttrycatch");
       obj.setPassword("JQ3iPpTEKTLjSQJ!");
        Assert.assertEquals(myPostResponse(obj).prettyPrint(),"true");
        myPostResponse(obj).then().assertThat().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);


    }

    @Test
    public void TC0101Deneme1() {
        // Response Endpoint Body(String,Map, Pojo)
        // 1.yol
        String body = "{\n" +
                "  \"userName\": \"ttrycatch\",\n" +
                "  \"password\": \"JQ3iPpTEKTLjSQJ!\"\n" +
                "}";
        response = given().contentType(ContentType.JSON).
                auth().basic("samet1","ABCabc987+%&").
                when().body(body).post(endpoint);


    }

    @Test
    public void post02() {
        /*response = given().contentType(ContentType.JSON)
                .auth().basic("samet1", "ABCabc987+%&")
                .body()*/
    }
}
