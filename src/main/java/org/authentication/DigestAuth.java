package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DigestAuth implements ApiAUthenticationCall {
//    public static void main(String[] args)
    public void DigestAut(){
        Response response= RestAssured.given().baseUri(PostmanUrl)
                .auth().digest(postmanUId, PostmanPw).
                when().get(DigestEndPoint).
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }
}
