package szerencsejatek.sorsjegyek.tests;

import driverFrameworkCore.DriverFactory;
import driverFrameworkCore.utils.ListenerLogMessages;
import driverFrameworkCore.utils.Utils;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import szerencsejatek.common.homeAndLogin.pages.HomePage;
import szerencsejatek.common.homeAndLogin.pages.HomePageLoggedin;
import szerencsejatek.common.homeAndLogin.pages.LoginPage;
import szerencsejatek.sorsjegyek.pages.ESorsjegyekPage;
import szerencsejatek.sorsjegyek.pages.SorsjegyekPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

@Listeners(ListenerLogMessages.class)
public class DropdownMenuTests extends DriverFactory {
    static Logger log = Logger.getLogger(DropdownMenuTests.class);

    // -----'E-SORSJEGYEK' page---- //
    @Test(priority = 1) //TES-T11
    @Description("Checking the correct operation of the dropdown menu by logging in on the E-lottery tickets page (option 'Főnyeremény szerint növekvő')")
    public void expectedOperationOfTheOrderMenuInLoginTestOnESorsjegyekPage() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        // Login
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        // Navigation to the E-lottery tickets page
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        // Select the ascending order by jackpot option
        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        eSorsjegyekPage.clickOrderMenuButton();
        eSorsjegyekPage.clickAscendingPrizeButton();

        // Checking the correct order
        List<Integer> prizeList = eSorsjegyekPage.getItemListAsPrizeForESorjegyPage();
        List<Integer> sortedList = new ArrayList<>(prizeList);
        Collections.sort(sortedList);

