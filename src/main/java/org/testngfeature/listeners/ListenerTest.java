package org.testngfeature.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerTest {
    @Test
    public  void TestCase1(){
        System.out.println("Test case 1");
        Assert.assertEquals("a","a");
    }
    @Test
    public  void TestCase2(){
        System.out.println("Test case 2");
        Assert.assertEquals("a","a");
    }
}
