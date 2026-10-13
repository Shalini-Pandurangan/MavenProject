package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

import java.io.IOException;

public class RunnerClass extends Base_Class {
    public static void main(String[] args)throws InterruptedException, IOException {
        launchBroswer(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        PageObjectManager.getPageObjectManager().getSearchPage().Search();
        PageObjectManager.getPageObjectManager().getCheckoutPage().Checkout();
        PageObjectManager.getPageObjectManager().getAddressPage().Address();
    }
}
