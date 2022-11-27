package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private final String pageLink = "https://green-dostavka.by/product/grudinka-po-derevenski-mestnoe-izvestnoe-1458514/";
    private final String AddToCartButtonLocator = "//*[@class='button_size-m__pom7w product-modal_productBtn__BvDQz button_btnGreen__VYPVu']";
    private final String CloseButton = "//*[@class='modal-header_close__3Qb_0']";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openPage(){
        driver.get(pageLink);
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AddToCartButtonLocator)));
        return this;
    }
    public ProductPage clickAddToCart(){
        WebElement AddToCartButton = driver.findElement(By.xpath(AddToCartButtonLocator));
        AddToCartButton.click();
        //new WebDriverWait(driver, Duration.ofSeconds(50))
        //        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='add-remove-product-button_fieldWrap__1KvKJ']")));
        return this;
    }

    public boolean checkIsAddButtonRemoted(){
        List<WebElement> searchAddRemove = driver.findElements(By.xpath("AddToCartButtonLocator"));
        return searchAddRemove.size()==0;
    }

    public CartPage closeProductPage(){
        WebElement searchCloseButton = driver.findElement(By.xpath(CloseButton));
        searchCloseButton.click();
        return new CartPage(driver);
    }

    //List<WebElement> searchAddRemove = driver.findElements(By.xpath("//*[@class='add-remove-product-button_fieldWrap__1KvKJ']"));


}
