package com.test.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

/**
 * Created by chenguangwei on 2021/5/19.
 */
public class FirstWebAuto {
    public static void main(String[] args) {
        //元素定位原则，定位表达式定位对应唯一元素
        //如果元素定位表达式有多个，findelemnt方法默认找第一个元素
        //坑，定位元素为代码打开的权限浏览器里面找元素属性
//        openBrowser("chrome");
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com/");

        //1  id定位
//        WebElement webElement = driver.findElement(By.id("kw"));
//        webElement.sendKeys("测试");

        //2  name定位
        //driver.findElement(By.name("wd")).sendKeys("测试");

        //3  tagname定位（几乎不用）
        //driver.findElement(By.tagName("input")).sendKeys("测试");
//        List<WebElement> list = driver.findElements(By.tagName("input"));
//        System.out.println(list.size());

        //4  classname定位
        //driver.findElement(By.className("s_ipt")).sendKeys("测试");
        //driver.findElement(By.className("btn self-btn bg s_btn")).click();

        //5  linktext定位
        //driver.findElement(By.linkText("直播")).click();

        //6  partialLinkText定位
        //driver.findElement(By.partialLinkText("播")).click();


        //CSS定位器
        //1  标签名
//        List<WebElement> list = driver.findElements(By.cssSelector("input"));
//        System.out.println(list.size());
        //2  id
        //driver.findElement(By.cssSelector("#id")).sendKeys("测试");
        //3  class属性 By.className
        //driver.findElement(By.cssSelector(".s_ipt")).sendKeys("测试");
        //支持复合类名
        //driver.findElement(By.cssSelector(".bg.s.btn")).click();
        //driver.findElement(By.cssSelector("a[href='https://live.baidu.com/']")).click();
        //driver.findElement(By.cssSelector("a[@href='https://live.baidu.com/' and text()='直播']")).click();
    }

    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
