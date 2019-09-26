package org.naic.tests.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NaicLinksTest {

    WebDriver webDriver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @Test
    public void naicSuperMenuLinksTest(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.get("https://www.naic.org");

        WebElement superMenuElement = webDriver.findElement(By.id("super_menu"));

        Assert.assertNotNull("super_menu element not found!",superMenuElement);
        List<WebElement> superMenuLinks = superMenuElement.findElements(By.xpath("//*[@id=\"super_menu\"]/div/a[@aria-haspopup='true']"));

        Assert.assertEquals(7, superMenuLinks.size());

        for(WebElement element : superMenuLinks){
            Assert.assertTrue(element.getText() + " link Does Not Contain https://www.naic.org!", element.getAttribute("href").contains("https://www.naic.org"));
        }

        webDriver.quit();
    }
}
