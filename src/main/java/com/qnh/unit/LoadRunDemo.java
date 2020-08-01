package com.qnh.unit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadRunDemo {

    public static void main(String[] args) throws IOException {
        List<List<Object>> read = read();
        System.out.println(read);
    }

    public static List<List<Object>> read() throws IOException {

        List<List<Object>> row = null;
        try {

            //XSSFWorkbook workbook = new XSSFWorkbook("D:\\demo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook("/techfuser/runtest/demo.xlsx");

            XSSFSheet sheet = workbook.getSheetAt(0);

            int lastRowNum = sheet.getLastRowNum();

            row = new ArrayList<>();

            for (int i = 1; i < lastRowNum; i++) {
                int lastCellNum = sheet.getRow(i).getLastCellNum();
                List<Object> cell = new ArrayList<>();
                for (int c = 0; c <lastCellNum ; c++) {
                    //System.out.println(sheet.getRow(i).getCell(c)+" ");
                    cell.add(sheet.getRow(i).getCell(c));
                }
                row.add(cell);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return row;
    }
}
