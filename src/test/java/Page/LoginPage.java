/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

/**
 *
 * @author HP
 */
// without log4j

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoginPage {
    private static final Logger logger =
        LogManager.getLogger(LoginPage.class);
     WebDriver driver;
     public LoginPage(WebDriver driver){
     this.driver=driver;
     logger.info("LoginPage initialized");

     }
     private By loginusername=By.name("username");
     private By loginpassword=By.name("password");
     private By loginbutton=By.xpath("//input[@value='Log In']");
     private By loginmsg=By.xpath("//p[@class='smallText']");
     
     public void enterusername(String username){
      logger.info("Entering username");
     driver.findElement(loginusername).sendKeys(username);
     }
     public void enterpassword(String password){
     logger.info("Entering password");
     driver.findElement(loginpassword).sendKeys(password);
     }
     public void clickloginbutton(){
     logger.info("Clicking Login button");
     driver.findElement(loginbutton).click();
     logger.info("Login operation completed");
     
     }
     
     public String loginmessage(){
     return driver.findElement(loginmsg).getText();
     }
    
}
