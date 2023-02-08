/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Pluto 01
 */
public class AUTest1 {
    WebDriver driver = null;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void firstTry(){
        driver.get("http://localhost/index.html");
        driver.findElement(id("no")).click();
        driver.findElement(id("buttoncheck")).click();
        String expectedResult = "Radio button is checked and it's value is No";
        String actualResult = driver.findElement(className("radiobutton")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
