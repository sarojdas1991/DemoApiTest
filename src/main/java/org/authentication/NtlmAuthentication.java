package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NtlmAuthentication implements ApiAUthenticationCall{
    public void NtlmAuth(){
        Response response= RestAssured.given().baseUri(PostmanUrl)
                .auth().ntlm(postmanUId,PostmanPw,"asjk","domain").
                when().get().
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }
}
