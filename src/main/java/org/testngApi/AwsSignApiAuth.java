package org.testngApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.authentication.utils.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

import static org.testngApi.Utility.readPropertiesFile;

public class AwsSignApiAuth {
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
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("---------Get Start Api Test ---------------");
    }

    @BeforeTest
    public void beforeApiCall(){
        System.out.println("Setting up prerequisite for test execution");
        requestSpecification = RestAssured.given().baseUri(prop.getProperty("PostmanUrl"));

    }
    @Test
    public void Apicall() {
        response= requestSpecification.header("authorization", ApiUtils.AwsToken).
                when().get().
                then().log().all().extract().response();

    }
    @AfterTest
    public void terminate(){
        System.out.println("Status Code :"+ response.getStatusCode());

    }
    @AfterSuite
    public void afterSuite(){
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("-----------Close Api Test__________");
    }
}
