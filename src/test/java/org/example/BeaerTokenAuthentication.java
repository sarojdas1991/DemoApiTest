package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class BeaerTokenAuthentication {
    public static void main(String[] args) {
        JSONObject requestPayload = new JSONObject();
        requestPayload.put("name", "APITestDemo5");
        requestPayload.put("email", "APItestDemo5@gmail.com");
        requestPayload.put("password", "password@123");
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/authaccount")
                .contentType("application/json").body(requestPayload.toString()).when().post("/registration").then()
                .log().all().extract().response();
        String token = response.jsonPath().get("data.Token");

        if (response.jsonPath().get("data") != null) {
            System.out.println("Token Value: " + token);
        } else {
            System.out.println("Response Message: " + response.jsonPath().get("data.message"));
        }
        requestPayload.put("email", "APItestDemo5@gmail.com");
        requestPayload.put("password", "password@123");
        Response response1 = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/authaccount")
                .contentType("application/json").header("Authorization","Bearer"+token).body(requestPayload.toString()).when().post("/login").then()
                .log().all().extract().response();
        System.out.println("Status Code :"+ response1.getStatusCode());
    }
}
