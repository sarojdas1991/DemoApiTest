package org.basicutility.utils;

import  org.json.JSONTokener;
import java.io.*;
import java.util.Properties;

public class Utility {
    public static Properties readPropertiesFile() throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("C:\\Users\\saroj.das\\IdeaProjects\\DemoApiTest\\src\\main\\resources\\ApiData.properties");
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
    public void readJsonFile(){
        File file=new File(".\\data.json");
        try {
            FileReader fileReader=new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        JsonTokener jsonToken=new JsonTokener(fileReader);
    }
}
