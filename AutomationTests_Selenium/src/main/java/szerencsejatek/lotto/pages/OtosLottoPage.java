package szerencsejatek.lotto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class OtosLottoPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By otosLottoCombinationGameBy = By.id("combination-game");
    private final By allCombinationNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");
    private final By fiveXGameTypeBy = By.cssSelector("div[data-dictionary-id='2498']");
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");
    private final By selectedNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope selected']");
    private final By otoslottoPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By jokerButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[2]/div/div/ul[1]/li[6]/a");
    private final By allFixNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");

    public OtosLottoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean areSixNumbersSelected() {
        List<WebElement> selectedNumbers = driver.findElements(selectedNumbersBy);
        boolean sixNumbers = false;
        if (selectedNumbers.size() == 6) {
            sixNumbers = true;
        }
        return sixNumbers;
    }

    public boolean areNineNumbersSelected() {
        List<WebElement> selectedNumbers = driver.findElements(selectedNumbersBy);
        boolean nineNumbers = false;
        if (selectedNumbers.size() == 9) {
            nineNumbers = true;
        }
        return nineNumbers;
    }

    public boolean areEighteenNumbersSelected() {
        List<WebElement> selectedNumbers = driver.findElements(selectedNumbersBy);
        boolean eighteenNumbers = false;
        if (selectedNumbers.size() == 18) {
            eighteenNumbers = true;
        }
        return eighteenNumbers;
    }

    public boolean isOtoslottoPageLoaded() {
        System.out.println(className + ": We check if the Otoslotto page is loaded");
        WebElement otoslottoPicture = driver.findElement(otoslottoPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/otoslotto") && otoslottoPicture.isDisplayed();
        return isLoaded;
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

    public void clickOnOtosLottoCombinationGame() {
        WebElement otosLottoCombinationGame = driver.findElement(otosLottoCombinationGameBy);
        otosLottoCombinationGame.click();
        System.out.println(className + ": We click on the \"KOMBINÁCIÓS JÁTÉK\" menu button");
    }

    public void selectSixCombinationNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allCombinationNumbers = driver.findElements(allCombinationNumbersBy);
        List<WebElement> combinationNumbers = Arrays.asList(allCombinationNumbers.get(90), allCombinationNumbers.get(100), allCombinationNumbers.get(120), allCombinationNumbers.get(150), allCombinationNumbers.get(165), allCombinationNumbers.get(175));
        for (WebElement number : combinationNumbers) {
            number.click();
        }
        System.out.println(className + ": We select six combination numbers");
    }

    public void selectSevenCombinationNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allCombinationNumbers = driver.findElements(allCombinationNumbersBy);
        List<WebElement> combinationNumbers = Arrays.asList(allCombinationNumbers.get(90), allCombinationNumbers.get(95), allCombinationNumbers.get(100), allCombinationNumbers.get(122), allCombinationNumbers.get(150), allCombinationNumbers.get(165), allCombinationNumbers.get(173));
        for (WebElement number : combinationNumbers) {
            number.click();
        }
        System.out.println(className + ": We select seven combination numbers");
    }

    public void selectFifteenCombinationNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allCombinationNumbers = driver.findElements(allCombinationNumbersBy);
        List<WebElement> combinationNumbers = Arrays.asList(allCombinationNumbers.get(90), allCombinationNumbers.get(101), allCombinationNumbers.get(92), allCombinationNumbers.get(93), allCombinationNumbers.get(94), allCombinationNumbers.get(96), allCombinationNumbers.get(97), allCombinationNumbers.get(98), allCombinationNumbers.get(99), allCombinationNumbers.get(95), allCombinationNumbers.get(100), allCombinationNumbers.get(122), allCombinationNumbers.get(150), allCombinationNumbers.get(165), allCombinationNumbers.get(173));
        for (WebElement number : combinationNumbers) {
            number.click();
        }
        System.out.println(className + ": We select fifteen combination numbers");
    }

    public void selectTwoFixNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allFixNumbers = driver.findElements(allFixNumbersBy);
        List<WebElement> fixNumbers = Arrays.asList(allFixNumbers.get(1), allFixNumbers.get(30));
        for (WebElement number : fixNumbers) {
            number.click();
        }
        System.out.println(className + ": We select two fix numbers");
    }

    public void selectThreeFixNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allFixNumbers = driver.findElements(allFixNumbersBy);
        List<WebElement> fixNumbers = Arrays.asList(allFixNumbers.get(1), allFixNumbers.get(30), allFixNumbers.get(33));
        for (WebElement number : fixNumbers) {
            number.click();
        }
        System.out.println(className + ": We select two fix numbers");
    }

    public void clickOnFiveXGameType() {
        WebElement fiveXGameType = driver.findElement(fiveXGameTypeBy);
        fiveXGameType.click();
        System.out.println(className + ": We click on the 5X game type button");
    }

    public void clickOnAddToCartButton() {
        WebElement addToCartButton = driver.findElement(addToCartButtonBy);
        addToCartButton.click();
        System.out.println(className + ": We click on the \"KOSÁRBA\" button");
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
