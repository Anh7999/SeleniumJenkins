package com.itlearn.testcases;

import com.itlearn.pages.BaseClass;
import com.itlearn.utility.CaptureScreenShots;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class Demo extends BaseClass {

    @Test
    public void demo1(){
        Assert.assertTrue(true);
    }

    @Test
    public void demo2(){
        try {
            // Giả sử bạn đang kiểm tra tiêu đề của trang web
            String expectedTitle = "Expected Title";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Tiêu đề trang không đúng!");

            // Nếu không có lỗi, code sau assertion sẽ chạy
            System.out.println("Assertion Passed");
        } catch (AssertionError e) {

            CaptureScreenShots.takeScreenshot2(driver);
            CaptureScreenShots.takeScreenshot(driver,"name");
            CaptureScreenShots.captureScreenShot1(driver,"ca");
            throw e;
        }
    }

//        softAssert.assertAll();

    @Test
    public void demo3(){
        Assert.assertTrue(true);
    }

}
