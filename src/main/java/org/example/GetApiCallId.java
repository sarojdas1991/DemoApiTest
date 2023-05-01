package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetApiCallId {
    public static void main(String[] args) {
//        Response response = RestAssured.get("http://restapi.adequateshop.com/api/Customer/229036");
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Customer")
                .when().get("/229036").then()
                .log().all().extract().response();

        if (response.jsonPath().get("data") != null) {
            System.out.println("Token Value: " + response.jsonPath().get("data.Token"));
        } else {
            System.out.println("Response Message: " + response.jsonPath().get("data.message"));
        }
//          System.out.println("Response : "+ response);
//       System.out.println("Status Code : "+response.getStatusCode());
//        given().get("https://dummy.restapiexample.com/api/v1/employees").then().log().all();


    }
}


