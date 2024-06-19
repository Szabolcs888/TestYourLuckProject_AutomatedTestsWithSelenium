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
import szerencsejatek.napiJatekok.pages.PuttoPage;

import java.util.List;

public class PuttoTests extends DriverFactory {

    @Test //TES-T84
    @Description("Add normal 'puttó' game to cart ")
    public void testPuttoGame1() {
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

        //Click on 'Puttó' menu
        homePageLoggedin.clickOnPuttoButton();

        //Check if navigation happened to 'Puttó' page
        PuttoPage puttoPage = new PuttoPage(driver, wait);
        Assert.assertTrue(puttoPage.isPuttoPageLoaded());

        //Select stake amount
        puttoPage.selectStakeAmount(0);

        // Select 8 numbers for Field A
        puttoPage.selectEightNumbersForFieldA();

        // Select 1 number for Field B
        puttoPage.selectOneNumberForFieldB();

        // Check if numbers are selected correctly in A
        Assert.assertTrue(puttoPage.areNumbersSelected());

        //Click on 'KOSÁRBA' button
        puttoPage.clickOnAddToCartButton();

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

    @Test
    @Description("Add normal 'puttó' game to cart with insuficient numbers ")
    public void testPuttoGame2() {
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

        //Click on 'Puttó' menu
        homePageLoggedin.clickOnPuttoButton();

        //Check if navigation happened to 'Puttó' page
        PuttoPage puttoPage = new PuttoPage(driver, wait);
        Assert.assertTrue(puttoPage.isPuttoPageLoaded());

        //Select stake amount
        puttoPage.selectStakeAmount(1);

        // Select 7 numbers for Field A
        puttoPage.selectSevenNumbersForFieldA();

        // Select 1 number for Field B
        puttoPage.selectOneNumberForFieldB();

        //Click on 'KOSÁRBA' button
        puttoPage.clickOnAddToCartButton();

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

    @Test
    @Description("Add normal 'puttó' game to cart without selecting number in Field B")
    public void testPuttoGame3() {
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

        //Click on 'Puttó' menu
        homePageLoggedin.clickOnPuttoButton();

        //Check if navigation happened to 'Puttó' page
        PuttoPage puttoPage = new PuttoPage(driver, wait);
        Assert.assertTrue(puttoPage.isPuttoPageLoaded());

        //Select stake amount
        puttoPage.selectStakeAmount(1);

        // Select 8 numbers for Field A
        puttoPage.selectEightNumbersForFieldA();

        //Click on 'KOSÁRBA' button
        puttoPage.clickOnAddToCartButton();

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

    @Test
    @Description("Add normal 'puttó' game to cart without selecting stake")
    public void testPuttoGame4() {
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

        //Click on 'Puttó' menu
        homePageLoggedin.clickOnPuttoButton();

        //Check if navigation happened to 'Puttó' page
        PuttoPage puttoPage = new PuttoPage(driver, wait);
        Assert.assertTrue(puttoPage.isPuttoPageLoaded());

        //Select stake amount
        puttoPage.selectStakeAmount(1);

        // Select 8 numbers for Field A
        puttoPage.selectEightNumbersForFieldA();

        // Check if numbers are selected correctly
        Assert.assertTrue(puttoPage.areNumbersSelected());

        //Click on 'KOSÁRBA' button
        puttoPage.clickOnAddToCartButton();

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

    @Test
    @Description("Add normal 'puttó' game to cart without selecting stake")
    public void testPuttoGame5() {
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

        //Click on 'Puttó' menu
        homePageLoggedin.clickOnPuttoButton();

        //Check if navigation happened to 'Puttó' page
        PuttoPage puttoPage = new PuttoPage(driver, wait);
        Assert.assertTrue(puttoPage.isPuttoPageLoaded());

        // Select 8 numbers for Field A
        puttoPage.selectEightNumbersForFieldA();

        // Select 1 number for Field B
        puttoPage.selectOneNumberForFieldB();

        // Check if numbers are selected correctly
        Assert.assertTrue(puttoPage.areNumbersSelected());

        //Click on 'KOSÁRBA' button
        puttoPage.clickOnAddToCartButton();

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