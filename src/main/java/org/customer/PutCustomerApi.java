package org.customer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PutCustomerApi {
    public static void main(String[] args) {
        JSONObject requestPayload = new JSONObject();
        requestPayload.put("id", "229039");
        requestPayload.put("name", "APITestDemo4");
        requestPayload.put("email", "APItestDemo4@gmail.com");
        requestPayload.put("location", "pune");
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Customer/229039")
                .contentType("application/json").body(requestPayload.toString()).when().put().then()
                .log().all().extract().response();
//       given().body(requestPayload.toString()).when().put("http://restapi.adequateshop.com/api/Customer/229039").then().log().all();
    }
}
