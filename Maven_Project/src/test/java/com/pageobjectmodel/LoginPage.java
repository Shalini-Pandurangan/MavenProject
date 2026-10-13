package com.pageobjectmodel;

import com.Interfaceelements.LoginInterfaceElements;
import com.base.Base_Class;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pageobjectmanager.PageObjectManager;

import java.io.File;
import java.io.IOException;


public class LoginPage extends Base_Class implements LoginInterfaceElements {
    @FindBy(xpath = login_xpath)
    private static WebElement login;

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy(id = password_id)
    private static WebElement password;

    @FindBy(xpath = signin_xpath)
    private static WebElement signin;

    @FindBy(id = title_id)
    private static WebElement title;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public static void validLogin()throws InterruptedException, IOException {
        elementClick(LoginPage.login);
        Thread.sleep(3000);
        passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("username"));
        passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("password"));
        elementClick(signin);
        Thread.sleep(5000);
        getText(title);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\shalinipandurangan\\IdeaProjects\\Maven_Project\\src\\test\\Screenshot\\image.png");
        FileHandler.copy(source, destination);
    }
}
