package tr.com.flo.sportsstorepof;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class OrderTest {

    private WebDriver driver;
    private  HomePage homePage;

    private OrderPage orderPage;

    @BeforeEach
     public  void setUp(){
        ChromeOptions options= new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage= new HomePage(driver);
        orderPage= new OrderPage(driver);
    }

    @Test
    public void order()
    {
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheckOut();

        orderPage.enterDetails("John Doe", "Main Blv", "5432 Str", "No 5", "Austin,Texas", "TX", "34567", "USA");
        orderPage.submitOrder();

        Assertions.assertEquals(orderPage.getConfirmationText(),"Thanks!");

        orderPage.returnToStore();
    }

}
