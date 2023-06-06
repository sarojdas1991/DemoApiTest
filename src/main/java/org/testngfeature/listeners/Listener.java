package org.testngfeature.listeners;

import org.testng.ITestListener;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {
    public void onTestStarts(ITestListener tr){
        System.out.println("test started");
    }
    public void onTestSuccess(ITestListener tr){
        System.out.println("test passed");
    }
    public void onTestFailure(ITestListener tr){
        System.out.println("test Failed");
    }
    public void onTestSkipped(ITestListener tr){
        System.out.println("test Skipped");
    }
}
