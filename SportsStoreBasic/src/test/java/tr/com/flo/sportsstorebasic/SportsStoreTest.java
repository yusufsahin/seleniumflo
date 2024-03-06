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
import java.util.NoSuchElementException;

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
    //Home
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

        {
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"),"Check out now"));
        }
    //Order

        //Order Details
        driver.findElement(By.id("Name")).click();
        driver.findElement(By.id("Name")).sendKeys("John Doe");


        driver.findElement(By.id("Line1")).click();
        driver.findElement(By.id("Line1")).sendKeys("ABC Blv. ");

        driver.findElement(By.id("Line2")).click();
        driver.findElement(By.id("Line2")).sendKeys("12436 St.");
       // html body div.row.m-1.p-1 div.col-9 h2
        driver.findElement(By.id("Line3")).click();
        driver.findElement(By.id("Line3")).sendKeys("No 5436");


        driver.findElement(By.name("City")).click();
        driver.findElement(By.name("City")).sendKeys("Austin");


        driver.findElement(By.name("State")).click();
        driver.findElement(By.name("State")).sendKeys("TX");

        driver.findElement(By.name("Zip")).click();
        driver.findElement(By.name("Zip")).sendKeys("56432");

        driver.findElement(By.name("Country")).click();
        driver.findElement(By.name("Country")).sendKeys("USA");

        //Order Details

        //submitOrder
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[10]/input")).click();


        {
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"),"Thanks!"));

        }

        try
        {
            String actualText=driver.findElement(By.cssSelector("h2")).getText();
            Assertions.assertEquals(actualText,"Thanks!");

        }
        catch (AssertionError e){
            System.out.println("Beklenen metin bulunamadı, sayfa yenileniyor...");
            driver.navigate().refresh();
        }
        catch (NoSuchElementException e){
            System.out.println("Element bulunamadı, sayfa yenileniyor...");
            driver.navigate().refresh();
        }
     //Return To store
        driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();

    }


    public  void  tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
