package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JwtToken implements ApiAUthenticationCall {
    public void JwtAUth() {
        Response response = RestAssured.given().baseUri(PostmanUrl).
                header("authorization", JwtToken).
                when().get().
                then().log().all().extract().response();
        System.out.println("Status Code :" + response.getStatusCode());
    }
}
