# AutomationTestUsingSeleniumAndJava

The project uses Selenium and Java to automate the process of opening an email account and send email with attachment to another email account and then open the second email account and assert receiving the email and download the attachment while having Cross-browser support.

The Architecture of the project is hybrid (Modular and Data-driven) where the code is divided into several packages and modules each with a certain functionality (Modular). The test-data and object identifiers are taken from external Excel Sheet (Data-driven).

TestNG is used to assert that each action was performed successfully and generate reports, sikuli is used to provide desktop support to upload email attachments.

Generating detailed execution status report containing the status of each of the executed steps and the executed test as a whole including screenshots.

# Architecture:
the project consists of several packages:

exists in test output folder
to open , please open index.html file
errrors screenshots exists in reporter output sidebar


# Test Data:
Exists in excel sheet
deal 

utility

consists of two modules:

helper functions used in other modules.

excel utilities to get dynamic data from excel file 

listeners
screenshot listener to listen on the event in case of errors to close the browser

pageobjects modules:

consists of Several Modules, Each include catching objects of an exact page of the project.


scenarios

main script containing test cases to perform the required scenario.


sikuli images:

contains the images required for the desktop tool sikuli to search for different elements and catch them.


Drivers exist inside the project in a folder named drivers however it is better to download the compatible drivers with your own operation sesytem 

# Used Technologies:
Selenium, Java, Sikuli, TestNG

Used IDE:
Eclipse


# How to Run:

run on windows

Open the project in eclipse

update testData Excel file with the required dynamic data

open testng.xml file

run the project


# Reports:

exists in test output folder

to open reports, please open index.html file 

errrors screenshots exists in reporter output sidebar


# Test Data:

dynamic Test Data Exists in excel sheet from which the project reads data




