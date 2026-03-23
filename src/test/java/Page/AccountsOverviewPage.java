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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;


public class AccountsOverviewPage {

    // ── Driver & Wait ────────────────────────────────────────────────────────
    private final WebDriver driver;
    private final WebDriverWait wait;

    // ── URL ──────────────────────────────────────────────────────────────────



    // ── Locators ─────────────────────────────────────────────────────────────
    private final By pageHeader        = By.cssSelector("h1.title");
    private final By accountTable      = By.id("accountTable");
    private final By accountRows       = By.cssSelector("#accountTable tbody tr");
    private final By totalBalance      = By.cssSelector("#accountTable tfoot tr td:nth-child(2)");
    private final By accountLinks      = By.cssSelector("#accountTable tbody tr td:first-child a");
    private final By welcomeMessage    = By.cssSelector(".smallText");
    private final By errorMessage      = By.cssSelector(".error");

    // ── Constructor ───────────────────────────────────────────────────────────
    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[normalize-space()='Accounts Overview']")
    )).click();
       
    }

    // ═════════════════════════════════════════════════════════════════════════
    // NAVIGATION
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Navigates directly to the Accounts Overview page.
     */
    


    /**
     * Waits until the accounts table is fully visible on screen.
     */
// ✅ Wait for both the table AND the rows inside it
public AccountsOverviewPage waitForPageLoad() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(accountTable));
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.cssSelector("#accountTable tbody tr")
    ));
    System.out.println("[INFO] Accounts Overview page loaded");
    return this;
}

    // ═════════════════════════════════════════════════════════════════════════
    // DATA EXTRACTION – All Accounts
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Extracts all account rows from the overview table.
     *
     * @return List of AccountDetail objects, one per account row.
     */
