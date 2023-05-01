package org.customer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import java.util.Map;

public class PostCustomerApi {
    public static void main(String[] args) {

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("name", "APITestDemo4");
        requestPayload.put("email", "APItestDemo4@gmail.com");
        requestPayload.put("location", "pune");
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Customer")
                .contentType("application/json").body(requestPayload.toString()).when().post().then()
                .log().all().extract().response();

    }
}
