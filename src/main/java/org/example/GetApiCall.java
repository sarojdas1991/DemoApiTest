package org.example;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.request;


public class GetApiCall {
    public static void main(String[] args) {
//String url="https://dummy.restapiexample.com/api/v1/employee/1";

       Response response =
//        Response response = get("https://dummy.restapiexample.com/api/v1/employee/1");
                 RestAssured.given().baseUri("https://reqres.in/api/users?page=2")
                .when().get().then()
                .log().all().extract().response();
//
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

    }
}
