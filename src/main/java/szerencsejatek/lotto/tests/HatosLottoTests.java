package szerencsejatek.lotto.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.ListenerLogMessages;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import szerencsejatek.common.cart.pages.CartPage;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.lotto.pages.HatosLottoPage;

import java.util.List;

@Listeners(ListenerLogMessages.class)
public class HatosLottoTests extends DriverFactory {
    static Logger log = Logger.getLogger(HatosLottoTests.class);

    @Test   //TES-T37
    @Description("Add normal 'hatoslottó' game to cart)")
    public void normalHatosLottoTest() {
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
        if (homePageLoggedin.isDropDownMenuButton()) {
            log.info("The dropdown menu is available");
        } else {
            log.error("The dropdown menu is unavailable");
        }
        Assert.assertTrue(homePageLoggedin.isDropDownMenuButton());

        //Click on 'LOTTÓK' menu
        homePageLoggedin.clickOnLottokButton();

        //Move cursor above 'Hatoslottó' menu
        homePageLoggedin.hoverOverHatoslottoButton();

        //Click on middle button
        homePageLoggedin.clickOnInvalidSubmitButton();

        //Select 5 numbers
        homePageLoggedin.selectFiveHatosLottoNumbers();

        //Select another number
        homePageLoggedin.selectOneHatosLottoNumber();

        //Try to select another number
        homePageLoggedin.selectInvalidHatosLottoNumber();

        //Click on 'MEGJÁTSZOM' button
        homePageLoggedin.clickOnSubmitButton();

        //Check if navigation happened to 'hatoslotto' page
        HatosLottoPage hatosLottoPage = new HatosLottoPage(driver, wait);
        if (hatosLottoPage.isHatoslottoPageLoaded()) {
            log.info("The Hatoslotto page is available");
        } else {
            log.error("The Hatoslotto page is unavailable");
        }
        Assert.assertTrue(hatosLottoPage.isHatoslottoPageLoaded());

        //Click on the delete button
        hatosLottoPage.clickOnDeleteButton();

        //Click on 'TÖRLÉS' button on the pop-up window.
        hatosLottoPage.clickOnConfirmDeleteButton();

        //Check if 0 numbers are selected
        if (hatosLottoPage.areZeroNumbersSelected()) {
            log.info("We select number is zero");
        } else {
            log.error("The amount of selected numbers is not 0");
        }
        Assert.assertTrue(hatosLottoPage.areZeroNumbersSelected());

        //Click on 'KOSÁRBA' button
        hatosLottoPage.clickOnAddToCartButton();

        //Click on 'BEZÁRÁS' button
        hatosLottoPage.clickOnCloseButton();

        //Select 5 numbers
        hatosLottoPage.selectFiveNormalNumbers();

        //Click on 'KOSÁRBA' button
        hatosLottoPage.clickOnAddToCartButton();

        //Click on 'BEZÁRÁS' button
        hatosLottoPage.clickOnCloseButton();

        //Select another number
        hatosLottoPage.selectOneNumber();

        //Try to select another number
        hatosLottoPage.selectInvalidNumber();

        //Check if 6 numbers are selected
        if (hatosLottoPage.areSixNumbersSelected()) {
            log.info("We selected 6 numbers");
        } else {
            log.error("No 6 numbers are selected");
        }
        Assert.assertTrue(hatosLottoPage.areSixNumbersSelected());

        //Click on 'KOSÁRBA' button
        hatosLottoPage.clickOnAddToCartButton();

        //Check if we are on the cart page,'EGYENLEG BEFIZETÉSE' button is displayed
        CartPage cartPage = new CartPage(driver, wait);
        if (cartPage.isCartPageLoaded()) {
            log.info("The Cart page is available");
        } else {
            log.error("The Cart page is unavailable");
        }
        Assert.assertTrue(cartPage.isCartPageLoaded());
    }
}
