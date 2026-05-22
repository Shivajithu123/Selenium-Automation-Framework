# ParaBank Automation Framework

## Overview

This project is a robust UI Automation Framework developed for the open-source banking application **ParaBank** using:

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Extent Reports
* Allure Reports
* Log4j2
* WebDriverManager

The framework is designed to provide scalable, maintainable, and reusable automated test scripts for validating critical banking workflows in the ParaBank application.

---

## Tech Stack

| Technology              | Purpose                            |
| ----------------------- | ---------------------------------- |
| Java                    | Programming Language               |
| Selenium WebDriver      | Browser Automation                 |
| TestNG                  | Test Execution Framework           |
| Maven                   | Dependency Management & Build Tool |
| Page Object Model (POM) | Framework Design Pattern           |
| Extent Reports          | HTML Test Reporting                |
| Allure Reports          | Advanced Reporting & Analytics     |
| Log4j2                  | Logging                            |
| WebDriverManager        | Automatic Driver Management        |
| DataFaker               | Dynamic Test Data Generation       |

---

## Framework Features

* Page Object Model (POM) architecture
* Reusable utility methods
* Cross-browser support ready
* Detailed HTML reports using Extent Reports
* Allure reporting integration
* Screenshot capture on test failure
* Logging support using Log4j2
* Maven-based project structure
* Scalable and maintainable design
* Automated WebDriver binary management
* TestNG annotations and assertions

---

## Project Structure

```bash
Parabank/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── Factory/
│   │   │   │   └── DriverFactory.java
│   │   │   │
│   │   │   ├── Page/
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── RegisterPage.java
│   │   │   │   ├── Accountpage.java
│   │   │   │   ├── AccountsOverviewPage.java
│   │   │   │   ├── BillpayPage.java
│   │   │   │   ├── FindTransactionspage.java
│   │   │   │   ├── LogoutPage.java
│   │   │   │   ├── requestLoanPage.java
│   │   │   │   ├── Transferfundspage.java
│   │   │   │   └── UpdateInfoPage.java
│   │   │   │
│   │   │   ├── Test/
│   │   │   │   ├── BaseTest.java
│   │   │   │   └── ParabankTest.java
│   │   │   │
│   │   │   └── utils/
│   │
├── allure-results/
├── target/
├── pom.xml
└── README.md
```

---

## Covered Test Scenarios

The framework automates major banking functionalities including:

* User Registration
* User Login
* Account Overview Validation
* Fund Transfer
* Bill Payment
* Loan Request
* Transaction Search
* User Information Update
* Logout Functionality

---

## Prerequisites

Before running the framework, ensure the following are installed:

* Java JDK 11 or above
* Maven
* Chrome Browser
* IDE (IntelliJ IDEA / Eclipse / VS Code)

Verify installation:

```bash
java -version
mvn -version
```

---

## Installation & Setup

### Clone the Repository

```bash
git clone https://github.com/your-username/parabank-automation-framework.git
```

### Navigate to Project Directory

```bash
cd parabank-automation-framework
```

### Install Dependencies

```bash
mvn clean install
```

---

## Running the Tests

### Execute All Tests

```bash
mvn test
```

### Execute Specific TestNG Suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Reports

### Extent Reports

After execution, Extent Reports can be found inside:

```bash
/test-output/
```

### Allure Reports

Generate Allure Report:

```bash
allure serve allure-results
```

---

## Logging

The framework uses **Log4j2** for logging test execution details.

Logs help in:

* Debugging failures
* Tracking execution flow
* Identifying issues quickly

---

## Design Pattern Used

### Page Object Model (POM)

The framework follows the Page Object Model design pattern where:

* Web elements are separated from test logic
* Reusable page methods improve maintainability
* Easier scalability for future enhancements

---

## Sample Maven Dependencies

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
</dependency>

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
</dependency>

<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
</dependency>
```

---

## Future Enhancements

* Parallel test execution
* Cross-browser execution
* Docker integration
* Jenkins CI/CD integration
* Data-driven testing using Excel/JSON
* API automation integration
* BrowserStack/Sauce Labs execution

---

## Best Practices Followed

* Clean code structure
* Separation of concerns
* Reusable methods and components
* Proper exception handling
* Centralized driver management
* Reporting and logging integration

---

## Author

**Shivadath**

Automation Test Engineer | Selenium | Java | TestNG | Maven

---

## License

This project is created for educational and automation practice purposes.
