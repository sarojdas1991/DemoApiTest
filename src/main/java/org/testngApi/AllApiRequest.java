package org.testngApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

import static org.testngApi.Utility.readPropertiesFile;

public class AllApiRequest {
    Properties prop;

    {
        try {
            prop = readPropertiesFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    RequestSpecification requestSpecification;
    Response response;
//    String jsonBody = "{\"name\":\"zozo101\",\"salary\":\"1234\",\"age\":\"23\"}";
    String requestPayload = "{\n" +
            "  \"name\": \"APITestDemo6\",\n" +
            "  \"salary\": \"1234\",\n" +
            "  \"age\": \"23\" \n}";
    Integer id;
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("---------Get Start Api Test ---------------");

    }

   @BeforeTest
    public void beforeTest(){
       System.out.println("Setting up prerequisite for test execution");
       requestSpecification = RestAssured.given().baseUri(prop.getProperty("DUmmyApi"));

    }
//    @Test(priority = 1)
      public void getRequest() {
        response= requestSpecification.
                when().get(prop.getProperty("Endpoint1")).
                then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
        hardPause();

    }
    @Test(priority = 2)
    public void postRequest(){
        response= requestSpecification.contentType("application/json").body(requestPayload).
                when().post(prop.getProperty("Endpoint2")).
                then().log().all().extract().response();

         id=response.jsonPath().get("data.id");
//        response.jsonPath().get("data.Token");
        System.out.println("id = "+ response.jsonPath().get("data.id"));
        Assert.assertEquals(response.getStatusCode(),200);
        hardPause();
    }
    @Test(priority = 3)
    public void getRequestId() {
        response= requestSpecification.
                when().get(prop.getProperty("Endpoint5")+id).
                then().log().all().extract().response();
        System.out.println("status code"+ response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(),200);
        hardPause();

    }
   @Test(priority = 4)
    public void putRequest(){
        response= requestSpecification.contentType("application/json").body(requestPayload).
                when().put(prop.getProperty("Endpoint3")+id).
                then().log().all().extract().response();
       System.out.println("status code"+ response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(),200);
       hardPause();

    }
   @Test(priority = 5)
    public void deleteRequest(){
        response= requestSpecification.
                when().delete(prop.getProperty("Endpoint4")).
                then().log().all().extract().response();
       System.out.println("status code"+ response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(),200);

    }
   @AfterTest
    public void afterTest(){
       System.out.println("Api test complete");


    }
    @AfterSuite
    public void afterSuite(){
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("-----------Close Api Test__________");
    }



    private void hardPause() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
