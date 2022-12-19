package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import page.SearchPage;



public class GreenMarketTest {
    public WebDriver driver = new ChromeDriver();
    @Test
    public void addItemInCart() {
        ProductPage productPage = new ProductPage(driver)
                .openPage()
                .clickAddToCart();
        boolean IsAddButtonRemotedAfterClick = productPage
                .checkIsAddButtonRemoted();
        CartPage cartPage = productPage.closeProductPage();
        boolean IsNumberItemsInCartNavCorrect = cartPage
                .IsNavCartQuantityOne();
        Assert.assertTrue(IsAddButtonRemotedAfterClick && IsNumberItemsInCartNavCorrect, "Adding item to cart is incorrect");
        boolean IsItemsInCart = cartPage
                .passDeliveryModule()
                //.openCartPage()
                .IsItemInCart();
        Assert.assertTrue( IsItemsInCart, "Appearance of item in cart is incorrect");
    }
    @Test
    public void findItemInCart() {
        SearchPage searchPage = new SearchPage(driver)
                .openPage()
                .clickGlobalSearch()
                .passAdultCheckModule()
                .searchByKey();

        Assert.assertTrue( searchPage.IsOnlyOneItem()&& searchPage.IsCorrectItem(), "Search by id is incorrect");
    }
    @AfterTest
    public void browserQuit(){
        driver.quit();
    }
}
