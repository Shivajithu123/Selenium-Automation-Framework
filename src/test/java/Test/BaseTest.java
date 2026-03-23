/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author HP
 */
import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest{

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

