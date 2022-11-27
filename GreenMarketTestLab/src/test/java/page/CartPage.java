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

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /* new WebDriverWait(driver, Duration.ofSeconds(50))
         .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='button_size-l__16Rx9 cart-wrap_btn__1KYYA button_btnGreen__VYPVu button_fluid__3nXr3']")));
 WebElement CartButton = driver.findElement(By.xpath("//button[@class='button_size-l__16Rx9 cart-wrap_btn__1KYYA button_btnGreen__VYPVu button_fluid__3nXr3']"));
     CartButton.click();*/
    public CartPage openCartPage(){
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='__next']/div/main/div[2]/aside/div/div/div[1]/div/div[1]/button")));
        WebElement CartButton2 = driver.findElement(By.xpath("//*[@id='__next']/div/main/div[2]/aside/div/div/div[1]/div/div[1]/button"));
        CartButton2.click();
        return this;
    }
    public boolean IsItemInCart(){
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='cart-product_title__2KPLM']")));
        List<WebElement> ItemInCart = driver.findElements(By.xpath("//*[@href='/product/grudinka-po-derevenski-mestnoe-izvestnoe-1458514/']"));
        return ItemInCart.size() == 1;
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
    public CartPage passAdultCheckModule(){
        String AgreementCheckboxLocator = "//input[@class='checkbox_checkbox__3S7PW checkbox_green__2o84P']";
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AgreementCheckboxLocator)));
        WebElement AgreementCheckbox = driver.findElement(By.xpath(AgreementCheckboxLocator));
        AgreementCheckbox.click();
        String WithoutRegistrationButtonLocator = "//button[@class='button_size-l__16Rx9 sign-in-modal_continueBtn__26xN0 button_btnWhite__3vHZO']";
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(WithoutRegistrationButtonLocator)));
        WebElement WithoutRegistrationButton = driver.findElement(By.xpath(WithoutRegistrationButtonLocator));
        WithoutRegistrationButton.click();
        return this;
    }

}
