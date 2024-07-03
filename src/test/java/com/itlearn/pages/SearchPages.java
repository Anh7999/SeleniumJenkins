package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPages {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homeText;

    @FindBy(xpath = "//input[@id='frm_search']")
    WebElement searchInput;

    @FindBy(xpath = "//button[@id='btn_search']")
    WebElement searchBtn;

    @FindBy(xpath = "(//div[@class='product-wrapper'])[1]")
    WebElement product;

    @FindBy(xpath = "//div[@class='product-wrapper']")
    WebElement totalPoduct;

    @FindBy(xpath = "(//div[@class='product-wrapper'])[1]/a/h3")
    WebElement nameItemProduct;


    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addProduct;

    @FindBy(xpath = "//a[@class='btn menu-btn']")
    WebElement productCart;

    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    WebElement checkOut;

    @FindBy(xpath = "//p[@class='text-center']/a")
    WebElement btnAddCart;

    public void searchProduct(String nameProduct) {
        homeText.click();
        searchInput.sendKeys(nameProduct);
        searchBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(product));
        product.click();
        wait.until(ExpectedConditions.elementToBeClickable(addProduct));
        addProduct.click();
//        wait.until(ExpectedConditions.elementToBeClickable(pr));
        productCart.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkOut));
        checkOut.click();
    }

    public void goToHomePage() {
        homeText.click();
    }

    public void enterProductName(String nameProduct) {
        searchInput.sendKeys(nameProduct);
    }

    public void clickSearcBtn() {
        searchBtn.click();
    }

    public String getNameProductItem() {
        String nameProduct = nameItemProduct
                .getText();
        return nameProduct;
    }

    public String getNameBtnAddcart() {
        return btnAddCart.getText();
    }
}
