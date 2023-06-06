package org.assessment.assessment2.utility;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelFile {
    public static void main(String[] args) {


        InputStream ExcelFileToRead;

        {
            try {
                ExcelFileToRead = new FileInputStream("d:/saroj.xlsx");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        XSSFWorkbook wb;

        {
            try {
                wb = new XSSFWorkbook(ExcelFileToRead);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        List<String> rowDataList = new ArrayList<String>();
        JSONObject object=new JSONObject();

        Iterator rows = sheet.rowIterator();

        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();

                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    String data=cell.getStringCellValue();
                    rowDataList.add(data);
                    System.out.print(cell.getStringCellValue() + " ");

                } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                    double numberValue = cell.getNumericCellValue();
                    String stringCellValue = BigDecimal.valueOf(numberValue).toPlainString();
                    rowDataList.add(stringCellValue);
                    System.out.print(cell.getNumericCellValue() + " ");
                } else {
                    //U Can Handel Boolean, Formula, Errors
                }

            }
           System.out.println();
        }
        System.out.println(rowDataList);
        Gson gson = new Gson();
        // convert your list to json
        String jsonCartList = gson.toJson(rowDataList);
        // print your generated json
        System.out.println("jsonCartList: " + jsonCartList);

        Response response = RestAssured.given().baseUri("http://restapi.adequateshop.com/api/authaccount")
                .contentType("application/json").body(jsonCartList).when().post("/registration").then()
                .log().all().extract().response();


    }
}
