package szerencsejatek.fogadasok.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import szerencsejatek.common.cart.pages.CartPage;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.fogadasok.pages.GoltotoPage;

import java.util.List;

public class GoltotoTests extends DriverFactory {

    @Test(priority = 1) //TES-T26
    @Description("Fill out a Goltoto and add it to cart ")
    public void goltotoPageWithCartTest() throws InterruptedException {
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
        homePageLoggedin.clickGolTotoButton();

        GoltotoPage goltotoPage = new GoltotoPage(driver, wait);
        goltotoPage.clickQuicktipButton();
        goltotoPage.chanceOfTwoButton();
        goltotoPage.chanceOfTwoNumberButton();
        goltotoPage.chanceOfThreeButton();
        goltotoPage.chanceOfThreeNumberButton();
        goltotoPage.chanceOfFourButton();
        goltotoPage.chanceOfFourNumberButton();
        goltotoPage.doneButton();
        goltotoPage.cartButton();

        CartPage cartPage = new CartPage(driver, wait);
        cartPage.isCartPageLoaded();
    }

    @Test(priority = 2) //TES-T28
    @Description("Fill out a Goltoto and play it in the lottery ")
    public void goltotoPagePlayItInTheLotteryTest() throws InterruptedException {
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
        homePageLoggedin.clickGolTotoButton();

        GoltotoPage goltotoPage = new GoltotoPage(driver, wait);
        goltotoPage.clickQuicktipButton();
        goltotoPage.chanceOfTwoButton();
        goltotoPage.chanceOfTwoNumberButton();
        goltotoPage.chanceOfThreeButton();
        goltotoPage.chanceOfThreeNumberButton();
        goltotoPage.chanceOfFourButton();
        goltotoPage.chanceOfFourNumberButton();
        goltotoPage.doneButton();
        goltotoPage.inLotteryButton();
    }
}
