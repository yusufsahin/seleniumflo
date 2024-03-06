package tr.com.flo.sportsstorebasic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SportsStoreTest {
    private WebDriver driver;

    @BeforeEach
    public void  setup(){

        ChromeOptions options= new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
    }

    @Test
    public void sportStoreE2E() throws InterruptedException {

        driver.findElement(By.linkText("Home")).click();
        {
            List<WebElement> elements =  driver.findElements(By.cssSelector(".card:nth-child(1) h4"));
            Assertions.assertTrue(elements.size()>0);
        }

        {
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBe( By.xpath("/html/body/div[2]/div[2]/div[1]/div/h4/span/small"),"$275.00"));
        }
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

    }


    public  void  tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
