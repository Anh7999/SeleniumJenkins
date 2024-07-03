package com.itlearn.testcases;

import com.itlearn.pages.BaseClass;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.DataProviderExcel;
import com.itlearn.utility.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest extends BaseClass {

    String nameFile = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";

//    @Test(groups = {"loginSuccess"},priority = 2)
//    public void trueAccountLogin(){
//        loginPage.portalLogin(userName,passWord);
//    }

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviderExcel.class)
    public void verifyLogin(String name, String pass, String status) {
//        LoginPage loginPage = new LoginPage(driver);
        loginPage.portalLogin(name, pass);
        String mess = "";
        if (status.equalsIgnoreCase("right")) {
            mess = "";
        } else {
            mess = loginPage.getMessage();
        }

        if (status.equalsIgnoreCase("right")) {
            loginPage.logOut();
            System.out.println("mess1: " + mess);
        } else if (status.equalsIgnoreCase("wrong pass")) {

            System.out.println("mess wrong pass: " + mess);
            String actualMessWrongPass = "Access denied. Check password and try again.";
            Assert.assertEquals(actualMessWrongPass, mess);
        } else if (status.equalsIgnoreCase("wrong email")) {
            System.out.println("mess wrong pass: " + mess);
            String actualMessWrongEmail = "A customer with that email does not exist.";
            Assert.assertEquals(actualMessWrongEmail, mess);
        }


        System.out.println(name + " " + pass + " " + status);

    }



//    @Test(dataProvider = "dataProvider",dataProviderClass = DataProviderExcel.class)
//    public void demoNum(String name, String pass, String status){
//        System.out.println(name+" "+pass+" "+status);
//
//    }


    public void demo() {
        int row = ReadExcelFile.getRowCount(nameFile, "Login");
        int col = ReadExcelFile.getColCount(nameFile, "Login");

        String[][] data = new String[row - 1][col];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(nameFile, "Login", i, j);
            }
            System.out.println("data "+data.toString());
        }

    }
}
