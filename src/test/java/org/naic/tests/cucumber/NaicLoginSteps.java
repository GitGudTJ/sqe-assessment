package org.naic.tests.cucumber;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaicLoginSteps {

    WebDriver webDriver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Given("I navigate to NAIC portal")
    public void iNavigateToNaicPortal() {
        webDriver.get("https://eapps.naic.org/lhub");

        WebDriverWait wait = new WebDriverWait(webDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cui-login")));
        webDriver.findElement(By.id("cui-login")).click();
    }

    @When("I sign in with username {string} and password {string}")
    public void iSignInWithUsernameAndPassword(String username, String password){
        webDriver.findElement(By.id("INT_USERNAME")).sendKeys(username);
        webDriver.findElement(By.id("INT_PASSWORD")).sendKeys(password);
        webDriver.findElement(By.id("INT_LOGIN_BTN")).click();
    }

    @Then("I get the error message {string}")
    public void iGetAnErrorMessage(String message){
        WebElement element = webDriver.findElement(By.id("INT_MESSAGE_WRAPPER"));
        Assert.assertEquals(message,element.getText());
    }


}
