package szerencsejatek.uzletek.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.uzletek.pages.UzletekPage;

import java.util.List;

public class UzletekTests extends DriverFactory {

    @Test(priority = 1) //TES-T29
    @Description("Uzletek Page available searches")
    public void uzletekTestAvailableTests() throws InterruptedException {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        UzletekPage uzletekPage = new UzletekPage(driver, wait);
        uzletekPage.clickShopsButton();
        uzletekPage.filterButton();
        uzletekPage.setAccessibleButton();
        uzletekPage.setBankCardButton();
        uzletekPage.setFoodAndDrinkButton();
    }

    @Test(priority = 2) //TES-T47
    @Description("Uzletek Page search not found")
    public void uzletekTestNotFoundTests() throws InterruptedException {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        UzletekPage uzletekPage = new UzletekPage(driver, wait);
        uzletekPage.clickShopsButton();
        uzletekPage.filterButton();
        uzletekPage.setAccessibleButton();
        uzletekPage.setFoodAndDrinkButton();
        uzletekPage.setBankCardButton();
        uzletekPage.setHorseRacingButton();
        uzletekPage.assertNoSearchCriteriaFound();
    }
}
