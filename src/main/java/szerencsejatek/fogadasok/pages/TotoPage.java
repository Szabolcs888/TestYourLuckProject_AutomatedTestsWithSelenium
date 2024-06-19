package szerencsejatek.fogadasok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TotoPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By clickCombinationButtonBy = By.id("combination-game");
    private final By quicktipButtonBy = By.cssSelector("a[ng-click='quickTip()']");
    private final By chanceOfThreeButtonBy = By.className("selector");
    private final By chanceOfThreeNumberButtonBy = By.cssSelector("option[value='3']");
    private final By doneButtonBy = By.cssSelector("button[class='button game']");
    private final By cartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");
    private final By inLotteryButtonBy = By.cssSelector("span[ng-if='!totoCombinationService.sst.pcwId']");

    public TotoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void combinationButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement combinationButton = driver.findElement(clickCombinationButtonBy);
        combinationButton.click();
        System.out.println(className + ": We click on the kombinacios button");
    }

    public void quicktipButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement quicktipButton = driver.findElement(quicktipButtonBy);
        quicktipButton.click();
        System.out.println(className + ": We click on the gyorstipp button");
    }

    public void chanceOfThreeButton() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> chanceOfThreeButton = driver.findElements(chanceOfThreeButtonBy);
        WebElement chanceButton = chanceOfThreeButton.get(0);
        chanceButton.click();
        System.out.println(className + ": We click on the haromesely button");
    }

    public void chanceOfThreeNumberButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfThreeNumberButton = driver.findElement(chanceOfThreeNumberButtonBy);
        chanceOfThreeNumberButton.click();
        System.out.println(className + ": We choose a number");
    }

    public void clickDoneButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement doneButton = driver.findElement(doneButtonBy);
        doneButton.click();
        System.out.println(className + ": We click on the mehet button");
    }

    public void cartButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cartButton = driver.findElement(cartButtonBy);
        cartButton.click();
        System.out.println(className + ": We click on the kosar button");
    }

    public void inLotteryButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement inLotteryButton = driver.findElement(inLotteryButtonBy);
        inLotteryButton.click();
        System.out.println(className + ": We click on the megjatszom a lottozoban button");
        WebElement assertButton = driver.findElement(By.cssSelector("a[href='/uzletkereso']"));
        Assert.assertTrue(assertButton.isDisplayed());
    }
}
