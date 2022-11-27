package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdditionalPages {
    private WebDriver driver;

    public AdditionalPages passDeliveryModule(){
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
    public AdditionalPages passAdultCheckModule(){
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
