package com.pageobjectmodel;

import com.Interfaceelements.CheckoutInterfaceElements;
import com.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Base_Class implements CheckoutInterfaceElements {

    @FindBy (xpath = checkout_id)
    private static WebElement checkout;
    @FindBy (xpath = placeorder_xpath)
    private static WebElement placeorder;

    public CheckoutPage() {
        PageFactory.initElements(driver,this);
    }

    public static void Checkout(){
        elementClick(checkout);
        elementClick(placeorder);
    }

}
