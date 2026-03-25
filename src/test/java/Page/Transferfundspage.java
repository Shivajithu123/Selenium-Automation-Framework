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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Transferfundspage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath="//a[normalize-space()='Transfer Funds']")
    WebElement transferfundsbutton;
    
    @FindBy(id="amount")
    WebElement amount;
    
    @FindBy(xpath="//input[@value='Transfer']")
    WebElement transferclick;
    
    @FindBy(xpath="//input[@value='Transfer']")
    WebElement clicktransfer;
    
    @FindBy(xpath="//h1[normalize-space()='Transfer Complete!']")
    WebElement resultmsg;
    
    
    public Transferfundspage(WebDriver driver){
    this.driver=driver;
    this.wait   = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    PageFactory.initElements(this.driver, this);
    
    }

    public void clicktransferfundspage(){
        transferfundsbutton.click();

    }
    public void enteramount(String amount){
     WebElement am=this.amount;
     am.sendKeys(amount);
    }
    
    public void clicktransferbutton(){
    clicktransfer.click();
    }
    public void waitForPageLoad() {
    // Wait for from account dropdown to be visible
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("fromAccountId")
    ));
    // Wait for from account options to load via AJAX
    wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
            By.id("fromAccountId"), By.tagName("option")
    ));
    // Wait for to account options to load via AJAX
    wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
            By.id("toAccountId"), By.tagName("option")
    ));
    System.out.println("[INFO] Transfer funds page fully loaded");
}

 public String resultmessage() {
    wait.until(ExpectedConditions.visibilityOf(resultmsg));
    String message = resultmsg.getText().trim();
    System.out.println("[INFO] Result message: " + message);
    return message;
}

}

