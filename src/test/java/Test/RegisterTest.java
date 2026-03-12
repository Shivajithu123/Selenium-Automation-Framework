/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Page.Accountpage;
import Page.LoginPage;
import Page.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author HP
 */
public class RegisterTest {
    WebDriver driver;
    RegisterPage regpage;
    LoginPage loginpage;
    Accountpage accpage;
    @BeforeMethod
    void setup(){
    driver=new ChromeDriver();
    driver.get("https://parabank.parasoft.com/parabank/register.htm");
    driver.manage().window().maximize();
    }
    
    @Test(priority=1)
    void registerTest(){
    regpage=new RegisterPage(driver);
    regpage.clickregisterbuttonhome();
    regpage.enterfirstname("example2");
    regpage.enterlastname("A");
    regpage.enteraddress("example address  new");
    regpage.entercity("kottody");
    regpage.enterstate("kerala");
    regpage.enterrzipcode(671532);
    regpage.enterphone(1234234567);
    regpage.enterssn(234567654);
    regpage.enterusername("shivauser");
    regpage.eneterpassword("samplepass");
    regpage.confirmpassword("samplepass");
    String successmessage=regpage.getsuccessmessage();
    Assert.assertTrue(successmessage.contains("Welcome"));
    System.out.println("registration test passed successfully");
    
    }
    
    @Test(priority=2)
    void loginTest(){
    loginpage=new LoginPage(driver);
    loginpage.enterusername("example2");
    loginpage.enterpassword("samplepass");
    loginpage.clickloginbutton();
    String loginmessage=loginpage.loginmessage();
    Assert.assertTrue(loginmessage.contains("welcome"), "login test passed successfully");
    
    }
    
    @Test
    void openaccount(){
    accpage=new Accountpage(driver);
    accpage.enterracctype("SAVINGS");
    accpage.enteramount();
    accpage.clckopenaccountbutton();
    String successmessage=accpage.successmessage();
    Assert.assertTrue(successmessage.contains("Account Opened"));
    System.out.println("open account worked successfully");
    String accountid=accpage.accountid();
    System.out.println(accountid);
    }
    
     @Test
     void verifyaccountsList(){
     
     }
    
}
