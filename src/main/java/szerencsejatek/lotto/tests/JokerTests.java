package szerencsejatek.lotto.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.lotto.pages.*;
import szerencsejatek.napiJatekok.pages.KenoPage;
import szerencsejatek.napiJatekok.pages.NapiMazliPage;

import java.util.List;

public class JokerTests extends DriverFactory {

    @Test   //TES-T51
    @Description("Testing the Joker page")
    public void jokerTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);

        //Click on "Összes engedélyezése" button
        homePage.clickOnAllowAllCookieButton();

        //Click on "Belépés és regisztráció" button
        homePage.clickloginAndRegistrationButton();

        //Give valid data and click on "Bejelentkezés" button
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        //Ckecking successful login by asserting the display of the dropdown menu
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton());

        //Click on 'LOTTÓK' menu
        homePageLoggedin.clickOnLottokButton();

        //Click on 'Joker' menu
        homePageLoggedin.clickOnJokerButton();

        //Check if navigation happened to 'Joker' page
        JokerPage jokerPage = new JokerPage(driver, wait);
        Assert.assertTrue(jokerPage.isJokerPageLoaded());

        //Click on the button '1 mező + 1 Joker' under 'Ötöslottó'
        jokerPage.clickOnOneFieldOneJokerOtoslotto();

        /*Check if navigation happened to 'Ötöslottó' page and
         1 Joker game is displayed on the page.*/
        OtosLottoPage otosLottoPage = new OtosLottoPage(driver, wait);
        Assert.assertTrue(otosLottoPage.isOtoslottoPageLoaded());
        Assert.assertTrue(otosLottoPage.isOneJokerGameDisplayed());

        //Click on 'Joker' menu
        otosLottoPage.clickOnJokerButton();

        //Click on the button '1 mező + 1 Joker' under 'Hatoslottó'
        jokerPage.clickOnOneFieldOneJokerHatoslotto();

        /*Check if navigation happened to 'Hatoslottó' page and
         1 Joker game is displayed on the page.*/
        HatosLottoPage hatosLottoPage = new HatosLottoPage(driver, wait);
        Assert.assertTrue(hatosLottoPage.isHatoslottoPageLoaded());
        Assert.assertTrue(hatosLottoPage.isOneJokerGameDisplayed());

        //Click on 'Joker' menu
        hatosLottoPage.clickOnJokerButton();

        //Click on the button '1 mező + 1 Joker' under 'Skandináv lottó'
        jokerPage.clickOnOneFieldOneJokerSkandinavLotto();

        /*Check if navigation happened to 'Skandináv lottó' page and
         1 Joker game is displayed on the page.*/
        SkandinavLottoPage skandinavLottoPage = new SkandinavLottoPage(driver, wait);
        Assert.assertTrue(skandinavLottoPage.isSkandinavLottoPageLoaded());
        Assert.assertTrue(skandinavLottoPage.isOneJokerGameDisplayed());

        //Click on 'Joker' menu
        skandinavLottoPage.clickOnJokerButton();

        //Click on the button '1 mező + 1 Joker' under 'Kenó'
        jokerPage.clickOnOneFieldOneJokerKeno();

        /*Check if navigation happened to 'Kenó' page and
         1 Joker game is displayed on the page.*/
        KenoPage kenoPage = new KenoPage(driver, wait);
        Assert.assertTrue(kenoPage.isKenoPageLoaded());
        Assert.assertTrue(kenoPage.isOneJokerGameDisplayed());

        //Click on 'LOTTÓK' menu
        kenoPage.clickOnLottokButton();

        //Click on 'Joker' menu
        kenoPage.clickOnJokerButton();

        //Click on the button '1 mező + 1 Joker' under 'Napi mázli'
        jokerPage.clickOnOneFieldOneJokerNapiMazli();

        /*Check if navigation happened to 'Napi mázli' page and
         1 Joker game is displayed on the page.*/
        NapiMazliPage napiMazliPage = new NapiMazliPage(driver, wait);
        Assert.assertTrue(napiMazliPage.isNapiMazliPageLoaded());
        Assert.assertTrue(napiMazliPage.isOneJokerGameDisplayed());

        //Click on 'LOTTÓK' menu
        napiMazliPage.clickOnLottokButton();

        //Click on 'Joker' menu
        napiMazliPage.clickOnJokerButton();

        //Click on the button '1 mező + 3 Joker' under 'Eurojackpot'
        jokerPage.clickOnOneFieldThreeJokerEurojackpot();

        /*Check if navigation happened to 'Eurojackpot' page and
         3 Joker game is displayed on the page.*/
        EurojackpotPage eurojackpotPage = new EurojackpotPage(driver, wait);
        Assert.assertTrue(eurojackpotPage.isEurojackpotPageLoaded());
        Assert.assertTrue(eurojackpotPage.areThreeJokerGamesDisplayed());

        //Click on 'Joker' menu
        eurojackpotPage.clickOnJokerButton();

        //Click on the button '2 mező + 1 Joker' under 'Luxor'
        jokerPage.clickOnTwoFieldOneJokerLuxor();

        /*Check if navigation happened to 'Luxor' page and
          1 Joker game is displayed on the page.*/
        LuxorPage luxorPage = new LuxorPage(driver, wait);
        Assert.assertTrue(luxorPage.isLuxorPageLoaded());
        Assert.assertTrue(luxorPage.isOneJokerGameDisplayed());
    }
}
