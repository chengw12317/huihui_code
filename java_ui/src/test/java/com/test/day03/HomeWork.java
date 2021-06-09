package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenguangwei on 2021/5/22.
 */
public class HomeWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser("chrome");
        webDriver.get("http://8.129.91.152:8765/Admin/Index/login.html");

        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);//隐式等待

        webDriver.manage().window().maximize();//全屏
        webDriver.get("http://8.129.91.152:8765/Admin/Index/login.html");

        //登录
        webDriver.findElement(By.xpath("//input[@name='admin_name']")).sendKeys("lemon7");
        webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("lemonbest");
        webDriver.findElement(By.xpath("//input[@class='admin_login_verify']")).sendKeys("hapi");
        webDriver.findElement(By.xpath("//button[@class='admin_login_btn denglu']")).click();

//        WebDriver.Window window = webDriver.manage().window();
//        window.fullscreen();//局部全屏

        //投标
        webDriver.findElement(By.xpath("//span[@class='tree-title' and text()='借款管理']")).click();
        //新增了一个html页面，需要切换页面，iframe  切换：switchTo
        webDriver.switchTo().frame("mainFrame");
        webDriver.findElement(By.xpath("//span[@class='l-btn-text' and text()='加标']")).click();
        webDriver.findElement(By.xpath("//*[contains(@placeholder,'输入手机号码进行查找')]")).sendKeys("13323234444");
        Thread.sleep(1000);
        //使用键盘按钮，向下键ARROW_DOWN  回车键ENTER
        webDriver.findElement(By.xpath("//*[contains(@placeholder,'输入手机号码进行查找')]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[contains(@placeholder,'输入手机号码进行查找')]")).sendKeys(Keys.ENTER);
        //webDriver.findElement(By.xpath("//*[contains(@value,'自动化测试')]")).click();
        webDriver.findElement(By.xpath("//td[text()='贷款标题:']/parent::tr/td[2]/input")).sendKeys("自动化测试嗯嗯4");
        webDriver.findElement(By.xpath("//td[text()='年利率利息:']/parent::tr/td[2]/input")).sendKeys("30");
        webDriver.findElement(By.xpath("//td[text()='借款期限:']/parent::tr/td[2]/input")).sendKeys("6");
        webDriver.findElement(By.xpath("//td[text()='借款额度:']/parent::tr/td[2]/input")).sendKeys("500000");
        webDriver.findElement(By.xpath("//td[text()='竞标期限:']/parent::tr/td[2]/input")).sendKeys("10");

        webDriver.findElement(By.xpath("//span[text()='风控评测']")).click();
        webDriver.findElement(By.xpath("//td[text()='评估价值:']/parent::tr/td[2]/input")).sendKeys("1000");

        webDriver.findElement(By.xpath("//span[text()='项目录入']")).click();
        webDriver.findElement(By.xpath("//td[text()='籍贯:']/parent::tr/td[2]/input")).sendKeys("宿州");
        webDriver.findElement(By.xpath("//td[text()='职业:']/parent::tr/td[2]/input")).sendKeys("测试");
        webDriver.findElement(By.xpath("//td[text()='年龄:']/parent::tr/td[2]/input")).sendKeys("22");
        webDriver.findElement(By.xpath("//span[text()='提交']")).click();

        //审核
        for (int i=0;i<3;i++){
            Thread.sleep(2000);//异步加载，需要延迟
            webDriver.findElement(By.xpath("//div[text()='1']")).click();
            webDriver.findElement(By.xpath("//span[text()='审核']")).click();
            webDriver.findElement(By.xpath("//span[text()='审核通过']")).click();
        }

        //webDriver.quit();//关闭页面


    }
    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
