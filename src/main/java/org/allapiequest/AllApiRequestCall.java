package org.allapiequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import org.authentication.utils.ApiUtils;
import static org.testngApi.Utility.readPropertiesFile;

public class AllApiRequestCall {
    RequestSpecification requestSpecification;
    Response response;
    Properties prop;

    {
        try {
            prop = readPropertiesFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    Integer id;
    String requestPayload = "{\n" +
            "  \"name\": \"APITestDemo1\",\n" +
            "  \"job\": \"civil\",\n" ;
    String requestPayload1 = "{\n" +
            "  \"name\": \"APITestDemo2\",\n" +
            "  \"job\": \"civil\",\n" ;
    @BeforeTest
    public void beforeTest(){
        System.out.println("Setting up prerequisite for test execution");
        requestSpecification = RestAssured.given().baseUri(prop.getProperty("DummyReqApi"));

    }
   @Test(priority = 1)
    public void getRequest(){
        response= requestSpecification.
                when().get(prop.getProperty("GetEndPoint")).
                then().
                log().all().extract().response();
       Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Ok);

    }
    @Test(priority = 2)
    public void postRequest(){
        response= requestSpecification
//                .contentType("application/json")
                .body(requestPayload).
                when().post(prop.getProperty("PostEndPoint")).
                then().
                log().all().extract().response();
        id=response.jsonPath().getInt("id");
        System.out.println("id= "+id);
        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Created);

    }
   @Test(priority = 3)
    public void getRequestById(){
        response= requestSpecification.
                when().get(prop.getProperty("GetUserId")+id).
                then().
                log().all().extract().response();
       Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_NotFound);

    }

    @Test(priority = 4)
    public void putRequest(){
        response= requestSpecification
                .body(requestPayload1).
                when().put(prop.getProperty("GetUserId")+id).
                then().
                log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Ok);

    }
    @Test(priority = 5)
    public void deleteRequest(){
        response= requestSpecification.
                 when().delete(prop.getProperty("GetUserId")+id).
                 then().
                 log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_NoContent);

    }
    @AfterTest
    public void afterTest(){

    }
}
