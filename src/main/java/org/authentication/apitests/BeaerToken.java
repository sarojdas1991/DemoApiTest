package org.authentication.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.authentication.runner.ApiAUthenticationCall;

public class BeaerToken implements ApiAUthenticationCall {
//    public static void main(String[] args) {
    public void BeaerTokenAuth(){
        JSONObject requestPayload = new JSONObject();
        requestPayload.put("name", "APITestDemo6");
        requestPayload.put("email", "APItestDemo6@gmail.com");
        requestPayload.put("password", "password@123");
        Response response = RestAssured.given().baseUri(BeaerAuthUrl)
                .contentType("application/json").body(requestPayload.toString()).when().post(RegEndPoint).then()
                .log().all().extract().response();
        String token = response.jsonPath().get("data.Token");

        if (response.jsonPath().get("data") != null) {
            System.out.println("Token Value: " + token);
        } else {
            System.out.println("Response Message: " + response.jsonPath().get("data.message"));
        }
        requestPayload.put("email", "APItestDemo6@gmail.com");
        requestPayload.put("password", "password@123");
        Response response1 = RestAssured.given().baseUri(BeaerAuthUrl)
                .contentType("application/json").header("Authorization","Bearer"+token).body(requestPayload.toString()).when().post(LoginEndPoint).then()
                .log().all().extract().response();
        System.out.println("Status Code :"+ response1.getStatusCode());
    }
}
