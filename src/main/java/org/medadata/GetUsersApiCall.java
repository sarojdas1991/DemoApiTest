package org.medadata;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsersApiCall {
    public static void main(String[] args) {
        Response response= RestAssured.
                given().baseUri("http://restapi.adequateshop.com/api/Metadata").
                when().get("/users").
                then().log().all().extract().response();
        System.out.println("Status Code  :"+ response.getStatusCode());
        System.out.println("Body :"+ response.getBody().asString());
    }
}
