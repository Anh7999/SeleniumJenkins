package com.itlearn.utility;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderExcel {
    public static String nameFile = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";

    @DataProvider
    public static String[][] loginDataProvider() {

        int row = ReadExcelFile.getRowCount(nameFile, "Login");
        int col = ReadExcelFile.getColCount(nameFile, "Login");

        String[][] data = new String[row - 1][col];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(nameFile, "Login", i, j);
            }
        }
        return data;
    }

    @DataProvider
    public static String[][] searchDataProvider() {
//        String nameFile = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";
        int row = ReadExcelFile.getRowCount(nameFile, "Search");
        int col = ReadExcelFile.getColCount(nameFile, "Search");

        String[][] data = new String[row - 1][col];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(nameFile, "Search", i, j);
            }
        }
        return data;
    }


    @DataProvider
    public static String[][] dataProvider(Method method) {

        String sheetName = "";
//        if (method.getName().equalsIgnoreCase("verifyLogin") || method.getName().equalsIgnoreCase("demoNum")) {
//            sheetName = "Login";
//        } else if (method.getName().equalsIgnoreCase("verifySearch")) {
//            sheetName = "Search";
//        }
        if (method.getDeclaringClass().getSimpleName().equalsIgnoreCase("LoginTest")) {
            sheetName = "Login";
        } else if (method.getDeclaringClass().getSimpleName().equalsIgnoreCase("SearchTest")) {
            sheetName = "Search";
        }
        System.out.println(method.getDeclaringClass().getSimpleName().equalsIgnoreCase("LoginTest"));

        int row = ReadExcelFile.getRowCount(nameFile, sheetName);
        int col = ReadExcelFile.getColCount(nameFile, sheetName);

        String[][] data = new String[row - 1][col];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(nameFile, sheetName, i, j);
            }
        }
        return data;


    }
}
