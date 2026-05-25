package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import javax.swing.*;
import java.security.PrivateKey;

public class LoginPage {
    private Page page;

    // 1. String Locators
    private String emailId = "input#input-email";
    private String password = "input#input-password";
    // private String loginButton = "input.btn";
    private Locator loginButton;
    private Locator logoutLink; //= "//a[@class='list-group-item'][normalize-space()='Logout']";

    // Locator for "Forgotten Password" link
    private Locator forgottenPasswordLinkName;// = "Forgotten Password";

    //2. page constructor
    public LoginPage(Page page) {
        this.page = page;
        this.loginButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login"));
        this.logoutLink = page.locator("#column-right").getByRole(AriaRole.LINK,
                new Locator.GetByRoleOptions().setName("Logout"));

        this.forgottenPasswordLinkName = page.locator("#content").getByRole(AriaRole.LINK,
                new Locator.GetByRoleOptions().setName("Forgotten Password"));

    }

    //3 page actions / methods:
    public String getLoginPageTitle() {
        return page.title();
    }

    // Action method to click the link
    public void clickForgottenPassword() {
        forgottenPasswordLinkName.click();
    }

    // Optional: method to check if link is visible
    public boolean isForgottenPasswordVisible() {
        return forgottenPasswordLinkName.isVisible();
    }

    public boolean doLogin(String appUserName, String appPassword) {
        page.fill(emailId, appUserName);
        page.fill(password, appPassword);
        loginButton.click();
        page.waitForTimeout(2000);
        if (logoutLink.isVisible()) {
            System.out.println("User successfully logged in");
            return true;
        }
        return false;
    }
}
