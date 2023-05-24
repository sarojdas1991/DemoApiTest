package org.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetEmpApiCall {
    public static void main(String[] args) {
        Response response = RestAssured.get("http://restapi.adequateshop.com/api/Metadata/GetEmployees");
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println(response.getBody().asString());
    }
}
