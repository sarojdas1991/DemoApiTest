package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AkaaiAuth  implements ApiAUthenticationCall{
    public void Akamai(){
        Response response= RestAssured.given().baseUri(PostmanUrl).
                header("authorization",AkamaiAuthValue).
                when().get().
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }
}
