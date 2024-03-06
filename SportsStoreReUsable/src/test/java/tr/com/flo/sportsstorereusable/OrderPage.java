package tr.com.flo.sportsstorereusable;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void enterDetais(){
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

    }

    public void submitOrder() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[10]/input")).click();


        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"), "Thanks!"));

        }
        /*
        try {
            String actualText = driver.findElement(By.cssSelector("h2")).getText();
            Assertions.assertEquals(actualText, "Thanks!");

        } catch (AssertionError e) {
            System.out.println("Beklenen metin bulunamadı, sayfa yenileniyor...");
            driver.navigate().refresh();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı, sayfa yenileniyor...");
            driver.navigate().refresh();
        }
        */
    }
        public void returnToStore()
        {
            driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();
        }

    public String getConfirmationText() {

        return  driver.findElement(By.cssSelector("h2")).getText();
    }
}

