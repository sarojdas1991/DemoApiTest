package org.assessment.assessment1.allPetApiTestMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assessment.assessment1.UtilityPackage.AllConstants;
import org.assessment.assessment1.UtilityPackage.FileHandles;
import org.basicutility.utils.ApiUtils;
import org.testng.Assert;

import java.io.File;

public class AllPetApiCall {
    /*
    The bellow methods use for getting pet details by using petId
    */
    public static void getPetId(){
        Response response = RestAssured
                .given().baseUri(AllConstants.BaseUrl_Pet)
                .get("/pet/"+ AllConstants.Pet_Id).then()
                .log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), ApiUtils.Status_Ok);
    }
    /*
    The bellow methods use for creating new pet data
    */
    public static void postNewPetData(){
        String requestPayload= FileHandles.readJson("pet.json");
        Response response = RestAssured
                .given().baseUri(AllConstants.BaseUrl_Pet)
                .contentType("application/json").body(requestPayload).when().post("/pet").then()
                .log().all().extract().response();

        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Ok);

    }
    /*
    The bellow methods use for uploading the petimmage
    */
    public static void postPetImage(){
        String fs = File.separator;
        String myPath = "src" + fs + "main"+ fs +"resources"+ fs +"testng1.png";
        File file1 = new File(myPath);
        Response response = RestAssured
                .given().baseUri(AllConstants.BaseUrl_Pet)
                .multiPart("file", file1)
                .post("/pet/{petId}/uploadImage", AllConstants.Pet_Id).then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), ApiUtils.Status_Ok);
        response.prettyPrint();
    }
    /*
    The bellow methods use for getting pet details by using pet status
    */
    public static void GetPetDataByStatus(){
        Response response = RestAssured
                .given().baseUri(AllConstants.BaseUrl_Pet)
                .when()
                .get("/pet/findByStatus?status=available&status=available");
//                .then();
//                .log().all().extract().response();
        System.out.println(response.body());
        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Ok);

    }
    /*
    The bellow methods use for deleting pet details by using petId
    */
    public static void DeletePetDetails(){
        Response response = RestAssured
                .given().baseUri(AllConstants.BaseUrl_Pet)
                .delete("/pet/"+AllConstants.Pet_Id).then()
                .log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Ok);
    }
    /*
    The bellow methods use for updating the pet details.
    */
    public static void updatePetData(){
        String requestPayload= FileHandles.readJson("updatePet.json");
        Response response = RestAssured
                .given().baseUri(AllConstants.BaseUrl_Pet)
                .contentType("application/json").body(requestPayload).when().put("/pet").then()
                .log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(),ApiUtils.Status_Ok);
    }



}
