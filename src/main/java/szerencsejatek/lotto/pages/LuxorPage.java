package szerencsejatek.lotto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LuxorPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By luxorPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By quicktipButtonsBy = By.cssSelector("a[class='quick-tip random-numbers']");
    private final By invalidNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");

    public LuxorPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isLuxorPageLoaded() {
        System.out.println(className + ": We check if the 'Luxor' page is loaded");
        WebElement luxorPicture = driver.findElement(luxorPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/luxor") && luxorPicture.isDisplayed();
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

    public void clickOnFirstQuicktip() {
        WebElement firstQuicktipButton = (driver.findElements(quicktipButtonsBy).get(0));
        firstQuicktipButton.click();
        System.out.println(className + ": We click on 'GYORSTIPP' in the 1st field");
    }

    public void clickOnSecondQuicktip() {
        WebElement secondQuicktipButton = (driver.findElements(quicktipButtonsBy).get(1));
        secondQuicktipButton.click();
        System.out.println(className + ": We click on 'GYORSTIPP' in the 2nd field");
    }

    public void selectInvalidNumberOnFirstField() {
        WebElement invalidNumber = (driver.findElements(invalidNumbersBy)).get(0);
        try {
            invalidNumber.click();
            System.out.println(className + ": We try to select another number");
        } catch (Exception e) {
            System.out.println(className + ": We try to select another number but it is not clickable");
        }
    }

    public void selectInvalidNumberOnSecondField() {
        WebElement invalidNumber = (driver.findElements(invalidNumbersBy)).get(60);
        try {
            invalidNumber.click();
            System.out.println(className + ": We try to select another number");
        } catch (Exception e) {
            System.out.println(className + ": We try to select another number but it is not clickable");
        }
    }

    public void clickOnAddToCartButton() {
        WebElement addToCartButton = driver.findElement(addToCartButtonBy);
        addToCartButton.click();
        System.out.println(className + ": We click on the \"KOSÁRBA\" button");
    }
}
