package org.assessment.assessment1.Runner;

import org.testng.annotations.Test;

import org.assessment.assessment1.allPetApiTestMethods.AllPetApiCall;

public class Scenario2 {

//   @Test(priority = 2)
//    public void UploadImage() {
//        PetEndpoints.postPetImage();
//
//    }
    @Test(priority = 1)
    public void PostPetData() {
    AllPetApiCall.postNewPetData();
   }
    @Test(priority = 2)
    public void GetPetById () {
       AllPetApiCall.getPetId();
   }
    @Test(priority = 3)
    public void GetPetByStatus (){
       AllPetApiCall.GetPetDataByStatus();
    }
    @Test(priority = 4)
    public void DeletePet (){
        AllPetApiCall.DeletePetDetails();

    }




}
