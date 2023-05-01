package org.Tourist;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTouristApiCall {
    public static void main(String[] args) {
        Response response= RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Tourist/229083").
                when().delete().
                then().log().all().extract().response();
        System.out.println("StatusCode:"+response.getStatusCode());
    }
}
