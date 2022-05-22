package test.java.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {
    WebDriver driver;
    @BeforeSuite
    public void lanuchBrowser() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "/home/dastan/Downloads/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Browser is launched.");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Orange HRM URL is open.");
    }
    @BeforeMethod
    public void login() {
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("User is logged in.");
    }

    @Test
    public void getTitle() {
        System.out.println("Title of the page is " + driver.getTitle());
    }
    @AfterMethod
    public void logOut() {
        driver.findElement(By.id("welcome")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
        System.out.println("Logged out from Orange HRM website.");
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
        System.out.println("Browser is closed.");
    }
}
