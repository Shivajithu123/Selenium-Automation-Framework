/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

/**
 *
 * @author HP
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class Accountpage {
    WebDriver driver;
    
    public Accountpage(WebDriver driver){
    this.driver=driver;
    
    }
  private By openacc=By.xpath("//a[normalize-space()='Open New Account']");
   // private By acctype=By.id("type");
   // private By depositamount=By.id("fromAccountId");
  private By openaccountbtn=By.xpath("//input[@value='Open New Account']");
  private By sucessmessage=By.xpath("//h1[normalize-space()='Account Opened!']");
  private By newaccountid=By.id("newAccountId");
  public void enterracctype(String acctype){
  WebElement acdrop=driver.findElement(By.id("type"));
  acdrop.click();
  Select select=new Select(acdrop);
  select.selectByValue(acctype);
  }
   
  
  public void enteramount(){
  WebElement amountdrop=driver.findElement(By.xpath("fromAccountId"));
  amountdrop.click();
  Select nselect=new Select(amountdrop);
  nselect.selectByIndex(0);
  
  }
  public void clckopenaccountbutton(){
  driver.findElement(openaccountbtn).click();
  }
  
  public String successmessage(){
  return driver.findElement(sucessmessage).getText();
  }
  
  public String  accountid(){
  return driver.findElement(newaccountid).getText();
  }
  }

