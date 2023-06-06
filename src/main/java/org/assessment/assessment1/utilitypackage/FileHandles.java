package org.assessment.assessment1.utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FileHandles {
    /*
    The bellow methods use for read the json file
    */
    public static String readJson(String file){
        String fs = File.separator;
        String myPath = "src" + fs + "main"+ fs +"resources"+ fs ;
        byte[] input;
        String requestPayload = null;
        try {
            input = Files.readAllBytes(Paths.get(myPath+file));
            requestPayload = new String(input);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return requestPayload;
    }
    public static Properties readPropertiesFile() throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("C:\\Users\\saroj.das\\IdeaProjects\\DemoApiTest\\src\\main\\java\\org\\assessment\\assessment1\\testdata\\Pet.properties");
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
}
