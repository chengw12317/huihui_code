package com.test.day04;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class SpeciaElementTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser("chrome");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
//        webDriver.get("https://ke.qq.com/");
//        webDriver.findElement(By.id("js_login")).click();
//
//        WebElement iframeElent = webDriver.findElement(By.xpath("//iframe[contains(@src,'low_login_enable')]"));
//        webDriver.switchTo().frame(iframeElent);
//        webDriver.findElement(By.id("switcher_plogin")).click();
//
//        //输入qq号
//        webDriver.findElement(By.id("u")).sendKeys("13912341234");
//        webDriver.findElement(By.id("p")).sendKeys("123456");
//        webDriver.findElement(By.id("login_button")).click();
//        //返回上一级页面中
//        webDriver.switchTo().parentFrame();
//        Thread.sleep(2000);
//        //点击关闭按钮
//        webDriver.findElement(By.xpath("//a[@class='login-close']/i")).click();

        //Alert切换
//        webDriver.get("");
//        webDriver.findElement(By.id("")).click();
//        Thread.sleep(2000);
//        Alert alert = webDriver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();

        //window切换
        webDriver.get("https://www.baidu.com/");
        Set<String> handles1 = webDriver.getWindowHandles();
        System.out.println("打开新闻之前的所有窗口句柄："+handles1);
        //点击新闻
        webDriver.findElement(By.xpath("//a[text()='新闻']")).click();
        Set<String> handles2 = webDriver.getWindowHandles();
        System.out.println("打开新闻之后的所有窗口句柄："+handles2);
        //循环遍历所有句柄
        for (String handle:handles2){
            if (webDriver.getTitle().equals("百度新闻——海量中文资讯平台")){
                break;//符合，跳出循环
            }else {
                webDriver.switchTo().window(handle);//切换窗口
            }
        }
        webDriver.findElement(By.xpath("//div[@id='channel-all']//a[text()='军事']")).click();

        //总结
        //nosuchelementexception原因
        //1。元素表达式写错了
        //2。元素没有加载出来，
        //3。元素在iframe中
        //4。元素在新的窗口里面
    }


    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
