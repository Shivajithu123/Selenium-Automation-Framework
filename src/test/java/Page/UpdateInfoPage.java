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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class UpdateInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath="//a[normalize-space()='Update Contact Info']")
    WebElement updatecontactinfo;
    
    @FindBy(id="customer.firstName")
     WebElement firstname;
    
    @FindBy(id="customer.lastName")
     WebElement lastname;
    
    @FindBy(id="customer.address.street")
     WebElement address;
    
    @FindBy(id="customer.address.city")
     WebElement city;
    
    @FindBy(id="customer.address.state")
     WebElement state;
    
    @FindBy(id="customer.address.zipCode")
     WebElement zipcode;
   
    @FindBy(id="customer.phoneNumber")
     WebElement phone;
    
    
    @FindBy(xpath="//input[@value='Update Profile']")
    WebElement updatebutton;
    
    @FindBy(xpath="//h1[normalize-space()='Profile Updated']")
    WebElement resultmessage;
    
   public  UpdateInfoPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(this.driver,this);
        this.wait   = new WebDriverWait(this.driver, Duration.ofSeconds(15));
   }
   
   public void clickupdateinfo(){
   updatecontactinfo.click();
   wait.until(ExpectedConditions.visibilityOf(firstname));
   }
   
   public void updatedetails(String firstname,String lastname,String address,String state,String zipcode,String phone){
   this.firstname.sendKeys(firstname);
   this.lastname.sendKeys(lastname);
   this.address.sendKeys(address);
   this.state.sendKeys(state);
   this.zipcode.sendKeys(zipcode);
   this.phone.sendKeys(phone);
   }
    
    public void clickupdatebutton(){
    updatebutton.click();
    wait.until(ExpectedConditions.visibilityOf(resultmessage));
    

    
}
    public String resultmessage(){
    return resultmessage.getText();
    }
}
