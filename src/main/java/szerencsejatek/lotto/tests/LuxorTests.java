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
import szerencsejatek.lotto.pages.LuxorPage;

import java.util.List;

public class LuxorTests extends DriverFactory {

    @Test  // TES-T54
    @Description("Add 'luxor' game to cart")
    public void luxorTest() {
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

        //Close the pop-up window
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        //homePageLoggedin.closePopUpWindow();

        //Ckecking successful login by asserting the display of the dropdown menu
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton());

        //Click on 'LOTTÓK' menu
        homePageLoggedin.clickOnLottokButton();

        //Click on 'Luxor' menu
        homePageLoggedin.clickOnLuxorButton();

        //Check if navigation happened to 'Luxor' page
        LuxorPage luxorPage = new LuxorPage(driver, wait);
        Assert.assertTrue(luxorPage.isLuxorPageLoaded());

        //Click on 'GYORSTIPP' in the 1st field
        luxorPage.clickOnFirstQuicktip();

        //Try to select another number
        luxorPage.selectInvalidNumberOnFirstField();

        //Click on 'GYORSTIPP' in the 2nd field
        luxorPage.clickOnSecondQuicktip();

        //Try to select another number
        luxorPage.selectInvalidNumberOnSecondField();

        //Click on 'KOSÁRBA' button
        luxorPage.clickOnAddToCartButton();

        //Check if we are on the cart page,'EGYENLEG BEFIZETÉSE' button is displayed
        CartPage cartPage = new CartPage(driver, wait);
        Assert.assertTrue(cartPage.isCartPageLoaded());
    }
}
