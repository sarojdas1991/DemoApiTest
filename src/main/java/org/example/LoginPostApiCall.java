package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class LoginPostApiCall {
    public static void main(String[] args) {
        JSONObject requestPayload = new JSONObject();
//        requestPayload.put("name", "APITestDemo3");
        requestPayload.put("email", "APItestDemo3@gmail.com");
        requestPayload.put("password", "password@123");
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/authaccount")
                .contentType("application/json").body(requestPayload.toString()).when().post("/login").then()
                .log().all().extract().response();
        System.out.println("Status Code : "+response.getStatusCode());
    }
}
