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

public class BeaerApiAuth {
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
    String token;
    String requestPayload = "{\n" +
            "  \"name\": \"APITestDemo7\",\n" +
            "  \"email\": \"APItestDemo7@gmail.com\",\n" +
            "  \"password\": \"password@123\" \n}";
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("---------Get Start Api Test ---------------");
    }

    @BeforeTest
    public void beforeApiCall(){
        System.out.println("Setting up prerequisite for test execution");
        requestSpecification = RestAssured.given().baseUri(prop.getProperty("BeaerAuthUrl"));

    }
    @Test(priority = 1)
    public void ApiPostcall() {
        response= requestSpecification.
                contentType("application/json").body(requestPayload.toString()).when().post(ApiUtils.RegEndPoint).then()
                .log().all().extract().response();
              token = response.jsonPath().get("data.Token");


    }
    @Test(priority = 2)
    public void ApiGetcall() {
        response= requestSpecification
                .contentType("application/json").header("Authorization","Bearer"+token).body(requestPayload.toString()).when().post(ApiUtils.LoginEndPoint).then()
                .log().all().extract().response();
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
