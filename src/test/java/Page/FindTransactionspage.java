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
import java.util.List;
import static org.apache.commons.lang3.ObjectUtils.wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FindTransactionspage {
    
    
    
    WebDriver driver;
    WebDriverWait wait; 
    
    @FindBy(xpath = "//a[normalize-space()='Find Transactions']")
    WebElement findTransactionsLink;
 
    @FindBy(id = "accountId")
    WebElement accountDropdown;
 
    // Search by Transaction ID
    @FindBy(id = "transactionId")
    WebElement transactionIdField;
 
    @FindBy(id="findById")
    WebElement findByIdBtn;
 
    // Search by Date
    @FindBy(id = "transactionDate")
    WebElement transactionDateField;
    
    @FindBy(id="findByDate")
    WebElement findByDateBtn;

 
    // Search by Date Range
    @FindBy(id = "fromDate")
    WebElement fromDateField;
 
    @FindBy(id = "toDate")
    WebElement toDateField;
 
    @FindBy(id="findByDateRange")
    WebElement findByDateRangeBtn;
 
    // Search by Amount
    @FindBy(id = "amount")
    WebElement amountField;
 
    @FindBy(id="findByAmount")
    WebElement findByAmountBtn;
 
    // Results
    @FindBy(id = "transactionTable")
    WebElement transactionTable;
 
    @FindBy(xpath = "//table[@id='transactionTable']//tbody//tr")
    List<WebElement> transactionRows;
 
    @FindBy(xpath = "//h1[normalize-space()='Transaction Results']")
    WebElement resultHeading;
 
    @FindBy(xpath = "//p[contains(text(),'No transactions found')]")
    WebElement noTransactionsMsg;
 
    @FindBy(xpath = "//p[@class='error']")
    WebElement errorMessage;
    
    

@FindBy(id = "formContainer")
WebElement formContainer;

@FindBy(id = "resultContainer")
WebElement resultContainer;
    
    public FindTransactionspage(WebDriver driver){
        this.driver=driver;
        this.wait   = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        PageFactory.initElements(this.driver, this);
    }
    
    public void clickFindTransactions() {
        wait.until(ExpectedConditions.elementToBeClickable(findTransactionsLink)).click();
        System.out.println("[INFO] Clicked Find Transactions link");
        waitForPageLoad();
    }
 
    /*
     Waits for account dropdown to be visible — confirms page is loaded.
    */
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(accountDropdown));
        // Wait for AJAX to populate account options
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                By.id("accountId"), By.tagName("option")
        ));
        System.out.println("[INFO] Find Transactions page fully loaded");
    }
 
    // ════════════════════════════════════════════════════════════════════════
    // ACCOUNT SELECTION
    // ═════════════════════════════════════════════════════════════════════════
 
    /**
     * Selects account from dropdown by index.
     */
    public void selectAccount(int index) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                By.id("accountId"), By.tagName("option")
        ));
        org.openqa.selenium.support.ui.Select select =
                new org.openqa.selenium.support.ui.Select(accountDropdown);
        select.selectByIndex(index);
        System.out.println("[INFO] Selected account: "
                + select.getFirstSelectedOption().getText());
    }
 
    /**
     * Selects account from dropdown by visible account number.
     */
    public void selectAccountByNumber(String accountNumber) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                By.id("accountId"), By.tagName("option")
        ));
        org.openqa.selenium.support.ui.Select select =
                new org.openqa.selenium.support.ui.Select(accountDropdown);
        select.selectByVisibleText(accountNumber);
        System.out.println("[INFO] Selected account: " + accountNumber);
    }
 
    // ═════════════════════════════════════════════════════════════════════════
    // SEARCH METHODS
    // ═════════════════════════════════════════════════════════════════════════
 
    /**
     * Finds transaction by Transaction ID.
     */
    public void findByTransactionId(String transId) {
        wait.until(ExpectedConditions.visibilityOf(transactionIdField));
        transactionIdField.clear();
        transactionIdField.sendKeys(transId);
        System.out.println("[INFO] Entered transaction ID: " + transId);
 
        wait.until(ExpectedConditions.elementToBeClickable(findByIdBtn)).click();
        System.out.println("[INFO] Clicked Find by ID button");
        waitForResults();
    }
 
    /**
     * Finds transactions by specific date.
     * Date format: MM-DD-YYYY
     */
    public void findByDate(String date) {
   wait.until(ExpectedConditions.visibilityOf(transactionDateField));
    transactionDateField.clear();
    transactionDateField.sendKeys(date);
    System.out.println("[INFO] Entered transaction date: " + date);

    wait.until(ExpectedConditions.elementToBeClickable(findByDateBtn)).click();
    System.out.println("[INFO] Clicked Find by Date button");

    // ✅ Wait for resultContainer to appear after clicking — AJAX loads results here
    wait.until(ExpectedConditions.visibilityOf(resultContainer));
    wait.until(ExpectedConditions.visibilityOf(transactionTable));
    System.out.println("[INFO] Results loaded after Find by Date");
    }
 
    /**
     * Finds transactions within a date range.
     * Date format: MM-DD-YYYY
     */
    public void findByDateRange(String fromDate, String toDate) {
        wait.until(ExpectedConditions.visibilityOf(fromDateField));
        fromDateField.clear();
        fromDateField.sendKeys(fromDate);
        System.out.println("[INFO] Entered from date: " + fromDate);
 
        toDateField.clear();
        toDateField.sendKeys(toDate);
        System.out.println("[INFO] Entered to date: " + toDate);
 
        wait.until(ExpectedConditions.elementToBeClickable(findByDateRangeBtn)).click();
        System.out.println("[INFO] Clicked Find by Date Range button");
        waitForResults();
    }
 
    /**
     * Finds transactions by amount.
     */
    public void findByAmount(String transAmount) {
  wait.until(ExpectedConditions.visibilityOf(amountField));
    amountField.clear();
    amountField.sendKeys(transAmount);
    wait.until(ExpectedConditions.elementToBeClickable(findByAmountBtn)).click();

    // ✅ Wait after clicking
    wait.until(ExpectedConditions.visibilityOf(resultContainer));
    wait.until(ExpectedConditions.visibilityOf(transactionTable));
    System.out.println("[INFO] Results loaded after Find by Amount");
    }
    
    
    
    // ✅ Add this method to FindTransactionsPage
    public void refreshPage() {
    driver.navigate().refresh();
    System.out.println("[INFO] Page refreshed");
    waitForPageLoad();
}
 
    // ═════════════════════════════════════════════════════════════════════════
    // RESULTS
    // ═════════════════════════════════════════════════════════════════════════
 
    /**
     * Waits for transaction results to appear after search.
     */
    public void waitForResults() {
        wait.until(ExpectedConditions.visibilityOf(transactionTable));
        System.out.println("[INFO] Transaction results loaded");
    }
 
    /**
     * Returns the result heading text.
     * e.g. "Transaction Results"
     */
    public String getResultHeading() {
        wait.until(ExpectedConditions.visibilityOf(resultHeading));
        String heading = resultHeading.getText().trim();
        System.out.println("[INFO] Result heading: " + heading);
        return heading;
    }
 
    /**
     * Returns number of transaction rows in results table.
     */
    public int getTransactionCount() {
        wait.until(ExpectedConditions.visibilityOf(transactionTable));
        int count = transactionRows.size();
        System.out.println("[INFO] Total transactions found: " + count);
        return count;
    }
 
    /**
     * Returns true if no transactions found message is displayed.
     */
    public boolean isNoTransactionsFound() {
        try {
            return noTransactionsMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
 
    /**
     * Returns true if error message is displayed.
     */
    public boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
 
    /**
     * Prints all transaction results to console.
     */
    public void displayTransactionResults() {
        wait.until(ExpectedConditions.visibilityOf(transactionTable));
 
        System.out.println("\n" + "=".repeat(80));
        System.out.println("  FIND TRANSACTIONS — RESULTS");
        System.out.println("=".repeat(80));
        System.out.printf("  %-15s %-20s %-20s %-15s%n",
                "Date", "Description", "Debit", "Credit");
        System.out.println("-".repeat(80));
 
        if (transactionRows.isEmpty()) {
            System.out.println("  No transactions found.");
        } else {
            for (WebElement row : transactionRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (cells.size() >= 4) {
                    System.out.printf("  %-15s %-20s %-20s %-15s%n",
                            cells.get(0).getText().trim(),
                            cells.get(1).getText().trim(),
                            cells.get(2).getText().trim(),
                            cells.get(3).getText().trim()
                    );
                }
            }
        }
 
        System.out.println("-".repeat(80));
        System.out.printf("  Total Transactions : %d%n", transactionRows.size());
        System.out.println("=".repeat(80) + "\n");
    }
}
   

