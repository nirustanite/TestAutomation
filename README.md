### TestAutomation
### Using Selenium Webdriver

**TASK**

1. Create a new account
2. Add an item to the basket and perform a checkout

---

**ASSUMPTIONS**
1. Script is written for testing in Chrome only.

---

**PREREQUISTES**
1. Maven should be installed.
2. Runtime Environment should be JDK.
3. Install chrome driver and place the path in resources/config.properties
   Example Path: \\\Path to exe\\\chromedriver.exe

---

**PARAMETERS REQUIRED**

**config.properties**
1. chromedriverpath

---

**COMMAND TO RUN THE PROGRAM**

1. Navigate to the program.
2. Enter the command.

mvn clean test -DsuiteXmlFile=testng

---

**REPORT GENERATION**

Used Extent Reports for report generation.

The report will be available under ExtentReports folder.
