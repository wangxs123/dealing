package com.demo.main;

import com.demo.bean.UserBean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： wangxs
 * @date：Create by 2018/7/31 9:16
 */
public class ReadFile {
    private int totalRows = 0;
    private int totalCells = 0;
    public static void main(String[] args) throws Exception {
        String path = "F:\\download\\CallTemp (2).xlsx";
        ReadFile file = new ReadFile();
        file.getFile(path);

    }
    public List<UserBean> getFile(String path) throws Exception {
        Workbook wb;
        InputStream is = new FileInputStream(path);
        List<UserBean> list = new ArrayList<>();
        //判断是哪个版本的Excel
//        boolean is2007 = path.matches("^.+\\.(?i)(xlsx)$");
//        boolean is2003 = path.matches("^.+\\.(?i)(xls)$");
        // 当excel是2003时
        //wb = new HSSFWorkbook(is);
        // 当excel是2007时
        wb = new XSSFWorkbook(is);

        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        for(int i=0;i<totalRows;i++){
            Row row = sheet.getRow(i);
            if(row == null){
                continue;
            }
            String number =null;
            for(int j=0;j<totalCells;j++){
                Cell cell = row.getCell(j);
                if(cell != null){
                    if(cell.getCellType() == 0){
                        BigDecimal bigDecimal = new BigDecimal(cell.getNumericCellValue());
                        number = String.valueOf(bigDecimal.toString());
                    }else{
                        number +=cell.getStringCellValue();
                    }
                }
            }
            System.out.println(number);
        }
        return list;

    }
}
