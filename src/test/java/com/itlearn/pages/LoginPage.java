package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver ldriver) {
        this.driver=ldriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(xpath = "//a[@class='btn ml-3']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passInput;

    @FindBy(xpath = "//button[@id='customerloginForm']")
    WebElement siginBtn;

    @FindBy(xpath = "//li[2]//div[1]//button[1]")
    WebElement logoutImage;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//div[@id='notify_message']")
    WebElement message;

    public void portalLogin(String userName, String password){
        loginBtn.click();
        emailInput.sendKeys(userName);
        passInput.sendKeys(password);
        siginBtn.click();
    }

    public void logOut(){
        logoutImage.click();
        logoutBtn.click();
//        Assert.assertTrue(true);
    }

    public String getMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(message));
//        boolean messDisplayed= message.isDisplayed();
        String text="";

        if(message.isDisplayed()){
            text = message.getText();
        }else {
            text="";
        }

        return text;
    }
}
