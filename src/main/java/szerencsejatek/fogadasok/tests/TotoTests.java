package szerencsejatek.fogadasok.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import szerencsejatek.common.cart.pages.CartPage;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.fogadasok.pages.TotoPage;

import java.util.List;

public class TotoTests extends DriverFactory {

    @Test(priority = 1) //TES-T17
    @Description("Fill out the combined toto and add it to the cart")
    public void totopageWithCartTest() throws InterruptedException {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickFogadasokButton();
        homePageLoggedin.clickTotoButton();

        TotoPage totoPage = new TotoPage(driver, wait);
        totoPage.combinationButton();
        totoPage.quicktipButton();
        totoPage.chanceOfThreeButton();
        totoPage.chanceOfThreeNumberButton();
        totoPage.clickDoneButton();
        totoPage.cartButton();

        CartPage cartPage = new CartPage(driver, wait);
        cartPage.isCartPageLoaded();
    }

    @Test(priority = 2) //TES-T27
    @Description("Fill out the combined toto and play in the lottery")
    public void totopageInLotteryTest() throws InterruptedException {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickFogadasokButton();
        homePageLoggedin.clickTotoButton();

        TotoPage totoPage = new TotoPage(driver, wait);
        totoPage.combinationButton();
        totoPage.quicktipButton();
        totoPage.chanceOfThreeButton();
        totoPage.chanceOfThreeNumberButton();
        totoPage.clickDoneButton();
        totoPage.inLotteryButton();
    }
}

