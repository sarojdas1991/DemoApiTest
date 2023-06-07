package org.assessment.assessment2.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
public class ConvertExcelToJson {
    public JSONObject convertExceltoJsonData() {
        JSONObject jsonObject = null;
        try {
            FileInputStream file = new FileInputStream(new File("src/main/java/org/assessment/assessment2/testdata/testdata.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
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
                    String columnName = sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue();
                    String columnValue = cell.getStringCellValue();

                    jsonObject.put(columnName, columnValue);
                }
                System.out.println(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
