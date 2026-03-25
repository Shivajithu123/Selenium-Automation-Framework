/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Page.Accountpage;
import Page.AccountsOverviewPage;
import Page.BillpayPage;
import Page.FindTransactionspage;
import Page.LoginPage;
import Page.RegisterPage;
import Page.Transferfundspage;
import Page.UpdateInfoPage;
import org.testng.Assert;
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
    Transferfundspage transferpage;
    BillpayPage        billpaypage;
    FindTransactionspage findpage;
    UpdateInfoPage  updatedetails;
    
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
    regpage.enterusername("example63");
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
     
     @Test(priority=4)
     void transferfunds(){
         transferpage=new Transferfundspage(driver);
          
     transferpage.clicktransferfundspage();
     transferpage.waitForPageLoad();
     transferpage.enteramount("10");
     transferpage.clicktransferbutton();
     String resultmsg=transferpage.resultmessage();
     System.out.println(resultmsg);
     Assert.assertTrue(resultmsg.contains("Transfer"));
     System.out.println("transfer funds functionality working properly");
     }
    
     
     @Test(priority=5)
     void billpay(){
     billpaypage=new BillpayPage(driver);
     billpaypage.clickbillpaybutton();
     billpaypage.waitForPageLoad();
     billpaypage.enterdetails("shiva", "example po house po address", "example city", "examplestate", "012345", "999999999", "12345", "12345", "10");
     billpaypage.slectfromaccount();
     billpaypage.clicksendpayment();
     String status=billpaypage.billpaystatus();
     Assert.assertTrue(status.contains("Bill Payment Complete"));
     }

     
     @Test(priority=6)
     void findtransactions(){
    findpage = new FindTransactionspage(driver);
    
    // Step 1: Click Find Transactions link
    findpage.clickFindTransactions();
    
    // Step 2: Select first account
    findpage.selectAccount(0);
    
    // Step 3: Find by Transaction ID
    //findpage.findByTransactionId("13455");
    //findpage.displayTransactionResults();
    //System.out.println("Total transactions found: " + findpage.getTransactionCount());
    
    // Step 4: Find by Date
    findpage.selectAccount(0);
    findpage.findByDate("01-01-2024");
    findpage.displayTransactionResults();
    findpage.refreshPage();
    // Step 5: Find by Date Range
    findpage.selectAccount(0);
    findpage.findByDateRange("01-01-2024", "12-31-2024");
    findpage.displayTransactionResults();
    findpage.refreshPage();
    // Step 6: Find by Amount
    findpage.selectAccount(0);
    findpage.findByAmount("10");
    findpage.displayTransactionResults();
    findpage.refreshPage();
    
    // Step 7: Assert results
    Assert.assertFalse(findpage.isErrorDisplayed(),
    "Error should not be displayed");
    System.out.println("Find Transactions working properly");
}
     @Test(priority=7)
     void updateprofile(){
     updatedetails=new UpdateInfoPage(driver);
     updatedetails.clickupdateinfo();
     updatedetails.updatedetails("kush", "mera", "example mahesh", "example state", "445676", "1234567856");
     updatedetails.clickupdatebutton();
     String resultmsg=updatedetails.resultmessage();
     Assert.assertTrue(resultmsg.contains("Your updated address and phone number have been added to the system."));
     System.out.println("update contact info field working properly");
     
     }

}

