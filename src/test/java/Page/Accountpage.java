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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Accountpage {
    WebDriver driver;
    private WebDriverWait wait;
    public Accountpage(WebDriver driver){
    this.driver=driver;
    this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    
    }
  private By openacc=By.xpath("//a[contains(text(),'Open New Account')]");
   // private By acctype=By.id("type");
   // private By depositamount=By.id("fromAccountId");
  private By openaccountbtn=By.xpath("//input[@value='Open New Account']");
  private By sucessmessage=By.xpath("//h1[normalize-space()='Account Opened!']");
  private By newaccountid=By.id("newAccountId");

  public void clickOpenNewAccount() {
    wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(),'Open New Account')]")
    )).click();
    System.out.println("[INFO] Clicked Open New Account link");
}
  public void enteramount() {
    // Wait for AJAX to populate the dropdown with options first
    wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
            By.id("fromAccountId"), By.tagName("option")
    ));
    WebElement amountdrop = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("fromAccountId"))
    );
    amountdrop.click();
    Select nselect = new Select(amountdrop);
    nselect.selectByIndex(0);
    System.out.println("[INFO] Selected from account at index 0");
}

public void clckopenaccountbutton() {
    wait.until(ExpectedConditions.elementToBeClickable(openaccountbtn)).click();
    System.out.println("[INFO] Clicked Open Account button");
}

public String successmessage() {
    String message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(sucessmessage)
    ).getText().trim();
    System.out.println("================================");
    System.out.println("[INFO] Success Message : " + message);
    System.out.println("================================");
    return message;
}

public String accountid() {
    String id = wait.until(
            ExpectedConditions.visibilityOfElementLocated(newaccountid)
    ).getText().trim();
    System.out.println("[INFO] New Account ID  : " + id);
    return id;
}
  }

