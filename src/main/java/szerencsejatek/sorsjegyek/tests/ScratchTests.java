package szerencsejatek.sorsjegyek.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.ListenerLogMessages;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.sorsjegyek.pages.*;

import java.util.List;

@Listeners(ListenerLogMessages.class)
public class ScratchTests extends DriverFactory {
    static Logger log = Logger.getLogger(ScratchTests.class);

    @Test(priority = 1) //TES-T72
    @Description("Scratching a 'Black Jack' E-lottery ticket and checking whether the summary message is consistent with the result")
    public void scratchTest() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        eSorsjegyekPage.clickReszletekButtonOnBlackJackETicket();
        BlackJackPrePage blackJackPrePage = new BlackJackPrePage(driver);
        blackJackPrePage.clickProbajatekInditasaButton();

        BlackJackPage blackJackPage = new BlackJackPage(driver);
        blackJackPage.clickKeyButton();
        blackJackPage.scrollWindow();
        blackJackPage.scratchMainGameOnETicket();
        blackJackPage.scratchSideGameOnETicket();
        blackJackPage.clickShowButton();

        boolean isResultMessageValid = blackJackPage.assertResultMessage();
        if (isResultMessageValid)
            log.info("The message text is valid");
        else {
            log.error("The message text is invalid");
        }
        Assert.assertTrue(isResultMessageValid);
    }

    @Test(priority = 2) //TES-T89
    @Description("Scratching a 'Szerencsemalac' E-lottery ticket and checking whether the summary message is consistent with the result")
    public void scratchTest2() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        eSorsjegyekPage.clickReszletekButtonOnSzerencsemalacETicket();
        SzerencsemalacPrePage szerencsemalacPrePage = new SzerencsemalacPrePage(driver);
        szerencsemalacPrePage.clickProbajatekInditasaButton();

        SzerencsemalacPage szerencsemalacPage = new SzerencsemalacPage(driver);
        szerencsemalacPage.scrollWindow();
        szerencsemalacPage.sratchETicket();

        szerencsemalacPage.clickShowButton();
        boolean isResultMessageValid = szerencsemalacPage.assertResultMessage();
        if (isResultMessageValid)
            log.info("The message text is valid");
        else {
            log.error("The message text is invalid");
        }
        Assert.assertTrue(isResultMessageValid);
    }
}
