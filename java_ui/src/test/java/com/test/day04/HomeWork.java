package com.test.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenguangwei on 2021/5/23.
 */
public class HomeWork {
    static WebDriver webDriver;
    public static void main(String[] args) throws Exception{
        webDriver = openBrowser("chrome");

        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);//隐式等待

        webDriver.manage().window().maximize();//全屏
        webDriver.get("http://8.129.91.152:8765/Admin/Index/login.html");
        String loantitle = addbid();
        //登录
        webDriver.manage().window().maximize();//全屏
        webDriver.get("http://8.129.91.152:8765/Index/index.html");
        webDriver.findElement(By.xpath("//a[text()='登录']")).click();
        webDriver.findElement(By.xpath("//input[@name='phone']")).sendKeys("13323234545");
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("lemon123456");
        webDriver.findElement(By.xpath("//button[text()='登录']")).click();

        webDriver.findElement(By.xpath("//span[contains(text(),'"+loantitle+"')]/parent::div/parent::a/following-sibling::div[1]//a")).click();

        webDriver.findElement(By.xpath("//input[contains(@class,'form-control invest-unit-investinput')]")).sendKeys("3000");

        webDriver.findElement(By.xpath("//button[@class='btn btn-special height_style']")).click();

          //System.out.println(System.currentTimeMillis());//当前时间的时间戳
          //span[contains(text(),'自动化测试嗯嗯4')]/parent::div/parent::a/following-sibling::div[1]//a
          //span[contains(text(),'自动化测试嗯嗯4')]/parent::div/parent::a/following-sibling::div[1]/div[3]/div/div[1]/following-sibling::a
    }


    public static String addbid(){

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

        //封装成一个方法，内部处理异常，不要抛出异常
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用键盘按钮，向下键ARROW_DOWN  回车键ENTER
        webDriver.findElement(By.xpath("//*[contains(@placeholder,'输入手机号码进行查找')]")).sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//*[contains(@placeholder,'输入手机号码进行查找')]")).sendKeys(Keys.ENTER);
        //webDriver.findElement(By.xpath("//*[contains(@value,'自动化测试')]")).click();

        //使用时间戳后缀，然后返回
        String loantitle = "嗯嗯测试"+System.currentTimeMillis()/1000;
        webDriver.findElement(By.xpath("//td[text()='贷款标题:']/parent::tr/td[2]/input")).sendKeys(loantitle);
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
            try {
                Thread.sleep(2000);//异步加载，需要延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            webDriver.findElement(By.xpath("//div[text()='1']")).click();
            webDriver.findElement(By.xpath("//span[text()='审核']")).click();
            webDriver.findElement(By.xpath("//span[text()='审核通过']")).click();
        }
        //webDriver.quit();//关闭页面
        return loantitle;

    }
    public static WebDriver openBrowser(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/chenguangwei/Desktop/java_ui/src/test/resources/chromedriver 2");
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
