package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    private final String switchToPickUpButtonLocator = "//button[@class='switcher_option__3NX-U']";
    private final String GlobalSearchLocator = "//input[@name='global-search']";
    private final String CurrentProductLocator = "//*[@href='/product/marmelad-bon-pari-zhevat-kislye-chervyachki-1016587/']";


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public SearchPage openPage(){
        String pageLink = "https://green-dostavka.by/catalog/";
        driver.get(pageLink);
        return this;
    }
    public SearchPage clickGlobalSearch() {
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GlobalSearchLocator)));
        WebElement searchGlobalSearch = driver.findElement(By.xpath(GlobalSearchLocator));
        searchGlobalSearch.click();
        return this;
    }

    public SearchPage passAdultCheckModule(){
        String AdultButtonLocator = "//*[@class = 'button_size-m__pom7w adult-modal_confirm__19Y-E button_btnGreen__VYPVu']";
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AdultButtonLocator)));
        WebElement AdultButton = driver.findElement(By.xpath(AdultButtonLocator));
        AdultButton.click();
        return this;
    }

    public SearchPage searchByKey() {
        WebElement searchGlobalSearch = driver.findElement(By.xpath(GlobalSearchLocator));
        searchGlobalSearch.click();
        searchGlobalSearch.sendKeys("1016587\n");
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CurrentProductLocator)));
        return this;
    }
    public boolean IsCorrectItem(){
        List<WebElement> productItem = driver.findElements(By.xpath(CurrentProductLocator));
        return productItem.size()>0;
    }
    public boolean IsOnlyOneItem(){
        String productItemLocator = "//div[@class='products-list_wrap__1u10W']/child::a";
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(productItemLocator)));
        List<WebElement> productItem = driver.findElements(By.xpath(productItemLocator));
        return productItem.size()==1;
    }
}
