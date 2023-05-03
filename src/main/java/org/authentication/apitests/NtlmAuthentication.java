package org.authentication.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.authentication.runner.ApiAUthenticationCall;

public class NtlmAuthentication implements ApiAUthenticationCall {
    public void NtlmAuth(){
        Response response= RestAssured.given().baseUri(PostmanUrl)
                .auth().ntlm(postmanUId,PostmanPw,"asjk","domain").
                when().get().
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }
}
