package org.allapiequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PassengerDetails {
    RequestSpecification requestSpecification;
    Response response;
    String requestPayload = "{\n" +
            "  \"name\": \"APITestDemo1\",\n" +
            "  \"trips\": \"10\",\n"+
            "  \"airlines\": \"40\"";
    @BeforeTest
    public void beforeTest(){
        System.out.println("Setting up prerequisite for test execution");
        requestSpecification = RestAssured.given().baseUri("https://api.instantwebtools.net/v1/passenger");

    }
    @Test
    public void postRequest(){
        response= requestSpecification
                .contentType("application/json")
                .body(requestPayload).
                when().post().
                then().
                log().all().extract().response();

    }
}
