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
import szerencsejatek.lotto.pages.EurojackpotPage;

import java.util.List;

public class EurojackpotTests extends DriverFactory {

    @Test  // TES-T50
    @Description("Add combination 'Eurojackpot' game to cart then delete")
    public void combinationEurojackpotTest() {
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

        //Click on 'Eurojackpot' menu
        homePageLoggedin.clickOnEurojackpotButton();

        //Check if navigation happened to 'Eurojackpot' page
        EurojackpotPage eurojackpotPage = new EurojackpotPage(driver, wait);
        Assert.assertTrue(eurojackpotPage.isEurojackpotPageLoaded());

        //Click on 'KOMBINÁCIÓS JÁTÉK' option
        eurojackpotPage.clickOnEurojackpotCombinationGame();

        //Select 7 A numbers
        eurojackpotPage.selectSevenANumbers();

        //Select 2 B numbers
        eurojackpotPage.selectTwoBNumbers();

        //Check if 9 numbers are selected
        Assert.assertTrue(eurojackpotPage.areNineNumbersSelected());

        //Click on 'KOSÁRBA' button
        eurojackpotPage.clickOnAddToCartButton();

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
