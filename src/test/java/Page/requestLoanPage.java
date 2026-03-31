/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author HP
 */
public class requestLoanPage {
    WebDriver driver;
    WebDriverWait wait;
   
    @FindBy(xpath="//a[normalize-space()='Request Loan']")
    WebElement requestloanbutton;
    
    @FindBy(id="amount")
    WebElement amount;
    
    @FindBy(id="downPayment")
    WebElement downpayment;
    
    @FindBy(id="fromAccountId")
    WebElement fromaccountid;
    
    @FindBy(xpath="//option[@value='14676']")
    WebElement dropdownvalue;
    
    @FindBy(xpath="//input[@value='Apply Now']")
    WebElement applynowbutton;

@FindBy(xpath = "//div[@id='loanRequestApproved']/p[1]")
WebElement loanapprovalmessage;
   public requestLoanPage(WebDriver driver){
        
        this.driver=driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(this.driver, this);
    }

    public void clickrequestloan(){
    requestloanbutton.click();
    wait.until(ExpectedConditions.visibilityOf(amount));
    }

    public void enteramount(String amount){
    this.amount.sendKeys(amount);
    }
    
    public void enterdownpayment(String downpayment){
    this.downpayment.sendKeys(downpayment);
    }
    public void selectfromaccountid(){
    Select select=new Select(fromaccountid);
    wait.until(ExpectedConditions.visibilityOf(dropdownvalue));
    select.selectByIndex(0);
    }
   public  void clickapplynow(){
    applynowbutton.click();
     wait.until(ExpectedConditions.textToBePresentInElement(loanapprovalmessage, "Congratulations"));
    }
   
   public String getsuccessmessage(){
   return loanapprovalmessage.getText();
   }
}
