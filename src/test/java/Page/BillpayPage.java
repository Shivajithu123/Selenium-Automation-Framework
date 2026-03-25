/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

/**
 *
 * @author HP
 */
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BillpayPage {
    
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath="//a[normalize-space()='Bill Pay']")
     WebElement billpaybutton;
    
    @FindBy(name="payee.name")
     WebElement name;
    
    @FindBy(name="payee.address.street")
     WebElement address;
    
    @FindBy(name="payee.address.city")
    WebElement city;
    
    @FindBy(name="payee.address.state")
    WebElement state;
    
    @FindBy(name="payee.address.zipCode")
    WebElement zipcode;
    
    @FindBy(name="payee.phoneNumber")
    WebElement phone;
    
    @FindBy(name="payee.accountNumber")
    WebElement accountno;
    
    @FindBy(name="verifyAccount")
    WebElement verifyacc;
    
    @FindBy(name="amount")
    WebElement amount;
    
    @FindBy(name="fromAccountId")
    WebElement fromaccdropdown;
    
    @FindBy(xpath="//input[@value='Send Payment']")
    WebElement sendpaybtn;
    
    @FindBy(xpath="//h1[normalize-space()='Bill Payment Complete']")
    WebElement billpaystatus;
    
    
    
    
  
   public  BillpayPage(WebDriver driver){
    this.driver=driver;
    this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    PageFactory.initElements(this.driver, this);
    
    }
   public void clickbillpaybutton(){
    billpaybutton.click();
   }
       
   public void waitForPageLoad() {
    wait.until(ExpectedConditions.visibilityOf(name));
    System.out.println(" Bill Pay page fully loaded");
}
    
    public void enterdetails(String name, String address, String city, String state, String zipcode, String phone, String accountno, String verifyacc, String amount){
     this.name.sendKeys(name);
     this.address.sendKeys(address);
     this.city.sendKeys(city);
     this.state.sendKeys(state);
     this.zipcode.sendKeys(zipcode);
     this.phone.sendKeys(phone);
     this.accountno.sendKeys(accountno);
     this.verifyacc.sendKeys(verifyacc);
     this.amount.sendKeys(amount);
     
     
    }
    public void slectfromaccount(){
    fromaccdropdown.click();
wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
        By.name("fromAccountId"), By.tagName("option")
));
Select select = new Select(fromaccdropdown);
select.selectByIndex(0);
    }
    
    
    public void clicksendpayment(){
    sendpaybtn.click();
   
    }
    
    public String billpaystatus(){
        wait.until(ExpectedConditions.visibilityOf(billpaystatus));
    String result=billpaystatus.getText();
    return result;
    
    }
}
