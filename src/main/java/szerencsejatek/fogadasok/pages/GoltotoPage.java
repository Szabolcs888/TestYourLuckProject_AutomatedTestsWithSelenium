package szerencsejatek.fogadasok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoltotoPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By quicktipButtonBy = By.cssSelector("a[ng-click='quickTip()']");
    private final By chanceOfTwoButtonBy = By.id("uniform-double-tips");
    private final By chanceOfTwoNumberButtonBy = By.id("double-tips");
    private final By chanceOfThreeButtonBy = By.id("uniform-triple-tips");
    private final By chanceOfThreeNumberButtonBy = By.id("triple-tips");
    private final By chanceOfFourButtonBy = By.id("uniform-four-tips");
    private final By chanceOfFourNumberButtonBy = By.id("four-tips");
    private final By doneButtonBy = By.cssSelector("button[class='button game']");
    private final By cartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");
    private final By inLotteryButtonBy = By.cssSelector("span[ng-if='!goalTotoService.sst.pcwId']");

    public GoltotoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickQuicktipButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement quicktipButton = driver.findElement(quicktipButtonBy);
        quicktipButton.click();
        System.out.println(className + ": We click on the gyorstipp button");
    }

    public void chanceOfTwoButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfTwoButton = driver.findElement(chanceOfTwoButtonBy);
        chanceOfTwoButton.click();
        System.out.println(className + ": We click on the ketesely button");
    }

    public void chanceOfThreeButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfThreeButton = driver.findElement(chanceOfThreeButtonBy);
        chanceOfThreeButton.click();
        System.out.println(className + ": We click on the haromeselybutton");
    }

    public void chanceOfFourButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfFourButton = driver.findElement(chanceOfFourButtonBy);
        chanceOfFourButton.click();
        System.out.println(className + ": We click on the negyesely button");
    }

    public void chanceOfTwoNumberButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfTwoNumberButton = driver.findElement(chanceOfTwoNumberButtonBy);
        Select select = new Select(chanceOfTwoNumberButton);
        select.selectByVisibleText("2 db");
        System.out.println(className + ":  We choose a number");
    }

    public void chanceOfThreeNumberButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfThreeNumberButton = driver.findElement(chanceOfThreeNumberButtonBy);
        Select select = new Select(chanceOfThreeNumberButton);
        select.selectByVisibleText("3 db");
        System.out.println(className + ":  We choose a number");
    }

    public void chanceOfFourNumberButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement chanceOfFourNumberButton = driver.findElement(chanceOfFourNumberButtonBy);
        Select select = new Select(chanceOfFourNumberButton);
        select.selectByVisibleText("1 db");
        System.out.println(className + ": We choose a number");
    }

    public void doneButton() throws InterruptedException {
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
        System.out.println(className + ": We click on the \"megjatszom a lottozoban\" button");
        WebElement assertButton = driver.findElement(By.cssSelector("a[href='/uzletkereso']"));
        Assert.assertTrue(assertButton.isDisplayed());
    }
}
