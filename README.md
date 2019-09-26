# Software Quality Engineer III Automation Assessment

## Instructions
Complete the following tasks and then check in the project to Gitlab, Github, or Bitbucket and send the link to your repository to the designated recruiter and/or interviewer.

*A stretch goal would be integrate these tests in a CI solution like gitlab-ci, travis-ci or Jenkins.*

Pleaser report to the recuiter and/or interviewer approximately how nuch time was devoted to the submitted solution.

## General Java Requirements
* Package name should start with org.naic.<lastname>
* Tests should be in the test folder

## Java Selenium 
### Business Requirements
On the page https://www.naic.org 
* Ensure there is an element with the **id** of *super_menu* 
* Ensure within the above element there are 6 links
* With those 6 links check each one to ensure it starts with https://www.naic.org
    * If it does not, fail the test and list the link

### Technology Requirements
* Must use the following technologies
    * Java 8+
    * JUnit
    * Selenium Java API
    * Maven
* Use Chrome and/or Edge for browser


## BDD Feature File and Tests
### Business Requirements
Write a feature file in Gherkin for the NAIC Login page to test an invalid username and password.
* https://eapps.naic.org/lhub and click on the Login button to see the Login screen
    
Write a Cucumber Unit test exercising the new feature file.  


### Technology Requirements
* Must use the following technologies
    * Cucumber/Gherkin
    * JUnit
    * Java 8+
    * Maven

## REST API Testing
### Business Requirements
Using https://petstore.swagger.io develop a test to ensure that the response code is 200 and there are more than 1 values returned on the */pet/findByStatus* GET endpoint
### Technology Requirements
* Use the following technologies
    * Rest Assured
    * Maven
    * Java 8+
    * JUnit