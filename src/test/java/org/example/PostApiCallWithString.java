package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostApiCallWithString {
    public static void main(String[] args) {
        String requestPayload = "{\n" +
                "  \"name\": \"APITestDemo2\",\n" +
                "  \"email\": \"APItestDemo2@gmail.com\",\n" +
                "  \"password\": \"password@123\" \n}";
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/authaccount")
                .contentType("application/json").body(requestPayload).when().post("/registration").then()
                .log().all().extract().response();

        if (response.jsonPath().get("data") != null) {
            System.out.println("Token Value: " + response.jsonPath().get("data.Token"));
        } else {
            System.out.println("Response Message: " + response.jsonPath().get("data.message"));
        }

    }
}
