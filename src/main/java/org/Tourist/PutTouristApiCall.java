package org.Tourist;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class PutTouristApiCall {
    public static void main(String[] args) {
        JSONObject object=new JSONObject();
        object.put("tourist_name","Jhon");
        object.put("tourist_email","jhon@gmail.com");
        object.put("tourist_location","pune");
        Response response= RestAssured.given().baseUri("http://restapi.adequateshop.com/api/Tourist").
                contentType("application/json").body(object.toString()).
                when().put("/229033").
                then().log().all().extract().response();
        System.out.println("StatusCode:"+response.getStatusCode());

    }

}
