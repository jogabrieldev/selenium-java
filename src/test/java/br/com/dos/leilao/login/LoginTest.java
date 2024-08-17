package br.com.dos.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
   private WebDriver browser;
   private  static final String URL_LOGIN = "http://localhost:8080/login";
    @BeforeAll
    public static void beforeall(){
        System.setProperty("webdriver.chrome.whitelistedIps" , "");
        System.setProperty("webdriver.chrome.driver" , "drive/chromedriver.exe");

    }
    @BeforeEach
    public void beforeEach(){

       this.browser = new ChromeDriver();
    }
    @AfterEach
     public void exitAplication(){
        this.browser.quit();
    }
    @Test
    public void DeveriaEfetuarLoginComDados(){

        this.browser.navigate().to(URL_LOGIN);
        this.browser.findElement(By.id("username")).sendKeys("fulano");
        this.browser.findElement(By.id("password")).sendKeys("pass");
        this.browser.findElement(By.id("login-form")).submit();


        Assert.assertFalse(this.browser.getCurrentUrl().equals(URL_LOGIN));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

    }
     @Test
    public void naoDeveriaLogarComDadosInvalidos(){

        this.browser.navigate().to(URL_LOGIN);
        this.browser.findElement(By.id("username")).sendKeys("fulano");
        this.browser.findElement(By.id("password")).sendKeys("pass");
        this.browser.findElement(By.id("login-form")).submit();


        Assert.assertTrue(this.browser.getCurrentUrl().equals(URL_LOGIN));
        Assert.assertTrue("fulano", this.browser.getPageSource().contains("Usuario e senha invalido"));
        Assert.assertThrows( NoSuchElementException.class,()->  this.browser.findElement(By.id("usuario_logado")));

    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemLogar(){
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
        Assert.assertTrue(this.browser.getCurrentUrl().equals((URL_LOGIN)));
        Assert.assertFalse(this.browser.getPageSource().contains("Dados do Leilão"));
    }
}
