package szerencsejatek.lotto.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import szerencsejatek.common.cart.pages.CartPage;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.lotto.pages.OtosLottoPage;

import java.util.List;

public class OtosLottoTests extends DriverFactory {

    @Test  // TES-T52
    @Description("Add combination 'ötöslottó' game to cart then delete I.")
    public void combinationOtosLottoTestI() {
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
        //homePageLoggedin.clickOnLottokButton();

        //Click on 'Ötöslottó' menu
        homePageLoggedin.clickOnOtoslottoButton();

        //Check if navigation happened to 'otoslotto' page
        OtosLottoPage otosLottoPage = new OtosLottoPage(driver, wait);
        Assert.assertTrue(otosLottoPage.isOtoslottoPageLoaded());

        //Click on 'KOMBINÁCIÓS JÁTÉK' option
        otosLottoPage.clickOnOtosLottoCombinationGame();

        //Select 6 combination numbers
        otosLottoPage.selectSixCombinationNumbers();

        //Check if 6 combination numbers are selected
        Assert.assertTrue(otosLottoPage.areSixNumbersSelected());

        //Select 5X game type
        otosLottoPage.clickOnFiveXGameType();

        //Click on 'KOSÁRBA' button
        otosLottoPage.clickOnAddToCartButton();

        //Check if we are on the cart page,'EGYENLEG BEFIZETÉSE' button is displayed
        CartPage cartPage = new CartPage(driver, wait);
        Assert.assertTrue(cartPage.isCartPageLoaded());

        //Click on 'KOSÁR ÜRÍTÉSE' button
        cartPage.clickOnEmptyCartButton();

        //Click on 'TÖRLÉS' on the pop-up window
        cartPage.clickOnDeleteButton();

        //Check if the cart is empty
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @Test  // TES-T8
    @Description("Add combination 'ötöslottó' game to cart then delete II.")
    public void combinationOtosLottoTestII() {
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

        //Click on 'Ötöslottó' menu
        homePageLoggedin.clickOnOtoslottoButton();

        //Check if navigation happened to 'otoslotto' page
        OtosLottoPage otosLottoPage = new OtosLottoPage(driver, wait);
        Assert.assertTrue(otosLottoPage.isOtoslottoPageLoaded());

        //Click on 'KOMBINÁCIÓS JÁTÉK' option
        otosLottoPage.clickOnOtosLottoCombinationGame();

        //Select 2 fix numbers
        otosLottoPage.selectTwoFixNumbers();

        //Select 7 combination numbers
        otosLottoPage.selectSevenCombinationNumbers();

        //Check if 9 numbers are selected
        Assert.assertTrue(otosLottoPage.areNineNumbersSelected());

        //Select 5X game type
        otosLottoPage.clickOnFiveXGameType();

        //Click on 'KOSÁRBA' button
        otosLottoPage.clickOnAddToCartButton();

        //Check if we are on the cart page,'EGYENLEG BEFIZETÉSE' button is displayed
        CartPage cartPage = new CartPage(driver, wait);
        Assert.assertTrue(cartPage.isCartPageLoaded());

        //Click on 'KOSÁR ÜRÍTÉSE' button
        cartPage.clickOnEmptyCartButton();

        //Click on 'TÖRLÉS' on the pop-up window
        cartPage.clickOnDeleteButton();

        //Check if the cart is empty
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @Test  // TES-T53
    @Description("Add combination 'ötöslottó' game to cart then delete III.")
    public void combinationOtosLottoTestIII() {
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

        //Click on 'Ötöslottó' menu
        homePageLoggedin.clickOnOtoslottoButton();

        //Check if navigation happened to 'otoslotto' page
        OtosLottoPage otosLottoPage = new OtosLottoPage(driver, wait);
        Assert.assertTrue(otosLottoPage.isOtoslottoPageLoaded());

        //Click on 'KOMBINÁCIÓS JÁTÉK' option
        otosLottoPage.clickOnOtosLottoCombinationGame();

        //Select 3 fix numbers
        otosLottoPage.selectThreeFixNumbers();

        //Select 15 combination numbers
        otosLottoPage.selectFifteenCombinationNumbers();

        //Check if 18 numbers are selected
        Assert.assertTrue(otosLottoPage.areEighteenNumbersSelected());

        //Select 5X game type
        otosLottoPage.clickOnFiveXGameType();

        //Click on 'KOSÁRBA' button
        otosLottoPage.clickOnAddToCartButton();

        //Check if we are on the cart page,'EGYENLEG BEFIZETÉSE' button is displayed
        CartPage cartPage = new CartPage(driver, wait);
        Assert.assertTrue(cartPage.isCartPageLoaded());

        //Click on 'KOSÁR ÜRÍTÉSE' button
        cartPage.clickOnEmptyCartButton();

        //Click on 'TÖRLÉS' on the pop-up window
        cartPage.clickOnDeleteButton();

        //Check if the cart is empty
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
