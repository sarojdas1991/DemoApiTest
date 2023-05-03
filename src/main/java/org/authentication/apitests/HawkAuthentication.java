package org.authentication.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.authentication.runner.ApiAUthenticationCall;

public class HawkAuthentication implements ApiAUthenticationCall {
    public void HawkAuth(){
        Response response = RestAssured.given().baseUri(PostmanUrl).
                header("authorization",HawkToken).
                when().get().
                then().
                log().all().extract().response();
        System.out.println("Status Code :" + response.getStatusCode());

    }
}
