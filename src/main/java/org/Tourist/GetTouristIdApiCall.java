package org.Tourist;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTouristIdApiCall {
    public static void main(String[] args) {
        Response response= RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Tourist").
                when().get("/229083").
                then().log().all().extract().response();
        System.out.println("StatusCode:"+response.getStatusCode());
    }
}
