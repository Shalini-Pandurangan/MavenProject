package com.runner;

import com.utility.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenRunner {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        String username = ReadExcelData.getParticulaData(4,0);
        driver.findElement(By.name("email")).sendKeys(username);
        String password = ReadExcelData.getParticulaData(4,1);
        driver.findElement(By.name("pass")).sendKeys(password);
    }
}
