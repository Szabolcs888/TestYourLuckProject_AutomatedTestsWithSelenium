package szerencsejatek.sorsjegyek.tests;

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
import szerencsejatek.sorsjegyek.pages.ESorsjegyekPage;
import szerencsejatek.sorsjegyek.pages.SorsjegyekPage;

import java.util.List;

@Listeners(ListenerLogMessages.class)
public class SorsjegyekBasicTests extends DriverFactory {
    static Logger log = Logger.getLogger(SorsjegyekBasicTests.class);

    @Test(priority = 1) //TES-T79
    @Description("Checking arrival at the 'SORSJEGYEK' page by logging in")
    public void navigateToESorsjegyekPageInLoginTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        if (eSorsjegyekPage.getESorsjegyekTitle().isDisplayed()) {
            log.info("The title of the E-sorsjegyek page is displayed");
        } else {
            log.error("The title of the E-sorsjegyek page is not displayed");
        }
        Assert.assertTrue(eSorsjegyekPage.getESorsjegyekTitle().isDisplayed());
        Assert.assertTrue(driver.getPageSource().contains("E-sorsjegyek rendez"));
    }

    @Test(priority = 1) //TES-T80
    @Description("Checking arrival at the 'E-SORSJEGYEK' page without logging in")
    public void navigateToESorsjegyekPageWithoutLoginTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        if (eSorsjegyekPage.getESorsjegyekTitle().isDisplayed()) {
            log.info("The title of the E-sorsjegyek page is displayed");
        } else {
            log.error("The title of the E-sorsjegyek page is not displayed");
        }
        Assert.assertTrue(eSorsjegyekPage.getESorsjegyekTitle().isDisplayed());
        Assert.assertTrue(driver.getPageSource().contains("E-sorsjegyek rendez"));
    }

    @Test(priority = 1) //TES-T81
    @Description("Checking arrival at the 'SORSJEGYEK' page by logging in")
    public void navigateToSorsjegyekPageInLoginTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickSorsjegyButton();

        SorsjegyekPage sorsjegyPage = new SorsjegyekPage(driver);
        if (sorsjegyPage.getSorsjegyekTitle().isDisplayed()) {
            log.info("The title of the Sorsjegyek page is displayed");
        } else {
            log.error("The title of the Sorsjegyek page is not displayed");
        }
        Assert.assertTrue(sorsjegyPage.getSorsjegyekTitle().isDisplayed(), "The title of the Sorsjegyek page is not displayed.");
    }

    @Test(priority = 1) //TES-T82
    @Description("Checking arrival at the 'SORSJEGYEK' page without logging in")
    public void navigateToSorsjegyekPageWithoutLoginTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickSorsjegyButton();

        SorsjegyekPage sorsjegyPage = new SorsjegyekPage(driver);
        if (!sorsjegyPage.getSorsjegyekTitle().isDisplayed()) {
            log.info("The title of the Sorsjegyek page is displayed");
        } else {
            log.error("The title of the Sorsjegyek page is not displayed");
        }
        Assert.assertTrue(sorsjegyPage.getSorsjegyekTitle().isDisplayed());
    }
}
