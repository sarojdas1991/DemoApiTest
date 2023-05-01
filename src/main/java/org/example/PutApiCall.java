package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class PutApiCall {
    public static void main(String[] args) {
        JSONObject requestPayload = new JSONObject();
        requestPayload.put("name", "APITestDemo3");
        requestPayload.put("email", "APItestDemo3@gmail.com");
        requestPayload.put("password", "password@123");
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/authaccount")
                .contentType("application/json").body(requestPayload.toString()).when().post("/registration").then()
                .log().all().extract().response();

        if (response.jsonPath().get("data") != null) {
            System.out.println("Token Value: " + response.jsonPath().get("data.Token"));
        } else {
            System.out.println("Response Message: " + response.jsonPath().get("data.message"));
        }
    }
}
