package org.testngfeature;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyFeature {
    @Test(priority=1)
    public void testCase1(){
        System.out.println("first priority should given");
        Assert.fail();
    }
    @Test(priority = 2,dependsOnMethods = {"testCase1"})
    public void testCase2(){
        System.out.println("second priority should given");
    }
    @Test(priority = 3,dependsOnMethods = {"testCase1","testCase2"})
    public void testCase3(){
        System.out.println("third priority should given");
    }
//    always run is use for forcefully run the test case,even dependency method will fail
    @Test(priority = 4,dependsOnMethods = {"testCase1"},alwaysRun = true)
    public void testCase4(){
        System.out.println("forth priority should given");
    }
}
