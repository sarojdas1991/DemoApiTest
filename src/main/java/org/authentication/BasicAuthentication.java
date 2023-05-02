package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuthentication implements ApiAUthenticationCall{
    public  void BasicAuth(){
//        Response response=RestAssured.given().baseUri("https://postman-echo.com")
//                          .auth().basic("postman", "password").
//                           when().get("/basic-auth").
//                           then().log().all().extract().response();
//        System.out.println("Status Code :"+ response.getStatusCode());
        Response response=RestAssured.given().baseUri(PostmanUrl)
                .auth().basic(postmanUId, PostmanPw).
                when().get(BasicEndPoint).
                then().log().all().extract().response();
        System.out.println("Status Code :"+ response.getStatusCode());
    }
}
