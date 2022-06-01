package QA.Api_RestApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    //https://restful-booker.herokuapp.com

    protected RequestSpecification spec01;

    @BeforeEach
    public void SetUp(){
        spec01 = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
