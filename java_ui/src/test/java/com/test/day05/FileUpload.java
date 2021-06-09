package com.test.day05;

import org.omg.SendingContext.RunTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by chenguangwei on 2021/5/23.
 */
public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser("chrome");
        //1.input  标签文件上传类型
        webDriver.get("");
        Thread.sleep(2000);
        webDriver.findElement(By.id("")).sendKeys("");

        //非input标签的上传文件
        webDriver.get("");
        webDriver.findElement(By.id("")).click();
        //执行本地exe文件，（autoit脚本转换之后的程序）
        Runtime runtime = Runtime.getRuntime();
        //try/catch

        //验证码，去除验证码，万能验证码，自动识别


    }

    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
