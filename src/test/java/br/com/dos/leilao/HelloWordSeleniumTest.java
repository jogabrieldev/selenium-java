package br.com.dos.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class HelloWordSeleniumTest {

    @Test
    public void hello(){
        System.setProperty("webdriver.chrome.whitelistedIps" , "");
        System.setProperty("webdriver.chrome.driver" , "drive/chromedriver.exe");
         WebDriver browser = new ChromeDriver();
         browser.navigate().to("http://localhost:8080/leiloes");
        // browser.quit();
    }
}