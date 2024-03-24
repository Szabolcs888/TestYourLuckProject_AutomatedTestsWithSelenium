package szerencsejatek.common.homeAndLogin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    static Logger log = Logger.getLogger(LoginPage.class);
    private final WebDriver driver;

    private final By userNameInputBy = By.id("LoginModel_username");
    private final By passwordInputBy = By.id("LoginModel_password");
    private final By loginButtonBy = By.cssSelector("input[ng-disabled='loginByPlayerCard && playerCardLimit']");
    private final By errorTextBy = By.xpath("//*[contains(text(),'Rossz felhasz')]");
    private final By errorText2By = By.xpath("//*[contains(text(),'A felhaszn')]");
    private final By errorText3By = By.xpath("//*[contains(text(),'A jelsz')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginSteps(String userName, String password) {
        WebElement userNameInput = driver.findElement(userNameInputBy);
        userNameInput.sendKeys(userName);
        log.info("We fill the name input field with the '" + userName + "'");
        WebElement passwordInput = driver.findElement(passwordInputBy);
        passwordInput.sendKeys(password);
        log.info("We fill the password input field with the password");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        log.info("We click on the \"Bejelentkezes\" button");
    }

    public WebElement getErrorText() {
        WebElement errorText = driver.findElement(errorTextBy);
        log.info("The error message is displayed: \"Rossz felhasznalonev vagy jelszo!\"");
        return errorText;
    }

    public WebElement getErrorText2() {
        WebElement errorText2 = driver.findElement(errorText2By);
        log.info("The error message is displayed: \"A felhasznalonev tul rovid.\"");
        return errorText2;
    }

    public WebElement getErrorText3() {
        WebElement errorText3 = driver.findElement(errorText3By);
        log.info("The error message is displayed: \"A jelszo mezo ures.\"");
        return errorText3;
    }
}
