package szerencsejatek.napiJatekok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class KenoPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");
    private final By kenoPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By lottokButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[1]/div/div/ul/li[1]");
    private final By jokerButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[2]/div/div/ul[1]/li[6]");
    private final By kenoGamesBy = By.xpath("div[class='keno-item ng-scope']");
    private final By selectGameTypeBy = By.className("game-type");
    private final By selectStakeAmountBy = By.cssSelector("div[class=\"game-types lot lot-5 clear\"]");
    private final By allNormalNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");

    public KenoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isKenoPageLoaded() {
        System.out.println(className + ": We check if the 'Kenó' page is loaded");
        WebElement kenoPicture = driver.findElement(kenoPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/keno") && kenoPicture.isDisplayed();
        return isLoaded;
    }

    public boolean isKenoGameDisplayed() {
        System.out.println(className + ": We check if a Keno game is displayed");
        List<WebElement> kenoGames = driver.findElements(kenoGamesBy);
        System.out.println(kenoGames.size());
        boolean isDisplayed = !kenoGames.isEmpty();
        return isDisplayed;
    }

    public boolean isOneJokerGameDisplayed() {
        System.out.println(className + ": We check if one Joker game is displayed");
        List<WebElement> jokerGames = driver.findElements(jokerGamesBy);
        System.out.println(jokerGames.size());
        boolean isDisplayed = false;
        if (jokerGames.size() == 1) {
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public void clickOnLottokButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement lottokButton = driver.findElement(lottokButtonBy);
        lottokButton.click();
        System.out.println(className + ": We click on the \"LOTTÓK\" menu button");
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

    public void setSelectGameType(int i) {
        List<WebElement> gameTypeElements = driver.findElements(selectGameTypeBy);
        gameTypeElements.get(i).click();
        System.out.println(className + ": We select the Keno game type");
    }

    public void selectStakeAmount(int i) {
        WebElement gameTypeElement = driver.findElement(selectStakeAmountBy);
        gameTypeElement.click();
        System.out.println(className + ": We Select the Keno game type");
    }

    public void selectFiveNumbers() {
        List<WebElement> allNormalNumbers = driver.findElements(allNormalNumbersBy);
        List<WebElement> normalNumbers = Arrays.asList(allNormalNumbers.get(20), allNormalNumbers.get(31), allNormalNumbers.get(32), allNormalNumbers.get(33), allNormalNumbers.get(44));
        for (WebElement number : normalNumbers) {
            number.click();
        }
        System.out.println(className + ": We select five numbers");
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
            System.out.println(className + ": We click on \"KOSÁRBA\" button");
        } catch (Exception e) {
            System.out.println(className + ": We try to click on \"KOSÁRBA\" button but it is not clickable");
        }
    }

    public boolean areFiveNumbersSelected() {
        List<WebElement> unSelectedNumbers = driver.findElements(allNormalNumbersBy);
        boolean zeroNumbers = false;
        if (unSelectedNumbers.size() == 235) {
            zeroNumbers = true;
        }
        return zeroNumbers;
    }

    public boolean areTenNumbersSelected() {
        List<WebElement> unSelectedNumbers = driver.findElements(allNormalNumbersBy);
        boolean zeroNumbers = false;
        if (unSelectedNumbers.size() == 230) {
            zeroNumbers = true;
        }
        return zeroNumbers;
    }

    public void selectTenNumbers() {
        List<WebElement> allNormalNumbers = driver.findElements(allNormalNumbersBy);
        List<WebElement> normalNumbers = Arrays.asList(allNormalNumbers.get(1), allNormalNumbers.get(5), allNormalNumbers.get(10), allNormalNumbers.get(15), allNormalNumbers.get(20), allNormalNumbers.get(25), allNormalNumbers.get(30), allNormalNumbers.get(35), allNormalNumbers.get(40), allNormalNumbers.get(45));
        for (WebElement number : normalNumbers) {
            number.click();
        }
        System.out.println(className + ": We select ten numbers");
    }
}
