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
public class LoginPage {
     WebDriver driver;
     public LoginPage(WebDriver driver){
     this.driver=driver;
     }
     private By loginusername=By.name("username");
     private By loginpassword=By.name("password");
     private By loginbutton=By.xpath("//input[@value='Log In']");
     private By loginmsg=By.xpath("//p[@class='smallText']");
     
     public void enterusername(String username){
     driver.findElement(loginusername).sendKeys(username);
     }
     public void enterpassword(String password){
     driver.findElement(loginpassword).sendKeys(password);
     }
     public void clickloginbutton(){
     driver.findElement(loginbutton).click();
     
     }
     
     public String loginmessage(){
     return driver.findElement(loginmsg).getText();
     }
    
}
