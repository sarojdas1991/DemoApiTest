package org.testngfeature.parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterFeature {
    @Test()
    @Parameters({"a","b"})
    public void testCase1(int a,int b){

        int c =(a+b);
        System.out.println("Value of c = "+c);
    }
}
