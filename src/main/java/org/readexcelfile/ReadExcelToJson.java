package org.readexcelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelToJson {
    @Test
    public void convertExceltoJsonData() {
        JSONObject jsonObject = null;
        try {
            FileInputStream file = new FileInputStream(new File("d:/petData.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter=new DataFormatter();
            jsonObject = new JSONObject();
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String columnName = dataFormatter.formatCellValue(sheet.getRow(0).getCell(cell.getColumnIndex()));
//                    String columnValue = cell.getStringCellValue();
                    String columnValue=dataFormatter.formatCellValue(cell);

                    jsonObject.put(columnName, columnValue);
                }
                System.out.println(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
