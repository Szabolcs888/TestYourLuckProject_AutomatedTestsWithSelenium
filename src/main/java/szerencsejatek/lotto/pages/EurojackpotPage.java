package szerencsejatek.lotto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class EurojackpotPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By eurojackpotPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By jokerButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[2]/div/div/ul[1]/li[6]");
    private final By eurojackpotCombinationGameBy = By.id("combination-game");
    private final By allNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");
    private final By selectedNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope selected']");
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");

    public EurojackpotPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isEurojackpotPageLoaded() {
        WebElement eurojackpotPicture = driver.findElement(eurojackpotPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/eurojackpot") && eurojackpotPicture.isDisplayed();
        System.out.println(className + ": We check if the 'Eurojackpot' page is loaded");
        return isLoaded;
    }

    public boolean areThreeJokerGamesDisplayed() {
        List<WebElement> jokerGames = driver.findElements(jokerGamesBy);
        boolean isDisplayed = false;
        if (jokerGames.size() == 3) {
            isDisplayed = true;
        }
        System.out.println(className + ": We check if three Joker games are displayed");
        return isDisplayed;
    }

    public void clickOnJokerButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jokerButtonBy));
        WebElement jokerButton = driver.findElement(jokerButtonBy);
        jokerButton.click();
        System.out.println(className + ": We click on the \"Joker\" menu button");
    }

    public void clickOnEurojackpotCombinationGame() {
        WebElement eurojackpotCombinationGame = driver.findElement(eurojackpotCombinationGameBy);
        eurojackpotCombinationGame.click();
        System.out.println(className + ": We click on the \"KOMBINÁCIÓS JÁTÉK\" menu button");
    }

    public void selectSevenANumbers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allNumbers = driver.findElements(allNumbersBy);
        List<WebElement> aNumbers = Arrays.asList(allNumbers.get(0), allNumbers.get(8), allNumbers.get(12), allNumbers.get(16), allNumbers.get(20), allNumbers.get(30), allNumbers.get(40));
        for (WebElement number : aNumbers) {
            number.click();
        }
        System.out.println(className + ": We select seven A numbers");
    }

    public void selectTwoBNumbers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> allNumbers = driver.findElements(allNumbersBy);
        List<WebElement> bNumbers = Arrays.asList(allNumbers.get(50), allNumbers.get(53));
        for (WebElement number : bNumbers) {
            number.click();
        }
        System.out.println(className + ": We select two B numbers");
    }

    public boolean areNineNumbersSelected() {
        List<WebElement> selectedNumbers = driver.findElements(selectedNumbersBy);
        boolean nineNumbers = false;
        if (selectedNumbers.size() == 9) {
            nineNumbers = true;
        }
        System.out.println(className + ": We check if three Joker games are displayed");
        return nineNumbers;
    }

    public void clickOnAddToCartButton() {
        WebElement addToCartButton = driver.findElement(addToCartButtonBy);
        addToCartButton.click();
        System.out.println(className + ": We click on the \"KOSÁRBA\" button");
    }
}
