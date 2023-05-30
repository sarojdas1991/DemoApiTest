package org.assessment.assessment1.Runner;

import org.assessment.assessment1.allPetApiTestMethods.AllPetApiCall;
import org.testng.annotations.Test;

public class Scenario3 {
    @Test(priority = 1)
    public void UploadImage() {
        AllPetApiCall.postPetImage();

    }
    @Test(priority = 2)
    public void UpdatePetData() {
        AllPetApiCall.updatePetData();

    }
    @Test(priority = 3)
    public void DeletePet (){
        AllPetApiCall.DeletePetDetails();

    }
}
