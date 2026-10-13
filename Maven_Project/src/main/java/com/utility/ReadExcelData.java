package com.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {
//    public static String getParticulaData(int rowvalue,int columnValue){
//        String data = null;
//        try{
//            File file = new File("C:\\Users\\shalinipandurangan\\Downloads\\DataDriven_IPT.xlsx");
//            Workbook book = new XSSFWorkbook(file);
//            Sheet sheet = book.getSheet("Sheet1");
//            Row row = sheet.getRow(rowvalue);
//            Cell cell = row.getCell(columnValue);
//            //DataFormatter --> convert the cell into string value
//            DataFormatter dataFormat = new DataFormatter();
//            data = dataFormat.formatCellValue(cell);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
public static void getAllData(){
        try{
            File file = new File("C:\\Users\\shalinipandurangan\\Downloads\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");

            int lastRowCount = sheet.getLastRowNum();
            System.out.println("No of rows: "+lastRowCount);

            short lastCellCount = sheet.getRow(0).getLastCellNum();
            System.out.println("No of count: "+lastCellCount);

            for(int row=1;row<=lastRowCount;row++){
                Row rows = sheet.getRow(row);
                for(int column=0;column<=lastCellCount;column++){
                    Cell cell = rows.getCell(column);
                    //DataFormatter --> convert the cell into string value
                    DataFormatter dataFormat = new DataFormatter();
                    String data = dataFormat.formatCellValue(cell);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        getAllData();
    }
}
