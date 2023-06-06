package org.assessment.assessment1.swagerpetapitest;

import org.assessment.assessment1.allPetApiTestMethods.AllPetApiCall;
import org.testng.annotations.Test;

public class Scenario1 {
    AllPetApiCall allPetApiCall=new AllPetApiCall();

    @Test(priority = 2)
    public void UploadImage() {
        allPetApiCall.postPetImage();

    }
    @Test(priority = 1)
    public void PostPetData() {
        allPetApiCall.postNewPetData();
    }
    @Test(priority = 3)
    public void GetPetById () {
        allPetApiCall.getPetId();
    }
    @Test(priority = 4)
    public void GetPetByStatus (){
        allPetApiCall.GetPetDataByStatus();
    }
}
