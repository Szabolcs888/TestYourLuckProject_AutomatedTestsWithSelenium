package szerencsejatek.napiJatekok.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import szerencsejatek.common.cart.pages.CartPage;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.napiJatekok.pages.KenoPage;

import java.util.List;

public class KenoTests extends DriverFactory {

    @Test //TES-T83
    @Description("Add normal 'kenó' game to cart ")
    public void normalKenoGameTest1() {
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

        //Checking successful login by asserting the display of the dropdown menu
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton());

        //Click on 'Napi Játékok' menu
        homePageLoggedin.clickOnNapiJatekokButton();

        //Click on 'KENÓ' menu
        homePageLoggedin.clickOnKenoButton();

        //Check if navigation happened to 'kenó' page
        KenoPage kenoPage = new KenoPage(driver, wait);
        Assert.assertTrue(kenoPage.isKenoPageLoaded());

        //Select game type
        kenoPage.setSelectGameType(4);

        //Select stake amount
        kenoPage.selectStakeAmount(1);

        //Select 5 numbers
        kenoPage.selectFiveNumbers();

        // Check if numbers are selected correctly
        Assert.assertTrue(kenoPage.areFiveNumbersSelected());

        //Click on 'KOSÁRBA' button
        kenoPage.clickOnAddToCartButton();

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

    @Test //TES-T90
    @Description("Add normal 'kenó' game to cart with less numbers than the game type")
    public void normalKenoGameTest2() {
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

        //Checking successful login by asserting the display of the dropdown menu
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton());

        //Click on 'Napi Játékok' menu
        homePageLoggedin.clickOnNapiJatekokButton();

        //Click on 'KENÓ' menu
        homePageLoggedin.clickOnKenoButton();

        //Check if navigation happened to 'kenó' page
        KenoPage kenoPage = new KenoPage(driver, wait);
        Assert.assertTrue(kenoPage.isKenoPageLoaded());

        //Selct game type
        kenoPage.setSelectGameType(7);

        //Select stake amount
        kenoPage.selectStakeAmount(1);

        //Select 5 numbers
        kenoPage.selectFiveNumbers();

        //Check if 5 numbers are selected
        Assert.assertTrue(kenoPage.areFiveNumbersSelected());

        //Click on 'KOSÁRBA' button
        kenoPage.clickOnAddToCartButton();

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

    @Test //TES-T90
    @Description("Add normal 'kenó' game without selecting stake")
    public void normalKenoGameTest3() {
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

        //Checking successful login by asserting the display of the dropdown menu
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton());

        //Click on 'Napi Játékok' menu
        homePageLoggedin.clickOnNapiJatekokButton();

        //Click on 'KENÓ' menu
        homePageLoggedin.clickOnKenoButton();

        //Check if navigation happened to 'kenó' page
        KenoPage kenoPage = new KenoPage(driver, wait);
        Assert.assertTrue(kenoPage.isKenoPageLoaded());

        //Selcet game type
        kenoPage.setSelectGameType(9);

        //Select 10 numbers
        kenoPage.selectTenNumbers();

        //Check if 10 numbers are selected
        Assert.assertTrue(kenoPage.areTenNumbersSelected());

        //Click on 'KOSÁRBA' button
        kenoPage.clickOnAddToCartButton();

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

