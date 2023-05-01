package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class BasicAuthApiCall {
    public static void main(String[] args) {
        JSONObject requestPayload=new JSONObject();
        requestPayload.put("email", "APItestDemo5@gmail.com");
        requestPayload.put("password", "password@123");
        Response response1 = RestAssured.given().baseUri("https://postman-echo.com/basic-auth")
                .auth().preemptive().basic("postman", "password")
//                .contentType("application/json").header("Authorization","Bearer"+token).
                .when().post().then()
                .log().all().extract().response();
        System.out.println("Status Code :"+ response1.getStatusCode());
    }
}
