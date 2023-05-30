package org.assessment.assessment1.Runner;

import org.assessment.assessment1.allPetApiTestMethods.AllPetApiCall;
import org.testng.annotations.Test;

public class Scenario1 {
    @Test(priority = 2)
    public void UploadImage() {
        AllPetApiCall.postPetImage();

    }
    @Test(priority = 1)
    public void PostPetData() {
        AllPetApiCall.postNewPetData();
    }
    @Test(priority = 3)
    public void GetPetById () {
        AllPetApiCall.getPetId();
    }
    @Test(priority = 4)
    public void GetPetByStatus (){
        AllPetApiCall.GetPetDataByStatus();
    }
}
