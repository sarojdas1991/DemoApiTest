package org.testngfeature;

import org.testng.annotations.Test;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "loginData")
    public Object[][] loginData(){
        Object[][] data={{"abc@gail.com","abc"},{"def@gail.com","def"},{"ghi@gail.com","ghi"}};
                return data;
    }
    @Test(dataProvider = "loginData")
    public void login(String mail,String pw){
        System.out.println("Mail = "+ mail    +   "     Pw = "+pw);

    }
}
