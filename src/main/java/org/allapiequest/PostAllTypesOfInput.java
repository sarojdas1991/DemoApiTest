package org.allapiequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostAllTypesOfInput {
    RequestSpecification requestSpecification;
    Response response;
    GetSet requestPayload=new GetSet();
//    String requestPayload = "{\n" +
//            "  \"name\": \"APITestDemo1\",\n" +
//            "  \"salary\": \"10\",\n"+
//            "  \"age\": \"40\"";


    @BeforeTest
    public void beforeTest(){
        System.out.println("Setting up prerequisite for test execution");
        requestSpecification = RestAssured.given().baseUri("https://dummy.restapiexample.com");

    }
    @Test
    public void postRequest(){
        requestPayload.setName("abs");
        requestPayload.setSalary("123");
        requestPayload.setAge("23");
        response= requestSpecification
                .contentType("application/json")
                .body(requestPayload.toString()).
                when().post("/api/v1/create").
                then().
                log().all().extract().response();

    }
}
