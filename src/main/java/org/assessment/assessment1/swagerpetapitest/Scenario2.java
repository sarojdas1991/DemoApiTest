package org.assessment.assessment1.swagerpetapitest;

import org.testng.annotations.Test;

import org.assessment.assessment1.allPetApiTestMethods.AllPetApiCall;

public class Scenario2 {
    AllPetApiCall allPetApiCall=new AllPetApiCall();

    @Test(priority = 1)
    public void PostPetData() {
        allPetApiCall.postNewPetData();
   }
    @Test(priority = 2)
    public void GetPetById () {
        allPetApiCall.getPetId();
   }
    @Test(priority = 3)
    public void GetPetByStatus (){
        allPetApiCall.GetPetDataByStatus();
    }
    @Test(priority = 4)
    public void DeletePet (){
        allPetApiCall.DeletePetDetails();

    }




}
