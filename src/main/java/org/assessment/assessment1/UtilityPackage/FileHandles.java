package org.assessment.assessment1.UtilityPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
}
