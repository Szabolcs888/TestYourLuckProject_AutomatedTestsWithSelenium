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
import szerencsejatek.lotto.pages.SkandinavLottoPage;

import java.util.List;

public class SkandinavLottoTests extends DriverFactory {

    @Test  // TES-T40
    @Description("Add combination 'skandináv lottó' game to cart then delete")
    public void combinationSkandinavLottoTest() {
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

        //Click on 'Skandináv lottó' menu
        homePageLoggedin.clickOnSkandinavLottoButton();

        //Check if navigation happened to 'Skandináv lottó' page
        SkandinavLottoPage skandinavLottoPage = new SkandinavLottoPage(driver, wait);
        Assert.assertTrue(skandinavLottoPage.isSkandinavLottoPageLoaded());

        //Click on 'KOMBINÁCIÓS JÁTÉK' option
        skandinavLottoPage.clickOnSkandinavLottoCombinationGame();

        //Select 2 fix numbers
        skandinavLottoPage.selectTwoFixNumbers();

        //Select 7 combination numbers
        skandinavLottoPage.selectSevenCombinationNumbers();

        //Check if 9 combination numbers are selected
        Assert.assertTrue(skandinavLottoPage.areNineNumbersSelected());

        //Select 5X game type
        skandinavLottoPage.clickOnFiveXGameType();

        //Click on 'KOSÁRBA' button
        skandinavLottoPage.clickOnAddToCartButton();

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
