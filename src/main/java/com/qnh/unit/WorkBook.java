package com.qnh.unit;

import com.qnh.service.OutoserverImpl;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkBook {

    public static void main(String[] args) {

        List<Map<String, Object>> listMaps = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("1", "a");
        map1.put("2", "b");
        map1.put("3", "c");
        listMaps.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("11", "aa");
        map2.put("22", "bb");
        map2.put("33", "cc");
        listMaps.add(map2);

        for(Map<String ,Object> maps :listMaps){
            //System.out.println(maps);
            for (Object k:maps.keySet()){

                System.out.println(maps.get(k));
            }
        }

    }

    public static void WriteExcel(List<Map<String,Object>> mapArrayList, HttpServletResponse response){

        // 定义一个新的工作簿
        XSSFWorkbook wb = new XSSFWorkbook();
        // 创建一个Sheet页
        XSSFSheet sheet = wb.createSheet("执行失败的定时任务");
        //设置行高
        sheet.setDefaultRowHeight((short) (2 * 256));
        //设置列宽
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 8000);
        XSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 16);
        //获得表格第一行
        XSSFRow row = sheet.createRow(0);
        //根据需要给第一行每一列设置标题
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("任务ID");
        cell = row.createCell(1);
        cell.setCellValue("执行失败次数");
        cell = row.createCell(2);
        cell.setCellValue("执行总次数");
        cell = row.createCell(3);
        cell.setCellValue("任务描述");
        XSSFRow rows;
        XSSFCell cells;
        //循环拿到的数据给所有行每一列设置对应的值
        for (int i = 0; i < mapArrayList.size(); i++) {

            // 在这个sheet页里创建一行
            rows = sheet.createRow(i + 1);
            // 该行创建一个单元格,在该单元格里设置值
            String task =  mapArrayList.get(i).get("任务ID").toString();
            String errornum = mapArrayList.get(i).get("执行失败次数").toString();
            String sumdata =  mapArrayList.get(i).get("执行总次数").toString();
            String describe;
            if (mapArrayList.get(i).containsKey("任务描述")){
                describe = mapArrayList.get(i).get("任务描述").toString();
            }else {
                describe = " ";
            }

            cells = rows.createCell(0);
            cells.setCellValue(task);
            cells = rows.createCell(1);
            cells.setCellValue(errornum);
            cells = rows.createCell(2);
            cells.setCellValue(sumdata);
            cells = rows.createCell(3);
            cells.setCellValue(describe);
        }
        try {
            response.setHeader("Content-Disposition", "attachment;Filename=" + System.currentTimeMillis() + ".xlsx");
            OutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
