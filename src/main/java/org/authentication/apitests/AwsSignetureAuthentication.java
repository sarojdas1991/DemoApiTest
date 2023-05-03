package org.authentication.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.authentication.runner.ApiAUthenticationCall;

public class AwsSignetureAuthentication implements ApiAUthenticationCall {
    public void AwsAuth(){
        Response response = RestAssured.given().baseUri(PostmanUrl).
                header("authorization", "AWS4-HMAC-SHA256 Credential=APITEST/20230502/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=3d5fcd0f030e1df076725000381657e1ae74c278978e373d5eea0adad510f5f7").
                when().get().
                then().log().all().extract().response();
        System.out.println("Status Code :" + response.getStatusCode());
    }

}
