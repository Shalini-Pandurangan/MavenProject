package com.pageobjectmanager;

import com.utility.FileReaderManager;
import com.pageobjectmodel.AddressPage;
import com.pageobjectmodel.CheckoutPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;

public class PageObjectManager {
    private FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;
    private LoginPage loginPage;
    private SearchPage searchpage;
    private CheckoutPage checkoutPage;
    private AddressPage addressPage;

    public FileReaderManager getFileReaderManager() {
        if (fileReaderManager == null) {
            fileReaderManager = new FileReaderManager();
        }
        return fileReaderManager;
    }

    public static PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public SearchPage getSearchPage() {
        if (searchpage == null) {
            searchpage = new SearchPage();
        }
        return searchpage;
    }
    public CheckoutPage getCheckoutPage(){
        if(checkoutPage == null){
            checkoutPage = new CheckoutPage();
        }
        return checkoutPage;
    }
    public AddressPage getAddressPage(){
        if(addressPage == null){
            addressPage = new AddressPage();
        }
        return addressPage;
    }
}
