/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Page.Accountpage;
import Page.AccountsOverviewPage;
import Page.LoginPage;
import Page.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author HP
 */
public class RegisterTest extends BaseTest{

    RegisterPage regpage;
    LoginPage loginpage;
    Accountpage accpage;
    AccountsOverviewPage accoverview;

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
    regpage.enterusername("example95");
    regpage.eneterpassword("password");
    regpage.confirmpassword("password");
    regpage.clickregisterbutton();  
    String successmessage=regpage.getregsuccessmessage();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            System.getLogger(RegisterTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    Assert.assertTrue(successmessage.contains("Your account was created successfully. You are now logged in"));
    System.out.println("registration test passed successfully");
    
    }
    
    @Test(enabled=false)
    void loginTest(){
    loginpage=new LoginPage(driver);
    loginpage.enterusername("example2");
    loginpage.enterpassword("password");
    loginpage.clickloginbutton();
    String loginmessage=loginpage.loginmessage();
    Assert.assertTrue(loginmessage.contains("welcome"), "login test passed successfully");
    
    }
    
    @Test(priority=2)
    void openaccount(){
         
    accpage=new Accountpage(driver);
    accpage.clickOpenNewAccount();
    accpage.enteramount();
    accpage.clckopenaccountbutton();
    String successmessage=accpage.successmessage();
    Assert.assertTrue(successmessage.contains("Account Opened"));
    System.out.println("open account worked successfully");
    String accountid=accpage.accountid();
    System.out.println(accountid);
    }
    
     @Test(priority=3,dependsOnMethods = {"registerTest"})
     void verifyaccountsList(){
     accoverview=new AccountsOverviewPage(driver);
     accoverview.waitForPageLoad();
     accoverview.displayAllAccounts();
     }
    

        
}
