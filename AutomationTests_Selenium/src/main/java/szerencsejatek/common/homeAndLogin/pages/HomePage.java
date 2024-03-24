package szerencsejatek.common.homeAndLogin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    static Logger log = Logger.getLogger(HomePage.class);
    private final WebDriver driver;

    private final By cookiesAcceptBy = By.id("js-accept-all");
    private final By toLoginAndRegistrationPageButtonBy = By.className("n-header__login-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAllowAllCookieButton() {
        WebElement allowAllCookieButton = driver.findElement(cookiesAcceptBy);
        allowAllCookieButton.click();
        log.info("We click on the \"Osszes engedelyezese\" button");
    }

    public void clickloginAndRegistrationButton() {
        WebElement loginAndRegistrationButton = driver.findElement(toLoginAndRegistrationPageButtonBy);
        loginAndRegistrationButton.click();
        log.info("We click on the \"Belepes es regisztracio\" button");
    }
}
