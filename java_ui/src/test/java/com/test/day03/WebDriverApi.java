package com.test.day03;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class WebDriverApi {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser("chrome");
        webDriver.get("https://www.baidu.com");
//        System.out.println(webDriver.getCurrentUrl());//获取页面url
//        System.out.println(webDriver.getTitle());//获取页面title
//        System.out.println(webDriver.getPageSource());//获取页面源代码

//        webDriver.findElement(By.xpath("//a[text()='地图']")).click();
//        Thread.sleep(2000);
//        webDriver.quit();//关闭所有窗口
//        //webDriver.close();//关闭当前页面

        //导航的操作
        //WebDriver.Navigation navigate = webDriver.navigate();
//        Navigation navigation = webDriver.navigate();
//        navigation.to("https://www.jd.com");
//        Thread.sleep(2000);
//        navigation.refresh();//刷新
//
//        Thread.sleep(2000);
//        navigation.back();//回退
//
//        Thread.sleep(2000);
//        navigation.forward();//前进

        //window窗口操作
        //Window window = webDriver.manage().window();
        //window.maximize();//最大化
        //window.fullscreen();//全屏
        //Point position = window.getPosition();
        //System.out.println("x轴的位置"+position.getX());
        //System.out.println("y轴的位置"+position.getY());
//        Dimension size = window.getSize();
//        System.out.println("窗口宽度"+size.getWidth());
//        System.out.println("窗口高度"+size.getHeight());

        Thread.sleep(2000);
        webDriver.quit();
    }

    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}