package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HawkAuthentication implements ApiAUthenticationCall{
    public void HawkAuth(){
        Response response = RestAssured.given().baseUri(PostmanUrl).
                header("authorization",HawkToken).
                when().get().
                then().
                log().all().extract().response();
        System.out.println("Status Code :" + response.getStatusCode());

    }
}
