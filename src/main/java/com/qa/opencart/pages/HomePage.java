package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    //1. String locators
    private String searchArea = "input[name='search']";
    private String searchButton = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String myAccountLink="a[title='My Account']";
    private String loginLink = "a:text('Login')";

    //2. page constructor:
    public HomePage(Page page) {
        this.page = page;
    }
    //3. page actions/ methods:

    public String getHomepageTitle() {
        String title = page.title();
        System.out.println("page title : " + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("page url: " + url);
        return url;
    }

    public String doSearch(String productName) {
        page.fill(searchArea, productName);
        page.click(searchButton);
        String header = page.textContent(searchPageHeader);
        System.out.println("Search Header: " + header);
        return header;
    }
public LoginPage navigateToLoginPage(){
        page.click(myAccountLink);
        page.click(loginLink);
    return new LoginPage(page);
}
}
