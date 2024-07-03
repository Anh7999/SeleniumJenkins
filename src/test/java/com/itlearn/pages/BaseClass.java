package com.itlearn.pages;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.CaptureScreenShots;
import com.itlearn.utility.ConfigDataProperties;
import com.itlearn.utility.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public ConfigDataProperties config = new ConfigDataProperties();
    public LoginPage loginPage;
    public SearchPages searchPages;


    String nameFile = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";
    public ReadExcelFile readExcelFile = new ReadExcelFile();

    protected String userName = ReadExcelFile.getCellValue(nameFile, "Login", 1, 0);
    protected String passWord = ReadExcelFile.getCellValue(nameFile, "Login", 1, 1);

    @BeforeClass
    public void setUp() {

        driver = BrowserFactory.startApplication(driver, config.getBrowserName(), config.getURL());

        loginPage = new LoginPage(driver);
        searchPages = new SearchPages(driver);
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitApplication(driver);
    }
    public void captureScreenShot(WebDriver driver,String testName) throws IOException
    {
        // Convert webdriver object to TakesScreenshot interface
        TakesScreenshot screenshot= ((TakesScreenshot)driver);

        // Step 2 :call getScreenshotAs method to capture image file

        File src= screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath=new File("."+"//Screenshots//"+ testName + ".png");

        // Step 3 : copy image file to destination
        FileUtils.copyFile(src, srcpath);

    }

//    public void captureScreenShot(WebDriver driver, String testName) {
//        try {
//            // Convert webdriver object to TakesScreenshot interface
//            TakesScreenshot screenshot = ((TakesScreenshot) driver);
//
//            // Step 2 :call getScreenshotAs method to capture image file
//
//            File src = screenshot.getScreenshotAs(OutputType.FILE);
//            File srcpath = new File("./ScreenShots/" + testName + ".png");
//
//            // Step 3 : copy image file to destination
//            FileUtils.copyFile(src, srcpath);
//        } catch (Exception e) {
//            System.out.println("Error take screen shot");
//            e.printStackTrace();
//        }
//
//
//    }
//    public void takeScreenshot2(WebDriver driver){
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileHandler.copy(screenshotFile, new File("./ScreenShots/" + "testName" + ".png"));
//            System.out.println("Screenshot captured for failed assertion");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    static String filename = "";
//
//    public static void takeScreenshot(WebDriver driver, String imageName) {
//        try {
//            File theDir = new File("./Screenshots");
//            if (!theDir.exists()) {
//                theDir.mkdirs();
//            }
////			BufferedImage image = new Robot()
////					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//            filename = "./ScreenShots/" + imageName + ".png";
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            File f = screenshot.getScreenshotAs(OutputType.FILE);
//
//            File fd = new File(filename);
//            FileUtils.copyFile(f, fd);
//        } catch (Exception e) {
//            System.out.println("Da xay ra loi chup man hinh");
//            e.printStackTrace();
//        }
////        attachScreebshotToReport();
//    }
//
//    public static void attachScreebshotToReport() {
//        try {
//            System.setProperty("org.uncommons.reportng.escape-output", "false");
//            File file = new File(filename);
//            Reporter.log("<br><a title=\"Screenshot\" href=\"" + file.getAbsolutePath() + "\">" + "<img alt='"
//                    + file.getName() + "'src='" + file + "'height='243' width='418'</a><br>");
//        } catch (Exception e) {
//            System.out.println("Da xay ra loi att man hinh");
//            e.printStackTrace();
//            // TODO: handle exception
//        }
//
//    }
}
