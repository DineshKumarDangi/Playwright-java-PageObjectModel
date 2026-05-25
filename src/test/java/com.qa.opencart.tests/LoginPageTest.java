package com.qa.opencart.tests;

import base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginPage();
        String actualLoginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("actualLoginPageTitle: " + actualLoginPageTitle);
        Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgottenPasswordVisible());
    }

    @Test(priority = 3)
    public void appLoginTest() {
        System.out.println("ID: "+prop.getProperty("username").trim() +"\n PWD: "+
                prop.getProperty("password").trim());

        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(),
                prop.getProperty("password").trim()));
    }
}
