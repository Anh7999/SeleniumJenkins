package com.itlearn.testcases;

import com.itlearn.pages.BaseClass;
import com.itlearn.pages.SearchPages;
import com.itlearn.utility.CaptureScreenShots;
import com.itlearn.utility.DataProviderExcel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.itlearn.utility.CaptureScreenShots.takeScreenshot;

public class SearchTest extends BaseClass {
    @Test(groups = {"loginSuccess"})
    public void trueAccountLogin() {
        loginPage.portalLogin(userName, passWord);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderExcel.class, dependsOnMethods = {"trueAccountLogin"})
    public void verifySearch(String nameProduct) {
        System.out.println(nameProduct);
        searchPages.searchProduct(nameProduct);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderExcel.class, dependsOnMethods = {"trueAccountLogin"})
    public void verifyText(String nameProduct) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        try {
            searchPages.goToHomePage();
            searchPages.enterProductName(nameProduct);
            searchPages.clickSearcBtn();
            String nameItemProduct = searchPages.getNameProductItem();

            Assert.assertEquals(nameItemProduct, nameProduct);

            String btnAddCart = searchPages.getNameBtnAddcart();
            System.out.println(btnAddCart);

            Assert.assertEquals("addd", btnAddCart);


        } catch (AssertionError e) {
//            takeScreenshot(driver, "Wrong text " + nameProduct);
            captureScreenShot(driver,"verifyText");
//            softAssert.fail();
            throw e;
        }
//        softAssert.assertAll();


    }

    @Test
    public void demo() {
        System.out.println(System.getProperty("user.dir") + "\\ScreenShots");
    }

//    @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderExcel.class, dependsOnMethods = "")
//    public void SearchProduct(String nameProduct) {
////        System.out.println(nameProduct);
//        loginPage.portalLogin(userName, passWord);
////        SearchPages searchPages= new SearchPages(driver);
//        searchPages.searchProduct(nameProduct);
//    }


}
