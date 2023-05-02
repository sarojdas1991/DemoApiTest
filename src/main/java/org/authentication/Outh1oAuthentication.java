package org.authentication;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.response.Response;

public class Outh1oAuthentication implements ApiAUthenticationCall {
    public void Outh1Auth(){
        Response response= RestAssured.given().baseUri(PostmanUrl)
                .auth().
                oauth("RKCGzna7bv9YD57c","D+EdQ-gs$-%@2Nu7","","").
                when().get(Outh1EndPoint).
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }
}
