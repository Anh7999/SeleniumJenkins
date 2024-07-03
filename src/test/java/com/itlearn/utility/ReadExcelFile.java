package com.itlearn.utility;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellValue(String fileName, String sheetName, int row, int colNum) {
        try {
            File f = new File(fileName);
            fis = new FileInputStream(f);
            workbook = new XSSFWorkbook(fis);

            excelSheet = workbook.getSheet(sheetName);
            cell = excelSheet.getRow(row).getCell(colNum);

            workbook.close();
            if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                return String.valueOf((int) cell.getNumericCellValue());
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                return String.valueOf((boolean) cell.getBooleanCellValue());
            } else {
                System.out.println("Don't support this type");
                return cell.getStringCellValue();
            }

//            return cell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }


    public static int getRowCount(String fileName, String sheetName) {
        try {
            File f = new File(fileName);
            fis = new FileInputStream(f);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheet(sheetName);
            int row = excelSheet.getLastRowNum() + 1;
            workbook.close();
            return row;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static int getColCount(String fileName, String sheetName) {
        try {
            File f = new File(fileName);
            fis = new FileInputStream(f);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheet(sheetName);
            int col = excelSheet.getRow(0).getLastCellNum();
            workbook.close();
            return col;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public String getStringData(int sheetIndex, int row, int col) {
        return workbook.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
    }

    public String getStringData(String sheetName, int row, int col) {
        return workbook.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public double getNumaritData(String sheetName, int row, int col) {
        return workbook.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }
}
