package com.base;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.module.Script;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Base_Class {

    public static WebDriver driver;

    protected static WebDriver launchBroswer(String broswerName) {
        try {
            if (broswerName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (broswerName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (broswerName.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE BROWSER LAUNCH");
        }
        driver.manage().window().maximize();
        return driver;
    }
    protected static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE URL LAUNCH");
        }
    }
    public static void elementClick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE ELEMENT CLICK");
        }
    }
    protected static void passInput(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE VALUE PASSING");
        }
    }
    protected static void windowsHandling(int num) {
        try {
            List<String> allwindows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(allwindows.get(num));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE WINDOW HANDLING");
        }
    }
    protected static void deselectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE VALUE SELECTION");
        }
    }
    protected static void browserClose() {
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE BROWSER CLOSE");
        }
    }
    protected static void browserTerminate() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE BROWSER TERMINATE");
        }
    }
    protected static void navigation(String type, String url) {
        try {
            if (type.equalsIgnoreCase("to")) {
                driver.navigate().to(url);
            } else if (type.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if (type.equalsIgnoreCase("forward")) {
                driver.navigate().forward();
            } else if (type.equalsIgnoreCase("refresh")) {
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE NAVIGATION");
        }
    }
    protected static void alert(String type, String value) {
        Alert alert = driver.switchTo().alert();
        try {
            if (type.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (type.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            } else if (type.equalsIgnoreCase("gettext")) {
                alert.getText();
            } else if (type.equalsIgnoreCase("sendkeys")) {
                alert.sendKeys(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE ALERT HANDLING");
        }
    }
    protected static void action(WebElement element, String type){
        Actions action = new Actions(driver);
        try{
            if (type.equalsIgnoreCase("click")) {
                action.click(element).perform();
            } else if (type.equalsIgnoreCase("doubleclick")) {
                action.doubleClick(element).perform();
            } else if (type.equalsIgnoreCase("release")) {
                action.release(element).perform();
            } else if (type.equalsIgnoreCase("movetoelement")) {
                action.moveToElement(element).perform();
            } else if (type.equalsIgnoreCase("clickandhold")) {
                action.clickAndHold(element).perform();
            }
        }catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE ACTIONS");
        }
    }
    protected static void dropdown(WebElement element, String type, String value){
        Select select = new Select(element);
        try{
            if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("getoptions")) {
                select.getOptions();
            } else if (type.equalsIgnoreCase("firstselected")) {
                select.getFirstSelectedOption();
            } else if (type.equalsIgnoreCase("allselected")) {
                select.getAllSelectedOptions();
            } else if (type.equalsIgnoreCase("ismultiple")) {
                select.isMultiple();
            } else if (type.equalsIgnoreCase("deselectall")) {
                select.deselectAll();
            } else if (type.equalsIgnoreCase("deselectvalue")) {
                select.deselectByValue(value);
            } else if (type.equalsIgnoreCase("deselectindex")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("deselecttext")) {
                select.deselectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE DROPDOWN");
        }
    }
    protected static void checkBox(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE CHECKBOX CLICK");
        }
    }
    protected static void radioButton(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE RADIO BUTTON CLICK");
        }
    }
    protected static void webelementIsenabled(WebElement element){
        try{
            System.out.println(element.isEnabled());
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE IS ENABLED");
        }
    }
    protected static void webelementisDisplayed(WebElement element) {
        try {
            System.out.println(element.isDisplayed());
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURRED DURING THE IS DISPLAYED");
        }
    }
    protected static void webelementIsSelected(WebElement element) {
        try {
            System.out.println(element.isSelected());
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE IS SELECTED");
        }
    }
    protected static void getText(WebElement element) {
        try {
            String text = element.getText();
            System.out.println(text);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE GETTING TEXT");
        }
    }
    protected static void getTitle() {
        try {
            driver.getTitle();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE GET TITLE");
        }
    }
    protected static void getCurrentUrl() {
        try {
            driver.getCurrentUrl();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE GET CURRENT URL");
        }
    }
    protected static void wait(String type, WebElement element, int num){
        try {
            if (type.equalsIgnoreCase("implicit")) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE IMPLICIT WAIT");
        }
    }
    protected static void takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        try{
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File("C:\\Users\\shalinipandurangan\\IdeaProjects\\Maven_Project\\src\\test\\Screenshot\\image.png");
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            Assert.fail("ERROR : OCCUR DURING THE SCREENSHOT");
        }
    }
    protected static void scroll(String type){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
            if (type.equalsIgnoreCase("down")) {
                js.executeScript("window.scrollBy(0, 1000);");
            } else if (type.equalsIgnoreCase("up")) {
                js.executeScript("window.scrollBy(0, -3000);");
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE SCROLL");
        }
    }
}
