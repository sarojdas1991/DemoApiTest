package org.testngApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;
import org.basicutility.utils.ApiUtils;

import static org.basicutility.utils.Utility.readPropertiesFile;

public class ApiKeyAuth {
    Properties prop = readPropertiesFile();
    RequestSpecification requestSpecification;
    Response response;

    public ApiKeyAuth() throws IOException {
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("---------Get Start Api Test ---------------");
    }

    @BeforeTest
    public void beforeApiCall(){
        System.out.println("Setting up prerequisite for test execution");
        requestSpecification = RestAssured.given().baseUri(prop.getProperty("ApiAutUrl"));

    }
    @Test
    public void Apicall() {
        response= requestSpecification.
                header(ApiUtils.ApiKey,ApiUtils.ApiValue).
                when().get(prop.getProperty("ApiKeyEndPoint")).
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
