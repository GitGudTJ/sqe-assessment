package org.naic.tests.cucumber;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        new WebDriverWait(webDriver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        webDriver.findElement(By.id("cui-login")).click();
    }


}
