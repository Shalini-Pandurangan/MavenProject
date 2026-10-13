package com.pageobjectmodel;

import com.Interfaceelements.LoginInterfaceElements;
import com.Interfaceelements.SearchPageInterfaceElement;
import com.base.Base_Class;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.base.Base_Class.driver;
import static com.base.Base_Class.elementClick;

public class SearchPage extends Base_Class implements SearchPageInterfaceElement {
    @FindBy(xpath = category_xpath)
    private static WebElement category;
    @FindBy(xpath = laptop_xpath)
    private static WebElement laptop;
    @FindBy(xpath = cart_xpath)
    private static WebElement cart;

    public SearchPage()
    {
        PageFactory.initElements(driver,this);
    }

    public static void Search()throws InterruptedException{
        elementClick(category);
        elementClick(laptop);
        Thread.sleep(3000);
        elementClick(cart);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
