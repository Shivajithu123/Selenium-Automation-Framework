/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

/**
 *
 * @author HP
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage{

    WebDriver driver;

    // Logout link
    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement logoutLink;

    // Login panel (appears after logout)
    @FindBy(xpath = "//h2[normalize-space()='Customer Login']")
    WebElement loginPanel;

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click logout
    public void clickLogout() {
        logoutLink.click();
    }

    // Validate logout success
    public boolean isLogoutSuccessful() {
        return loginPanel.isDisplayed();
    }
}