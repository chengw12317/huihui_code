package com.test.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class SpeciaElementTest1 {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = openBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //window切换
//        driver.get("https://www.baidu.com/");
//        Set<String> handles1 = driver.getWindowHandles();
//        System.out.println("打开新闻之前的所有窗口句柄："+handles1);
//        //点击新闻
//        driver.findElement(By.xpath("//a[text()='新闻']")).click();
//        Set<String> handles2 = driver.getWindowHandles();
//        System.out.println("打开新闻之后的所有窗口句柄："+handles2);
//
//        switchWindow("百度新闻——海量中文资讯平台");
//        driver.findElement(By.xpath("//div[@id='channel-all']//a[text()='军事']")).click();


        //鼠标操作
//        driver.get("https://www.baidu.com");
//        Thread.sleep(2000);
//        Actions actions = new Actions(driver);
//        WebElement element = driver.findElement(By.id("s-usersetting-top"));
//        actions.moveToElement(element).perform();//鼠标移动到指定元素
//        //鼠标拖拽
//        driver.get("");
//        //定位1元素
//        WebElement element1 = driver.findElement(By.id(""));
//        //定位2元素
//        WebElement element2 = driver.findElement(By.id(""));
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(element1).moveToElement(element2).release().perform();

        //执行javascript 改变元素属性
//        driver.get("https://www.12306.cn/index/");
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("document.getElementById('train_date').removeAttribute('readonly')");
//        Thread.sleep(1000);
//        driver.findElement(By.id("train_date")).clear();
//        driver.findElement(By.id("train_date")).sendKeys("2021-05-02");

        //执行滚动的代码,滚动到底部
//        driver.get("https://www.12306.cn/index/");
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        //javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//        javascriptExecutor.executeScript("document.getElementById('index_ads').scrollIntoViewIfNeeded(ture);");//滚动到指定元素

        //特殊元素无法通过clink点击
        driver.get("https://prepc.ketangpai.com/#/homePage");
        WebElement webElement = driver.findElement(By.xpath("//span[text()='登录']"));
        String str = "hello";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].clink()",webElement);
    }

    //公共窗口切换方法
    public static void switchWindow(String title){
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle:allHandles){
            if (driver.getTitle().equals(title)){
                break;//符合，跳出循环
            }else {
                driver.switchTo().window(handle);//切换窗口
            }
        }

    }

    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
