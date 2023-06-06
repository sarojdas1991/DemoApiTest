package org.assessment.assessment1.swagerpetapitest;

import org.assessment.assessment1.allPetApiTestMethods.AllPetApiCall;
import org.testng.annotations.Test;

public class Scenario3 {
    AllPetApiCall allPetApiCall=new AllPetApiCall();
    @Test(priority = 1)
    public void UploadImage() {
        allPetApiCall.postPetImage();

    }
    @Test(priority = 2)
    public void UpdatePetData() {
        allPetApiCall.updatePetData();

    }
    @Test(priority = 3)
    public void DeletePet (){
        allPetApiCall.DeletePetDetails();

    }
}
