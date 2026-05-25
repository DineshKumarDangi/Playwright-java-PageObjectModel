package com.qa.opencart.tests;

import base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {


    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getHomepageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageURLTest() {
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL, prop.getProperty("url").trim());
    }

    @DataProvider(name="myProductData")
    public Object[][] getProductData(){
        return new Object[][]{
                {"Mackbook"},
                {"iMac"},
                {"Samsung"},
        };
    }

    @Test(dataProvider = "myProductData")
    public void searchTest(String productName) {
        String actualSearchHeader = homePage.doSearch(productName);
        page.waitForTimeout(2000);
        Assert.assertEquals(actualSearchHeader, "Search - "+productName);
    }
}