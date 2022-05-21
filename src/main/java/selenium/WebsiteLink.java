package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebsiteLink {

    WebDriver driver;
    @BeforeMethod
    public void getTheWebsite() {
        //WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "/home/dastan/Downloads/geckodriver");
        driver = new FirefoxDriver();
        System.out.println("Browser is launched.");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Orange HRM URL is open.");
    }

    @Test
    public void clickForgotPasswordLink() {
        driver.findElement(By.xpath("//*[@id=\"forgotPasswordLink\"]/a")).click();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
