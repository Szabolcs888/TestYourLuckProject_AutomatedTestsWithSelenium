package szerencsejatek.lotto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class SkandinavLottoPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By skandinavLottoPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By jokerButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[2]/div/div/ul[1]/li[6]");
    private final By skandinavLottoCombinationGameBy = By.id("combination-game");
    private final By allNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");
    private final By selectedNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope selected']");
    private final By fiveXGameTypeBy = By.cssSelector("div[data-dictionary-id='11231']");
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");

    public SkandinavLottoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isSkandinavLottoPageLoaded() {
        System.out.println(className + ": We check if the 'Skandináv lottó' page is loaded");
        WebElement skandinavLottoPicture = driver.findElement(skandinavLottoPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/skandinavlotto") && skandinavLottoPicture.isDisplayed();
        return isLoaded;
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

    public void clickOnSkandinavLottoCombinationGame() {
        WebElement skandinavLottoCombinationGame = driver.findElement(skandinavLottoCombinationGameBy);
        skandinavLottoCombinationGame.click();
        System.out.println(className + ": We click on the \"KOMBINÁCIÓS JÁTÉK\" menu button");
    }

    public void selectTwoFixNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allNumbers = driver.findElements(allNumbersBy);
        List<WebElement> fixNumbers = Arrays.asList(allNumbers.get(1), allNumbers.get(30));
        for (WebElement number : fixNumbers) {
            number.click();
        }
        System.out.println(className + ": We select two fix numbers");
    }

    public void selectSevenCombinationNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allNumbers = driver.findElements(allNumbersBy);
        List<WebElement> combinationNumbers = Arrays.asList(allNumbers.get(35), allNumbers.get(38), allNumbers.get(39), allNumbers.get(40), allNumbers.get(45), allNumbers.get(55), allNumbers.get(65));
        for (WebElement number : combinationNumbers) {
            number.click();
        }
        System.out.println(className + ": We select seven combination numbers");
    }

    public boolean areNineNumbersSelected() {
        List<WebElement> selectedNumbers = driver.findElements(selectedNumbersBy);
        boolean nineNumbers = false;
        if (selectedNumbers.size() == 9) {
            nineNumbers = true;
        }
        return nineNumbers;
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
}
