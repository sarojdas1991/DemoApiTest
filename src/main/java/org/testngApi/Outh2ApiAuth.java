package org.testngApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.basicutility.utils.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

import static org.basicutility.utils.Utility.readPropertiesFile;

public class Outh2ApiAuth {
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
        requestSpecification = RestAssured.given().baseUri(prop.getProperty("GitApiUrl"));

    }
    @Test
    public void Apicall() {
        response= requestSpecification.auth().oauth2(ApiUtils.GitToken).
                when().get(ApiUtils.GitEndPoint).
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());

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
