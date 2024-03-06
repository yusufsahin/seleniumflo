package tr.com.flo.googlesearchscreenshot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com.tr/");


    }


    @Test
    public  void search() throws IOException {
        WebElement searchField= driver.findElement(By.name("q"));

        searchField.sendKeys("flo");

        searchField.submit();

        takeScreenShot("screenshot_after_search.png");
    }

    private void takeScreenShot(String image) throws IOException {


        TakesScreenshot screenshotTaker= (TakesScreenshot) driver;

        File screenshotFile= screenshotTaker.getScreenshotAs(OutputType.FILE);

        File destinationFile= new File("src/test/resources/"+ image);

        Files.copy(screenshotFile.toPath(),destinationFile.toPath());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
