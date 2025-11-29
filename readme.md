
# Stockbit Web UI Technical Test

This project contains automated UI tests for the **Stockbit web application** using **Selenium WebDriver**, **Cucumber**, **Java**, and **TestNG**. The tests cover the **invalid login scenario** due to OTP/email limit.

---

## Table of Contents

* [Project Overview](#project-overview)
* [Technology Stack](#technology-stack)
* [Project Structure](#project-structure)
* [Prerequisites](#prerequisites)
* [Setup](#setup)
* [How to Run Tests](#how-to-run-tests)
* [Test Scenarios](#test-scenarios)
* [Notes](#notes)
* [Author](#author)

---

## Project Overview

This project is a technical test for Stockbit's web application focusing on **login functionality**. Due to the **OTP/email login limit**, only invalid login scenarios are implemented.

The test verifies that the application handles **invalid login attempts** correctly, ensuring that proper error messages are displayed when the login fails due to OTP restrictions.

---

## Technology Stack

* Java 17+
* Selenium WebDriver
* Cucumber JVM
* TestNG
* Maven (for dependency management)
* ChromeDriver (WebDriverManager used)

---

## Project Structure

```
stockbit-web-ui-test/
│
├─ src/
│  ├─ main/
│  │   └─ java/
│  │       └─ utils/            # Helper classes (e.g., WebDriver setup)
│  │
│  └─ test/
│      ├─ java/
│      │   └─ stepdefinitions/  # Cucumber step definitions
│      │   └─ runners/          # TestNG runners
│      │
│      └─ resources/
│          └─ features/         # Cucumber feature files
│
├─ pom.xml                     # Maven dependencies
└─ README.md
```

---

## Prerequisites

* Java 17 or higher installed
* Maven installed
* Chrome browser installed (latest version)
* Internet connection to access Stockbit web

---

## Setup

1. Clone this repository:

```
git clone <repository-url>
cd stockbit-web-ui-test
```

2. Install dependencies:

```
mvn clean install
```

3. Ensure ChromeDriver is compatible with your installed Chrome version. This project uses **WebDriverManager** to handle this automatically.

---

## How to Run Tests

### Using Maven:

```
mvn clean test
```

---

## Test Scenarios

Currently, the following scenario is implemented:

### Invalid Login Due to OTP/Email Limit

**Feature:** Login

**Scenario:** User attempts to login but exceeds OTP/email login limit
**Steps:**

1. Navigate to Stockbit homepage
2. Go to login page
3. Enter registered email
4. Submit request for OTP
5. Validate error message if OTP/email limit is reached

**Expected Result:**

* User cannot login
* Error message is displayed indicating OTP/email limit reached

> ⚠ Note: Valid login tests are **not implemented** due to OTP limitations.

---

## Author

Muhammad Nurfaizi

## Notes

* Notes : Real Stockbit login requires OTP / Google Sign-In, which cannot be automated
safely in a public technical test environment. Therefore, this script covers
the login page UI flow only. In real implementation, login is usually
mocked, handled via API token, or bypassed using a staging parameter.