public List<AccountDetail> getAllAccounts() {
    List<AccountDetail> accounts = new ArrayList<>();

    List<WebElement> rows = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(accountRows)
    );

    for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if (cells.size() < 3) continue;

        // ❌ Old — crashes if no <a> tag in first cell
        // WebElement linkElement = cells.get(0).findElement(By.tagName("a"));

        // ✅ Fixed — check if <a> exists before accessing it
        List<WebElement> links = cells.get(0).findElements(By.tagName("a"));
        if (links.isEmpty()) continue; // skip rows without a link (e.g. Total row)

        String accountId  = links.get(0).getText().trim();
        String accountUrl = links.get(0).getAttribute("href");
        String balance    = cells.get(1).getText().trim();
        String available  = cells.get(2).getText().trim();

        accounts.add(new AccountDetail(accountId, balance, available, accountUrl));
    }

    return accounts;
}

    /**
     * Returns the number of accounts displayed in the table.
     */
    public int getAccountCount() {
        return getAllAccounts().size();
    }

    // ═════════════════════════════════════════════════════════════════════════
    // DATA EXTRACTION – Single Account
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Retrieves details for a specific account by its ID.
     *
     * @param accountId The account ID string (e.g. "12345")
     * @return AccountDetail, or null if not found.
     */
    public AccountDetail getAccountById(String accountId) {
        for (AccountDetail account : getAllAccounts()) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Returns the balance string for a specific account ID.
     * Uses the element ID pattern ParaBank generates: id="balance{accountId}"
     *
     * @param accountId The account ID.
     * @return Balance as string e.g. "$1,500.00"
     */
    public String getBalanceById(String accountId) {
        try {
            WebElement balanceCell = driver.findElement(
                    By.id("balance" + accountId)
            );
            return balanceCell.getText().trim();
        } catch (Exception e) {
            System.err.println("[WARN] Balance element not found for account: " + accountId);
            return "N/A";
        }
    }

    /**
     * Returns the available amount for a specific account ID.
     * Uses element ID pattern: id="available{accountId}"
     *
     * @param accountId The account ID.
     * @return Available amount as string e.g. "$1,500.00"
     */
    public String getAvailableById(String accountId) {
        try {
            WebElement availableCell = driver.findElement(
                    By.id("available" + accountId)
            );
            return availableCell.getText().trim();
        } catch (Exception e) {
            System.err.println("[WARN] Available element not found for account: " + accountId);
            return "N/A";
        }
    }

    // ═════════════════════════════════════════════════════════════════════════
    // DATA EXTRACTION – Summary / Totals
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Returns the total balance shown in the table footer.
     *
     * @return Total balance string e.g. "$3,000.00"
     */
    public String getTotalBalance() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(totalBalance)
            ).getText().trim();
        } catch (Exception e) {
            System.err.println("[WARN] Total balance element not found.");
            return "N/A";
        }
    }

    /**
     * Returns the page header text (e.g. "Accounts Overview").
     */
    public String getPageTitle() {
        try {
            return driver.findElement(pageHeader).getText().trim();
        } catch (NoSuchElementException e) {
            return driver.getTitle();
        }
    }

    /**
     * Returns the welcome/greeting message shown on the overview page.
     */
    public String getWelcomeMessage() {
        try {
            return driver.findElement(welcomeMessage).getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Checks whether an error message is displayed on the page.
     */
    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ═════════════════════════════════════════════════════════════════════════
    // DISPLAY / PRINT
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Prints all account details to the console in a formatted table.
     */
    public void displayAllAccounts() {
        List<AccountDetail> accounts = getAllAccounts();

        System.out.println("\n" + "=".repeat(70));
        System.out.println("  PARABANK — ACCOUNTS OVERVIEW");
        System.out.println("  Page : " + getPageTitle());
        System.out.println("=".repeat(70));
        System.out.printf("  %-15s %-20s %-20s%n", "Account ID", "Balance", "Available Amount");
        System.out.println("-".repeat(70));

        if (accounts.isEmpty()) {
            System.out.println("  No accounts found.");
        } else {
            for (AccountDetail acc : accounts) {
                System.out.printf("  %-15s %-20s %-20s%n",
                        acc.getAccountId(),
                        acc.getBalance(),
                        acc.getAvailable()
                );
            }
        }

        System.out.println("-".repeat(70));
        System.out.printf("  %-15s %-20s%n", "TOTAL", getTotalBalance());
        System.out.printf("  Total Accounts : %d%n", accounts.size());
        System.out.println("=".repeat(70) + "\n");
    }

    /**
     * Prints details of a single account to the console.
     *
     * @param accountId The account ID to display.
     */
    public void displayAccountById(String accountId) {
        AccountDetail account = getAccountById(accountId);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  ACCOUNT DETAILS");
        System.out.println("=".repeat(50));

        if (account == null) {
            System.out.println("  Account ID [" + accountId + "] not found.");
        } else {
            System.out.println("  Account ID       : " + account.getAccountId());
            System.out.println("  Balance          : " + account.getBalance());
            System.out.println("  Available Amount : " + account.getAvailable());
            System.out.println("  Account URL      : " + account.getAccountUrl());
        }

        System.out.println("=".repeat(50) + "\n");
    }

    // ═════════════════════════════════════════════════════════════════════════
    // INNER CLASS — AccountDetail (Data Model)
    // ═════════════════════════════════════════════════════════════════════════

    /**
     * Represents a single account row from the Accounts Overview table.
     */
    public static class AccountDetail {

        private final String accountId;
        private final String balance;
        private final String available;
        private final String accountUrl;

        public AccountDetail(String accountId, String balance,
                             String available, String accountUrl) {
            this.accountId  = accountId;
            this.balance    = balance;
            this.available  = available;
            this.accountUrl = accountUrl;
        }

        // Getters
        public String getAccountId()  { return accountId;  }
        public String getBalance()    { return balance;    }
        public String getAvailable()  { return available;  }
        public String getAccountUrl() { return accountUrl; }

        /**
         * Returns the balance as a double (strips $ and commas).
         */
        public double getBalanceAsDouble() {
            return parseAmount(balance);
        }

        /**
         * Returns the available amount as a double.
         */
        public double getAvailableAsDouble() {
            return parseAmount(available);
        }

        private double parseAmount(String amount) {
            try {
                return Double.parseDouble(
                        amount.replace("$", "").replace(",", "").trim()
                );
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }

        @Override
        public String toString() {
            return String.format("AccountDetail{id='%s', balance='%s', available='%s'}",
                    accountId, balance, available);
        }
    }
}