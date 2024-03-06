package tr.com.flo.sportsstorepof;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Home")
    private WebElement menuCategory;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath ="/html/body/div[2]/div/a[2]" )
    private WebElement checkOutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectProduct()
    {
        menuCategory.click();
    }

    public void addToCart()
    {
        addToCartButton.click();
    }

    public void goToCheckOut()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkOutButton.click();
    }

}
