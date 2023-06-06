package org.testngfeature;

import org.testng.annotations.Test;

public class PriorityAndEnableTestcases {
    @Test(priority=1,enabled = true)
    public void testCase1(){
        System.out.println("first priority should given");
    }
    @Test(priority = 2,enabled = false)
    public void testCase2(){
        System.out.println("second priority should given");
    }
    @Test(priority = 3,enabled = true)
    public void testCase3(){
        System.out.println("third priority should given");
    }
}