        if (prizeList.equals(sortedList)) {
            log.info("The contents of the two lists are identical, the items are in the expected order");
        } else {
            log.error("The contents of the two lists are not identical, the items are not in the expected order");
            eSorsjegyekPage.listsPrint(prizeList, sortedList);
        }
        Assert.assertEquals(prizeList, sortedList);
    }

    @Test(priority = 2) //TES-T87
    @Description("Checking the correct operation of the dropdown menu without logging in on the E-lottery tickets page (option 'Főnyeremény szerint növekvő')")
    public void expectedOperationOfTheOrderMenuWithoutLoginTestOnESorsjegyekPage() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();

        // Navigation to the E-lottery tickets page
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        // Select the ascending order by jackpot option
        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        eSorsjegyekPage.clickOrderMenuButton();
        eSorsjegyekPage.clickAscendingPrizeButton();

        // Checking the correct order
        List<Integer> prizeList = eSorsjegyekPage.getItemListAsPrizeForESorjegyPage();
        List<Integer> sortedList = new ArrayList<>(prizeList);
        Collections.sort(sortedList);

        if (prizeList.equals(sortedList)) {
            log.info("The contents of the two lists are identical, the items are in the expected order");
        } else {
            log.error("The contents of the two lists are not identical, the items are not in the expected order");
            eSorsjegyekPage.listsPrint(prizeList, sortedList);
        }
        Assert.assertEquals(prizeList, sortedList);
    }

    @Test(priority = 3) //TES-T15
    @Description("Checking the correct operation of the dropdown menu without logging in on the E-lottery tickets page (option 'Ár szerint csökkenő')")
    public void expectedOperationOfTheOrderMenuWithoutLoginTestOnESorsjegyekPage2() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();

        // Navigation to the E-lottery tickets page
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickESorsjegyButton();

        // Select the descending order by price option
        ESorsjegyekPage eSorsjegyekPage = new ESorsjegyekPage(driver);
        eSorsjegyekPage.clickOrderMenuButton();
        eSorsjegyekPage.clickDescendingPriceButton();

        // Checking the correct order
        List<Integer> priceList = eSorsjegyekPage.getItemListAsPriceForESorjegyPage();
        List<Integer> sortedList = new ArrayList<>(priceList);
        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        if (priceList.equals(sortedList)) {
            log.info("The contents of the two lists are identical, the items are in the expected order");
        } else {
            log.error("The contents of the two lists are not identical, the items are not in the expected order");
            eSorsjegyekPage.listsPrint(priceList, sortedList);
        }
        Assert.assertEquals(priceList, sortedList);
    }


    // -----'SORSJEGYEK' page---- //
    @Test(priority = 4) //TES-T12
    @Description("Checking the correct operation of the dropdown menu by logging in on the Lottery tickets page (option 'Ár szerint növekvő')")
    public void expectedOperationOfTheOrderMenuInLoginTestOnSorsjegyekPage() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();
        homePage.clickloginAndRegistrationButton();

        // Login
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSteps(datas.get(0), datas.get(1));

        // Navigation to the Lottery tickets page
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickSorsjegyButton();

        // Select the ascending order by price option
        SorsjegyekPage sorsjegyekPage = new SorsjegyekPage(driver);
        sorsjegyekPage.clickOrderMenuButton();
        sorsjegyekPage.clickAscendingPriceButton();

        // Checking the correct order
        List<Integer> priceList = sorsjegyekPage.getItemListAsPriceForSorjegyPage();
        List<Integer> sortedList = new ArrayList<>(priceList);
        Collections.sort(sortedList);

        if (priceList.equals(sortedList)) {
            log.info("The contents of the two lists are identical, the items are in the expected order");
        } else {
            log.error("The contents of the two lists are not identical, the items are not in the expected order");
            sorsjegyekPage.listsPrint(priceList, sortedList);
        }
        Assert.assertEquals(priceList, sortedList);
    }

    @Test(priority = 5) //TES-T88
    @Description("Checking the correct operation of the dropdown menu without logging in on the Lottery tickets page (option 'Ár szerint növekvő')")
    public void expectedOperationOfTheOrderMenuWithoutLoginTestOnSorsjegyekPage() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();

        // Navigation to the Lottery tickets page
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickSorsjegyButton();
        homePageLoggedin.clickSorsjegyButton();

        // Select the ascending order by price option
        SorsjegyekPage sorsjegyekPage = new SorsjegyekPage(driver);
        sorsjegyekPage.clickOrderMenuButton();
        sorsjegyekPage.clickAscendingPriceButton();

        // Checking the correct order
        List<Integer> priceList = sorsjegyekPage.getItemListAsPriceForSorjegyPage();
        List<Integer> sortedList = new ArrayList<>(priceList);
        Collections.sort(sortedList);

        if (priceList.equals(sortedList)) {
            log.info("The contents of the two lists are identical, the items are in the expected order");
        } else {
            log.error("The contents of the two lists are not identical, the items are not in the expected order");
            sorsjegyekPage.listsPrint(priceList, sortedList);
        }
        Assert.assertEquals(priceList, sortedList);
    }

    @Test(priority = 6) //TES-T16
    @Description("Checking the correct operation of the dropdown menu without logging in on the Lottery tickets page (option 'Főnyeremény szerint csökkenő')")
    public void expectedOperationOfTheOrderMenuWithoutLoginTestOnSorsjegyekPage2() {
        driver.get("https://www.szerencsejatek.hu/");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAllowAllCookieButton();

        // Navigation to the Lottery tickets page
        HomePageLoggedin homePageLoggedin = new HomePageLoggedin(driver, wait);
        homePageLoggedin.clickOnSorsjegyekButton();
        homePageLoggedin.clickSorsjegyButton();

        // Select the descending order by jackpot option
        SorsjegyekPage sorsjegyekPage = new SorsjegyekPage(driver);
        sorsjegyekPage.clickOrderMenuButton();
        sorsjegyekPage.clickDescendingPrizeButton();

        // Checking the correct order
        List<Integer> prizeList = sorsjegyekPage.getItemListAsPrizeForSorjegyPage();
        List<Integer> sortedList = new ArrayList<>(prizeList);
        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        if (prizeList.equals(sortedList)) {
            log.info("The contents of the two lists are identical, the items are in the expected order");
        } else {
            log.error("The contents of the two lists are not identical, the items are not in the expected order");
            sorsjegyekPage.listsPrint(prizeList, sortedList);
        }
        Assert.assertEquals(prizeList, sortedList);
    }
}
