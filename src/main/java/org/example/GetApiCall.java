package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetApiCall {
    public static void main(String[] args) {

        Response response = RestAssured.get("http://restapi.adequateshop.com/api/Customer");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

    }
}
