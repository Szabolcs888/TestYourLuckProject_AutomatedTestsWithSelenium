package szerencsejatek.common.cart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    static Logger log = Logger.getLogger(CartPage.class);

    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By emptyCartButtonBy = By.cssSelector("a[class='pull-right delete with-text']");
    private final By deleteButtonBy = By.cssSelector("button[class='n-btn n-btn--confirm btn btn-green btn-block ng-binding']");
    private final By paymentBalanceButtonBy = By.cssSelector("a[class='button button-orange block link-cover']");
    private final By cartIsEmptyTextBy = By.xpath("/html/body/div/div[3]/div/div/div[2]/h2");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickOnEmptyCartButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement emptyCartButton = driver.findElement(emptyCartButtonBy);
        emptyCartButton.click();
        log.info("We click on the \"Kosar uritese\" button");
    }

    public void clickOnDeleteButton() {
        WebElement deleteButton = driver.findElement(deleteButtonBy);
        deleteButton.click();
        log.info("We click on the \"Torles\" button");
    }

    public boolean isCartPageLoaded() {
        WebElement paymentBalanceButton = driver.findElement(paymentBalanceButtonBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/kosar") && paymentBalanceButton.isDisplayed();
        log.info("We check if the cart page is loaded");
        return isLoaded;
    }

    public boolean isCartEmpty() {
        System.out.println(className + ": We check if the cart is empty");
        WebElement cartIsEmptyText = driver.findElement(cartIsEmptyTextBy);
        boolean isCartEmpty = cartIsEmptyText.isDisplayed();
        return isCartEmpty;
    }
}