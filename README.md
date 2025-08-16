
---

# 🚀 OpenCart UI Automation Framework

![Framework](ProjectImage/Hybrid%20Automation%20framework.png)

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.0-brightgreen?logo=selenium)](https://www.selenium.dev/)
[![Maven](https://img.shields.io/badge/Maven-3.9-orange?logo=apache-maven)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-Framework-yellowgreen)](https://testng.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue?logo=docker)](https://www.docker.com/)
[![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-red?logo=jenkins)](https://www.jenkins.io/)

---

## 📌 Overview

This project is a **Hybrid Automation Framework** built for automating the **OpenCart** application using **Selenium, TestNG, Maven, Docker, and Jenkins**.

The framework supports:

* ✅ Page Object Model (POM) design pattern
* ✅ Data-driven testing (Excel-based)
* ✅ Cross-browser execution
* ✅ Parallel execution with Selenium Grid & Docker
* ✅ Jenkins CI/CD integration
* ✅ Extent Reporting & TestNG Listeners

---

## 📂 Project Structure

```


├── src/test/java/                 → Test scripts & page objects
│   ├── pageObjects/               → POM classes
│   ├── testBase/                  → Base setup class
│   ├── testCases/                 → TestNG test cases
│   └── utilities/                 → Helper classes (Excel, Reports)
├── src/test/resources/            → Config & log4j files
│   ├── config.properties/         → URL/PWD/Enviroment
│   └── log4j2.xml/                → Log4j execution logs
├── TestData/                      → Test data files (Excel)
├── reports/                       → HTML Extent Reports
├── screenshots/                   → Captured screenshots on failures
├── logs/                          → Log4j execution logs
├── test-output/                   → TestNG default reports
├── docker-compose.yaml            → Docker Grid setup
├── docker-grid.xml                → Grid execution config
├── pom.xml                        → Maven dependencies & plugins
├── master.xml                     → Master TestNG suite
├── run.bat                        → Batch file for execution
└── README.md                      → Project documentation
```

---

## ⚙️ Tech Stack

* **Language**: Java
* **Build Tool**: Maven
* **Test Framework**: Hybrid (POM + DataDriven + KeyWord Driven)
* **Automation Tool**: Selenium WebDriver
* **Logging**: Log4j2
* **Reporting**: Extent Reports + TestNG HTML Reports
* **CI/CD**: Jenkins
* **Containerization**: Docker + Selenium Grid

---

## 🛠️ Setup & Execution

### 1️⃣ Clone the repository

```bash
git clone https://github.com/NitinPatil-SDET/OpenCartUIAutomation.git
cd OpenCartUIAutomation
```

### 2️⃣ Install dependencies

```bash
mvn clean install
```

### 3️⃣ Run Tests

* **Default suite**

```bash
mvn clean test
```

* **Specific TestNG XML**

```bash
mvn clean test -DsuiteXmlFile=testng.xml
mvn clean test -DsuiteXmlFile=master.xml
mvn clean test -DsuiteXmlFile=crossbrowser.xml
```

* **Using run.bat**

```bash
run.bat
```

---

## 🐳 Docker + Selenium Grid Execution

### docker-compose.yaml

```yaml
version: "3"
services:
  selenium-hub:
    image: selenium/hub:4.0.0
    container_name: selenium-hub
    ports:
      - "4444:4444"

  chrome:
    image: selenium/node-chrome:4.0.0
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443

  firefox:
    image: selenium/node-firefox:4.0.0
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
```

### Run Grid

```bash
docker-compose up -d
```

### Execute Tests on Grid

```bash
mvn clean test -DsuiteXmlFile=docker-grid.xml
```

---

## 📊 Reports & Logs

* **Extent Reports** → `reports/`
* **Screenshots on Failure** → `screenshots/`
* **Log file** → `logs/automation.log`
* **TestNG Reports** → `test-output/`

![Extent Report](ProjectImage/OpencartExtentReportResult.png)

---

## 🔄 CI/CD with Jenkins

1. Install Jenkins & configure Maven + Git in **Global Tool Configuration**
2. Create a new Jenkins Job → Pull this repo
3. Add **Build Step**:

```bash
mvn clean test -DsuiteXmlFile=master.xml
```

4. View execution & reports in Jenkins

![Jenkins](ProjectImage/JenkinsConfiguration.png)

---

## 📝 Test Cases Implemented

* **TC001\_AccountRegistrationTest** → Validate account registration
* **TC002\_LoginTest** → Validate login with valid credentials
* **TC003\_DDTLogin** → Validate login with multiple data sets (Excel-driven)

---

## 📌 Future Enhancements

* Integrate with **Allure Reports**
* Add support for **API Testing**
* Enable **Cloud Execution** (BrowserStack/SauceLabs)

---

✨ Author: **Nitin Patil (SDET)**

---

