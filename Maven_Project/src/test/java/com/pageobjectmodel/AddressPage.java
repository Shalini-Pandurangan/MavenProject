package com.pageobjectmodel;

import com.Interfaceelements.AddressInterfaceElements;
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

public class AddressPage extends Base_Class implements AddressInterfaceElements {
    @FindBy(id = name_id)
    private static WebElement name;
    @FindBy(id = country_id)
    private static WebElement country;
    @FindBy(id = city_id)
    private static WebElement city;
    @FindBy(id = card_id)
    private static WebElement card;
    @FindBy(id = month_id)
    private static WebElement month;
    @FindBy(id = year_id)
    private static WebElement year;
    @FindBy(xpath = purchase_xpath)
    private static WebElement purchase;

    public AddressPage() {
        PageFactory.initElements(driver,this);
    }
    public static void Address()throws IOException {
        passInput(name, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("name"));
        passInput(country, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("country"));
        passInput(city, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("city"));
        passInput(card, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("card"));
        passInput(month, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("month"));
        passInput(year, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("year"));
        elementClick(purchase);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\shalinipandurangan\\IdeaProjects\\Maven_Project\\src\\test\\Screenshot\\image1.png");
        FileHandler.copy(source, destination);
    }

}
