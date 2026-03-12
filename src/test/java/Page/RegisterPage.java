/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

/**
 *
 * @author HP
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
public class RegisterPage {
    WebDriver driver;
    
    private By registerbuttonhome=By.xpath("//a[normalize-space()='Register']");
    private By firstname=By.xpath("//input[@id='customer.firstName']");
    private By lastname=By.id("customer.lastName");
    private By address=By.id("customer.address.street");
    private By city=By.id("customer.address.city");
    private By state=By.id("customer.address.state");
    private By zipcode=By.id("customer.address.zipCode");
    private By phone=By.id("customer.phoneNumber");
    private By ssn=By.id("customer.ssn");
    private By username=By.id("customer.username");
    private By password=By.id("customer.password");
    private By confirmpassword=By.id("repeatedPassword");
    private By registerbutton=By.id("//input[@value='Register']");
    private By successmessage=By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
    
     public RegisterPage(WebDriver driver) {
        this.driver = driver;
      
    }
     
    public void clickregisterbuttonhome(){
    
    driver.findElement(registerbuttonhome).click();
    }
    public void enterfirstname(String firstname){
    driver.findElement(this.firstname).sendKeys(firstname);
    }
     public void enterlastname(String lastname){
    driver.findElement(this.firstname).sendKeys(lastname);
    }
    
    public void enteraddress(String address){
    driver.findElement(this.address).sendKeys(address);
    }
    public void entercity(String city){
    driver.findElement(this.city).sendKeys(city);
    }
    public void enterstate(String state){
    driver.findElement(this.state).sendKeys(state);
    }
    public void enterrzipcode(int zipcode){
    driver.findElement(this.zipcode).sendKeys(Integer.toString(zipcode));
    }
    public void enterphone(int phone){
    driver.findElement(this.phone).sendKeys(Integer.toString(phone));
    }
    public void enterssn(int ssn){
    driver.findElement(this.ssn).sendKeys(Integer.toString(ssn));
    }
    public void enterusername(String username){
    driver.findElement(this.username).sendKeys(username);
    }
    public void eneterpassword(String password){
     driver.findElement(this.password).sendKeys(password);
    }
    public void confirmpassword(String password){
    driver.findElement(confirmpassword).sendKeys(password);
    }
    
    public void clickregisterbutton(){
    driver.findElement(registerbutton).click();
    }
    public String getsuccessmessage(){
     return driver.findElement(successmessage).getText();
    }
    }
    

