package szerencsejatek.common.homeAndLogin.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.ListenerLogMessages;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;

import java.util.List;

@Listeners(ListenerLogMessages.class)
public class LoginTests extends DriverFactory {
    static Logger log = Logger.getLogger(LoginTests.class);

    @Test(priority = 1) //TES-T1
    @Description("The user enters correct data and clicks the login button.)")
    public void loginWithValidDataTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);

        // Pressing the "Összes engedélyezése" button
        homePage.clickOnAllowAllCookieButton();

        // Pressing the "Belépés és regisztráció" button
        homePage.clickloginAndRegistrationButton();

        // Entering valid data and pressing the "Bejelentkezés" button
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        // Verification of successful login by asserting the appearance of the drop-down menu icon
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        if (!homePageLoggedin.isDropDownMenuButton()) {
            log.error("Login failed");
        }
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton(), "The dropdown menu is unavailable.");
    }

    @Test(priority = 2) //TES-T3
    @Description("The user enters invalid username, valid password and clicks the login button.)")
    public void loginWithInvalidUsernameValidPassword() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        // Entering invalid data and pressing the "Bejelentkezés" button
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps("invalid_username", datas.get(1));

        // Verification of failed login by asserting the appearance of the drop-down menu icon and error message
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        if (loginPage.getErrorText().isDisplayed()) {
            log.info("The error message is correct.");
        } else {
            log.error("The error text does not appear");
        }
        Assert.assertFalse(homePageLoggedin.isDropDownMenuButton());
        Assert.assertTrue(loginPage.getErrorText().isDisplayed());
    }

    @Test(priority = 3) //TES-T4
    @Description("The user enters valid username, invalid password and clicks the login button.)")
    public void loginWithValidUsernameInvalidPassword() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        // Entering invalid data and pressing the "Bejelentkezés" button
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), "invalid_password");

        // Verification of failed login by asserting the appearance of the drop-down menu icon and error message
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        if (loginPage.getErrorText().isDisplayed()) {
            log.info("The error message is correct.");
        } else {
            log.error("The error text does not appear");
        }
        Assert.assertFalse(homePageLoggedin.isDropDownMenuButton());
        Assert.assertTrue(loginPage.getErrorText().isDisplayed());
    }

    @Test(priority = 4) //TES-T5
    @Description("The user leaves empty the username field, and writes valid password and clicks the login button.)")
    public void loginWithLeavedTheUsernameFieldEmptyAndValidPassword() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        // Entering invalid data and pressing the "Bejelentkezés" button
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps("", datas.get(1));

        // Verification of failed login by asserting the appearance of the drop-down menu icon and error message
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        if (loginPage.getErrorText2().isDisplayed()) {
            log.info("The error message is correct.");
        } else {
            log.error("The error text does not appear");
        }
        Assert.assertFalse(homePageLoggedin.isDropDownMenuButton());
        Assert.assertTrue(loginPage.getErrorText2().isDisplayed());
    }

    @Test(priority = 5) //TES-T6
    @Description("The user enters valid username, and leaves empty the password field and clicks the login button.)")
    public void loginWithValidUsernameAndLeavedThePasswordFieldEmpty() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        // Entering invalid data and pressing the "Bejelentkezés" button
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), "");

        // Verification of failed login by asserting the appearance of the drop-down menu icon and error message
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        if (loginPage.getErrorText3().isDisplayed()) {
            log.info("The error message is correct.");
        } else {
            log.error("The error text does not appear");
        }
        Assert.assertFalse(homePageLoggedin.isDropDownMenuButton());
        Assert.assertTrue(loginPage.getErrorText3().isDisplayed());
    }
}
