package org.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiKeyAuthentication implements ApiAUthenticationCall{

      public void ApiKeyAuth(){
          Response response= RestAssured.given().baseUri(ApiAutUrl).
                  header(ApiKey,ApiValue).
                  when().get(ApiKeyEndPoint).
                  then().log().all().extract().response();
          System.out.println("Status Code :"+ response.getStatusCode());
    }
}
