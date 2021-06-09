package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class ElementWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser("chrome");

        //设置隐式等待，全局性的，8s之内一直找这个元素
        //webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//
//        webDriver.get("http://www.testingpai.com");
//        //点击登录
//        webDriver.findElement(By.id("navLogin")).click();
//        //输入用户名
//        webDriver.findElement(By.id("nameOrEmail")).sendKeys("lemontest");
//        //输入密码
//        webDriver.findElement(By.id("loginPassword")).sendKeys("123456");
//        //点登录按钮
//        webDriver.findElement(By.id("loginBtn")).click();


        webDriver.get("https://www.baidu.com");
        webDriver.findElement(By.id("s-usersetting-top")).click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 8);
        //等待元素是否可见visibilityOfElementLocated
        //等待元素可被点击elementToBeClickable
        //等待元素存在presenceOfElementLocated
        WebElement until = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='高级搜索']")));
        until.click();

        //隐式等待和显示等待区别
        //1，作用域范围，隐式是全局型，显示针对某个元素
        //2，超时异常，隐式，nosuchelementexception,显示，timeoutexception
        //3,等待隐式区别，隐式，只能等待元素存在，显示，等待元素存在（不一定可见）/可见/可被点击


                //Thread.sleep(2000);//显示等待
                webDriver.quit();
    }

    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
