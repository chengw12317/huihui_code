package com.test.day02.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class WorkTest {
    public static void main(String[] args) {
        WebDriver webDriver = openBrowser("chrome");
        //webDriver.get("http://testingpai.com/");
        webDriver.get("http://8.129.91.152:8765/Index/index.html");

        //第一题
//        webDriver.findElement(By.linkText("【成都】招聘软件测试工程师")).click();
//        webDriver.findElement(By.xpath("//*[@id=\"navLogin\"]")).click();
//        webDriver.findElement(By.xpath("//span[text()='登录']")).click();
//        webDriver.findElement(By.xpath("//span[contains(text(),'录')]")).click();

        //webDriver.findElement(By.cssSelector("#navLogin")).click();
        //webDriver.findElement(By.cssSelector(".nav.item.fn.left.commonGoLogin")).click(); //有问题

        //webDriver.findElement(By.xpath("//span[text()='车服务']")).click();

        //第三题
        //webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[3]/div[1]/div[3]/div/a")).click();
        //webDriver.findElement(By.xpath("//span[text()=' 测试1621602350181']/parent::div/parent::a/following-sibling::div[1]/div[3]/div[1]/a")).click();
        //webDriver.findElement(By.xpath("//span[text()=' 测试1621602350181']/parent::div/parent::a/following-sibling::div[1]//a")).click();
    }
    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
