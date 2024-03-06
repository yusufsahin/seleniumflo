package tr.com.flo.googlesimplesearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GoogleSearch {
    private WebDriver driver;
    @BeforeEach
    public void setup()
    {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com.tr");
    }
    @Test
    public  void  performSearch() throws InterruptedException {
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.sendKeys("test");
        search.submit();
        Thread.sleep(5000);
        String expectedTitle = "test - Google'da Ara";
        String actualTitle = driver.getTitle();
        System.out.println(driver.getPageSource());
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @AfterEach
    public  void  tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
