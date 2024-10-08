package com.thetestingacademy.BaseTests;


// Common to All to TestCase
//  Base Test Father -> Testcase - Son - Single Inheritance

import com.thetestingacademy.Asserts.AssertActions;
import com.thetestingacademy.Endpoints.APIConstants;
import com.thetestingacademy.Modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public JsonPath jsonPath;
    public PayloadManager payloadManager;
    public AssertActions assertActions;

    //  TC - Header

    @BeforeTest
    public void setUp() {
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given();
        requestSpecification.basePath(APIConstants.BASE_URL);
        requestSpecification.contentType(ContentType.JSON).log().all();


//or u can also write code using requestbuilder
//        requestSpecification = RestAssured.
//                given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();


    }
//Post request to create a token
    public String getToken() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.basePath(APIConstants.AUTH_URL);


        //setting the payload
        String payload = payloadManager.setAuthPayload();

        //get the token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();

        //token extraction
        String token = payloadManager.getTokenFromJSON(response.asString());

        return token;
    }
}
