package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private final String NavQuantityLocator = "//*[@class='nav_quantity__qTiah' and text()=1]";
    private final String OpenCartButton = "//*[@class='cart-wrap_cartIcon__3k7B0 nav_nav__1zZwF']";
    private final String pageLink = "https://green-dostavka.by/product/grudinka-po-derevenski-mestnoe-izvestnoe-1458514/";
    private final String productItem = "//*[@class='cart-product_title__2KPLM']";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public CartPage openCartPage(){
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(OpenCartButton)));
        WebElement CartButton = driver.findElement(By.xpath(OpenCartButton));
        CartButton.click();
        return this;
    }
    public boolean IsItemInCart(){
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(productItem)));
        List<WebElement> ItemInCart = driver.findElements(By.xpath(productItem));
        System.out.println(ItemInCart.size());
        return ItemInCart.size() > 0;
    }

    public boolean IsNavCartQuantityOne(){
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='nav_quantity__qTiah']")));
        List<WebElement> searchNavQuantity = driver.findElements(By.xpath(NavQuantityLocator));
        return searchNavQuantity.size()>0;
    }
    public CartPage passDeliveryModule(){

        String switchToPickUpButtonLocator = "//button[@class='switcher_option__3NX-U']";
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(switchToPickUpButtonLocator)));
        WebElement switchToPickUpButton = driver.findElement(By.xpath(switchToPickUpButtonLocator));
        switchToPickUpButton.click();

        String confirmButtonLocator = "//button[@class='button_size-l__16Rx9 search-group_action__3nBv7 button_btnGreen__VYPVu']";
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(confirmButtonLocator)));
        WebElement searchConfirmButton = driver.findElement(By.xpath(confirmButtonLocator));
        searchConfirmButton.click();
        return this;
    }
}
