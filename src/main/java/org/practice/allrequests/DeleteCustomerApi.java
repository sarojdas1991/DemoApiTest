package org.practice.allrequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCustomerApi {
    public static void main(String[] args) {
        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Customer")
                .when().delete("/229039").then()
                .log().all().extract().response();
    }
}
