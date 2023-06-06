package org.testngfeature.group;

import org.testng.annotations.Test;

public class GroupingFeature {
    @Test(groups = {"sanity"})
    public void testCase1(){
        System.out.println("----test case 1------");
    }
    @Test(groups = {"sanity"})
    public void testCase2(){
        System.out.println("----test case 2------");
    }
    @Test(groups = {"regression"})
    public void testCase3(){
        System.out.println("----test case 3------");
    }
    @Test(groups = {"regression"})
    public void testCase4(){
        System.out.println("----test case 4------");
    }
    @Test(groups = {"regression","sanity"})
    public void testCase5(){
        System.out.println("----test case 5------");
    }
}
