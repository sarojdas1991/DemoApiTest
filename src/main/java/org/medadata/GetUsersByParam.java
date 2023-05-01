package org.medadata;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsersByParam {
    public static void main(String[] args) {
        Response response= RestAssured.
                given().baseUri("http://restapi.adequateshop.com/api/Metadata/GetUsersByParam").
                when().get("?city=London").
                then().log().all().extract().response();
        System.out.println("Status Code  :"+ response.getStatusCode());
        System.out.println("Body :"+ response.getBody().asString());
    }
}
