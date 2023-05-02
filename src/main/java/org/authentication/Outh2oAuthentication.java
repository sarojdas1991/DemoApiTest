package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Outh2oAuthentication implements ApiAUthenticationCall{

    public void outh2Auth(){
        Response response= RestAssured.given().baseUri(GitApiUrl)
                .auth().oauth2(GitToken).
                when().get(GitEndPoint).
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }

    }


