package com.itlearn.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String nameBrowser, String url) {
        if (nameBrowser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (nameBrowser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (nameBrowser.equalsIgnoreCase("Ide")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Don't supports this browser....");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static void quitApplication(WebDriver driver){
        driver.quit();
    }
}
