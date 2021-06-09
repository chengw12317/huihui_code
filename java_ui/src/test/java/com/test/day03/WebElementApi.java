package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class WebElementApi {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser("chrome");
        webDriver.get("https://www.baidu.com/");
        //webDriver.findElement(By.id("kw")).sendKeys("灰灰测试");
        Thread.sleep(2000);
        //清除输入框内容
        //webDriver.findElement(By.id("kw")).clear();
        //全选    windows control  mac command
        //webDriver.findElement(By.id("kw")).sendKeys(Keys.COMMAND,"a");
        //复制
        //webDriver.findElement(By.id("kw")).sendKeys(Keys.COMMAND,"c");
        //粘贴
        //Thread.sleep(2000);
        //webDriver.findElement(By.id("kw")).sendKeys(Keys.COMMAND,"v");
        //webDriver.findElement(By.id("kw")).sendKeys(Keys.COMMAND,"v");

        WebElement element = webDriver.findElement(By.xpath("//a[text()='直播']"));
        System.out.println("元素的标签名："+element.getTagName());
        System.out.println("元素的href属性名："+element.getAttribute("href"));
        System.out.println("元素的文本值："+element.getText());
    }
    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}