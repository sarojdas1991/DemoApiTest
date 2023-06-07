package org.assessment.assessment2.apicall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assessment.assessment2.utility.ConvertExcelToJson;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ApiCall {
    ConvertExcelToJson cve =new ConvertExcelToJson();
    JSONObject jsonObject;
    @Test(priority = 1)
    public void readExcel() {
         jsonObject= cve.convertExceltoJsonData();
    }
    @Test(priority = 2)
    public void callApi(){
        RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
                .post("https://reqres.in/api/users").then().statusCode(201).log().all();
    }
    }

