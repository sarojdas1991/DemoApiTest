package org.authentication.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.authentication.runner.ApiAUthenticationCall;

public class JwtToken implements ApiAUthenticationCall {
    public void JwtAUth() {
        Response response = RestAssured.given().baseUri(PostmanUrl).
                header("authorization", JwtToken).
                when().get().
                then().log().all().extract().response();
        System.out.println("Status Code :" + response.getStatusCode());
    }
}
