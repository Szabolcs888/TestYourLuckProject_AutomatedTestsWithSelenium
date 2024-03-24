package szerencsejatek.napiJatekok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NapiMazliPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By napiMazliPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By jokerGamesBy = By.cssSelector("div[class='joker-item ng-scope']");
    private final By lottokButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[1]/div/div/ul/li[1]");
    private final By jokerButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[2]/div/div/ul[1]/li[6]");

    public NapiMazliPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isNapiMazliPageLoaded() {
        System.out.println(className + ": We check if the 'Napi Mázli' page is loaded");
        WebElement napiMazliPicture = driver.findElement(napiMazliPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/napimazli") && napiMazliPicture.isDisplayed();
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
}
