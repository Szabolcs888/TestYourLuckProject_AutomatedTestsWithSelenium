package szerencsejatek.lotto.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class HatosLottoPage {
    static Logger log = Logger.getLogger(HatosLottoPage.class);

    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By hatoslottoPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By deleteButtonBy = By.cssSelector("a[class='delete']");
    private final By confirmDeleteButtonBy = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div/button[2]");
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");
    private final By closeButtonBy = By.cssSelector("button[class='button button-more game btn btn-green ng-binding']");
    private final By allNormalNumbersBy = By.cssSelector("span[class='number ng-binding ng-scope']");
    private final By hatoslottoNumberBy = By.xpath("//*[@id=\"panel-0-number-1\"]");
    private final By invalidNumberBy = By.xpath("//*[@id=\"panel-0-number-18\"]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By jokerButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[2]/div/div/ul[1]/li[6]");

    public HatosLottoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isHatoslottoPageLoaded() {
        WebElement hatoslottoPicture = driver.findElement(hatoslottoPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/hatoslotto") && hatoslottoPicture.isDisplayed();
        return isLoaded;
    }

    public void clickOnDeleteButton() {
        WebElement deleteButton = driver.findElement(deleteButtonBy);
        deleteButton.click();
        log.info("We click on the 'TORLES' button");
    }

    public void clickOnConfirmDeleteButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement confirmDeleteButton = driver.findElement(confirmDeleteButtonBy);
        confirmDeleteButton.click();
        log.info("We click on the 'TORLES' button");
    }

    public void clickOnAddToCartButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement addToCartButton = driver.findElement(addToCartButtonBy);
        try {
            addToCartButton.click();
            log.info("We click on \"KOSARBA\" button");
        } catch (Exception e) {
            log.info("We try to click on \"KOSARBA\" button but it is not clickable");
        }
    }

    public void clickOnCloseButton() {
        WebElement closeButton = driver.findElement(closeButtonBy);
        closeButton.click();
        log.info("We click on the 'BEZARAS' button");
    }

    public void selectFiveNormalNumbers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allNormalNumbers = driver.findElements(allNormalNumbersBy);
        List<WebElement> normalNumbers = Arrays.asList(allNormalNumbers.get(1), allNormalNumbers.get(10), allNormalNumbers.get(20), allNormalNumbers.get(35), allNormalNumbers.get(40));
        for (WebElement number : normalNumbers) {
            number.click();
        }
        log.info("We select five numbers");
    }

    public void selectOneNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement hatoslottoNumber = driver.findElement(hatoslottoNumberBy);
        hatoslottoNumber.click();
        log.info("We select another number");
    }

    public void selectInvalidNumber() {
        WebElement invalidNumber = driver.findElement(invalidNumberBy);
        try {
            invalidNumber.click();
            log.info("We try to select another number");
        } catch (Exception e) {
            log.info("We try to select another number but it is not clickable");
        }
    }

    public boolean areZeroNumbersSelected() {
        List<WebElement> unSelectedNumbers = driver.findElements(allNormalNumbersBy);
        boolean zeroNumbers = false;
        if (unSelectedNumbers.size() == 360) {
            zeroNumbers = true;
        }
        return zeroNumbers;
    }

    public boolean areSixNumbersSelected() {
        List<WebElement> unSelectedNumbers = driver.findElements(allNormalNumbersBy);
        boolean zeroNumbers = false;
        if (unSelectedNumbers.size() == 354) {
            zeroNumbers = true;
        }
        return zeroNumbers;
    }

    public boolean isOneJokerGameDisplayed() {
        System.out.println(className + ": We check if one Joker game is displayed");
        List<WebElement> jokerGames = driver.findElements(jokerGamesBy);
        boolean isDisplayed = false;
        if (jokerGames.size() == 1) {
            isDisplayed = true;
        }
        return isDisplayed;
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
}
