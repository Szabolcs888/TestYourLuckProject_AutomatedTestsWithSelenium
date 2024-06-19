package szerencsejatek.common.homeAndLogin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class HomePageLoggedin {
    static Logger log = Logger.getLogger(HomePageLoggedin.class);

    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By lottokButtonBy = By.cssSelector("li[data-id='3']");
    private final By otoslottoButtonBy = By.cssSelector("li[data-id='4']");
    private final By hatoslottoButtonBy = By.cssSelector("li[data-id='6']");
    private final By invalidSubmitButtonBy = By.cssSelector("button[class='n-btn n-btn__secondary n-btn__secondary--lg n-btn--no-icon-margin n-home-hero__betslip__invalid-submit ng-scope']");
    private final By submitButtonBy = By.cssSelector("button[class='n-btn n-btn__secondary n-btn__secondary--lg n-btn--no-icon-margin n-btn--uppercase n-home-hero__betslip__submit ng-scope']");
    private final By allNumbersBy = By.cssSelector("button[class='n-home-hero__balls__button ng-binding']");
    private final By hatoslottoNumberBy = By.xpath("/html/body/div[1]/div[1]/section/div[2]/div/div[2]/div[2]/ul[1]/li[39]/button");
    private final By invalidHatosLottoNumberBy = By.xpath("/html/body/div[1]/div[1]/section/div[2]/div/div[2]/div[2]/ul[1]/li[1]/button");
    private final By dropDownMenuButtonBy = By.className("n-header__user__dropdown-opener__icon");
    private final By sorsjegyekButtonBy = By.cssSelector("li[ng-click='upperMenu.toggle(2)']");
    private final By eSorsjegyButtonBy = By.cssSelector("li[data-id='9']");
    private final By sorsjegyButtonBy = By.cssSelector("li[data-id='11']");
    private final By jokerButtonBy = By.xpath("/html/body/div/div[1]/nav/div[2]/div/div/ul[1]/li[6]/a");
    private final By skandinavLottoButtonBy = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div/div/ul[1]/li[3]");
    private final By eurojackpotButtonBy = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div/div/ul[1]/li[4]");
    private final By luxorButtonBy = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div/div/ul[1]/li[5]");
    private final By closeButtonBy = By.cssSelector("a[class='sas-popup__close-overlay']");
    private final By fogadasokButtonBy = By.cssSelector("li[ng-click='upperMenu.toggle(3)']");
    private final By totoButtonBy = By.cssSelector("li[data-id='20']");
    private final By goltotoButtonBy = By.cssSelector("li[data-id='22']");
    private final By kenoButtonBy = By.cssSelector("li[data-id='2']");
    private final By puttoButtonBy = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div/div/ul[2]/li[2]/a/div[1]");
    private final By napiMazliButtonBy = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div/div/ul[2]/li[3]/a");
    private final By napiJatekokButtonBy = By.cssSelector("li[ng-click='upperMenu.toggle(1)']");

    public HomePageLoggedin(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isDropDownMenuButton() {
        boolean isExistDropMenu = false;
        try {
            WebElement dropDownMenu = driver.findElement(dropDownMenuButtonBy);
            isExistDropMenu = dropDownMenu.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isExistDropMenu;
    }

    ///--- Lottók page-re való kattintás metódusai ---///
    public void clickOnLottokButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lottokButtonBy));
        WebElement lottokButton = driver.findElement(lottokButtonBy);
        try {
            lottokButton.click();
            log.info("We click on the \"LOTTOK\" menu button");
        } catch (Exception e) {
            log.info("We couldn't click on the \"LOTTOK\" menu button");
        }
    }

    public void clickOnOtoslottoButton() {
        WebElement otoslottoButton = driver.findElement(otoslottoButtonBy);
        otoslottoButton.click();
        System.out.println(className + ": We click on the \"Ötöslottó\" menu button");
    }

    public void hoverOverHatoslottoButton() {
        WebElement hatoslottoButton = driver.findElement(hatoslottoButtonBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(hatoslottoButton).build().perform();
        log.info("We move the cursor over the \"Hatoslotto\" menu button");
    }

    public void clickOnInvalidSubmitButton() {
        WebElement invalidSubmitButton = driver.findElement(invalidSubmitButtonBy);
        try {
            invalidSubmitButton.click();
            log.info("We click on the middle submit button");
        } catch (Exception e) {
            log.info("We try to click on middle button but it is not clickable");
        }
    }

    public void selectFiveHatosLottoNumbers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allNumbers = driver.findElements(allNumbersBy);
        List<WebElement> hatosLottoNumbers = Arrays.asList(allNumbers.get(91), allNumbers.get(110), allNumbers.get(111), allNumbers.get(120), allNumbers.get(125));
        for (WebElement number : hatosLottoNumbers) {
            number.click();
        }
        log.info("We select five numbers");
    }

    public void selectOneHatosLottoNumber() {
        WebElement hatoslottoNumber = driver.findElement(hatoslottoNumberBy);
        hatoslottoNumber.click();
        log.info("We select another number");
    }

    public void selectInvalidHatosLottoNumber() {
        WebElement invalidHatosLottoNumber = driver.findElement(invalidHatosLottoNumberBy);
        try {
            invalidHatosLottoNumber.click();
            log.info("We try to select another number");

        } catch (Exception e) {
            log.info("We try to select another number but it is not clickable");
        }
    }

    public void clickOnSubmitButton() {
        WebElement submitButton = driver.findElement(submitButtonBy);
        submitButton.click();
        log.info("We click on the middle submit button");
    }

    public void clickOnJokerButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement jokerButton = driver.findElement(jokerButtonBy);
        jokerButton.click();
        System.out.println(className + ": We click on the \"Joker\" menu button");
    }

    public void clickOnSkandinavLottoButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement skandinavLottoButton = driver.findElement(skandinavLottoButtonBy);
        try {
            skandinavLottoButton.click();
            System.out.println(className + ": We click on the \"Skandináv lottó\" menu button");
        } catch (Exception e) {
            System.out.println(className + ": We couldn't click on the \"Skandináv lottó\" menu button.");
        }
    }

    public void clickOnEurojackpotButton() {
        WebElement eurojackpotButton = driver.findElement(eurojackpotButtonBy);
        eurojackpotButton.click();
        System.out.println(className + ": We click on the \"Eurojackpot\" menu button");
    }

    public void clickOnLuxorButton() {
        WebElement luxorButton = driver.findElement(luxorButtonBy);
        luxorButton.click();
        System.out.println(className + ": We click on the \"Luxor\" menu button");
    }

    ///--- Sorsjegyek page-re való kattintás metódusai ---///
    public void clickOnSorsjegyekButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement sorsjegyekButton = driver.findElement(sorsjegyekButtonBy);
        sorsjegyekButton.click();
        log.info("We click on the \"SORSJEGYEK\" button");
    }

    public void clickESorsjegyButton() {
        WebElement eSorsjegyekButton = driver.findElement(eSorsjegyButtonBy);
        eSorsjegyekButton.click();
        log.info("We click on the \"E-sorsjegy\" button");
    }

    public void clickSorsjegyButton() {
        WebElement sorsjegyekButton = driver.findElement(sorsjegyButtonBy);
        sorsjegyekButton.click();
        log.info("We click on the \"Sorsjegy\" button");
    }

    public void closePopUpWindow() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement closeButton = driver.findElement(closeButtonBy);
        closeButton.click();
        System.out.println(className + ": We click on the 'X' button on the pop-up window");
    }

    public void clickFogadasokButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement fogadasokButton = driver.findElement(fogadasokButtonBy);
        fogadasokButton.click();
        System.out.println(className + ": We click on the \"Fogadasok\" button");
    }

    public void clickTotoButton() {
        WebElement totoButton = driver.findElement(totoButtonBy);
        totoButton.click();
        System.out.println(className + ": We click on the \"Toto\" button");
    }

    public void clickGolTotoButton() {
        WebElement goltotoButton = driver.findElement(goltotoButtonBy);
        goltotoButton.click();
        System.out.println(className + ": We click on the \"Goltoto\" button");
    }

    // Methods for Puttó
    public void clickOnPuttoButton() {
        WebElement puttoButton = driver.findElement(puttoButtonBy);
        puttoButton.click();
        System.out.println(className + ": We click on the \"PUTTÓ\" menu button");
    }

    // Methods for Napi Mázli
    public void clickOnNapiMazliButton() {
        WebElement napiMazliButton = driver.findElement(napiMazliButtonBy);
        napiMazliButton.click();
        System.out.println(className + ": We click on the \"Napi Mázli\" menu button");
    }

    public void clickOnNapiJatekokButton() {
        WebElement napiJatekokButton = driver.findElement(napiJatekokButtonBy);
        napiJatekokButton.click();
        System.out.println(className + ": Clicked on the \"Napi Játékok\" button");
    }

    public void clickOnKenoButton() {
        WebElement kenoButton = driver.findElement(kenoButtonBy);
        kenoButton.click();
        System.out.println(className + ": We click on the \"KENÓ\" menu button");
    }
}
