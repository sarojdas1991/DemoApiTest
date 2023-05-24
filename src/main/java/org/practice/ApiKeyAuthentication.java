package org.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.authentication.runner.ApiAUthenticationCall;
import org.basicutility.utils.ApiUtils;

public class ApiKeyAuthentication implements ApiAUthenticationCall {

      public void ApiKeyAuth(){
          Response response= RestAssured.given().baseUri(ApiUtils.API_AUTH_URL).
                  header(ApiKey,ApiValue).
                  when().get(ApiKeyEndPoint).
                  then().log().all().extract().response();
          System.out.println("Status Code :"+ response.getStatusCode());
    }
}
