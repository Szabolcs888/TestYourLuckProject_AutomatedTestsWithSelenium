package szerencsejatek.napiJatekok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class PuttoPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By puttoPictureBy = By.xpath("/html/body/div[1]/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By lottokButtonBy = By.xpath("/html/body/div[1]/div[2]/nav/div[1]/div/div/ul/li[1]");
    private final By puttoButtonBy = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div/div/ul[2]/li[2]/a");

    private final By numberSelectorBy = By.xpath("div[class=\"game-types lot lot-5 clear\"");
    private final By selectStakeAmountBy = By.cssSelector("div[class=\"game-types lot lot-5 clear\"]");
    private final By addToCartButtonBy = By.cssSelector("button[class='button button-orange button-to-cart']");
    private final By numbersFieldABy = By.cssSelector("div[class='number ng-binding ng-scope']");
    private final By numbersFieldBBy = By.cssSelector("div[class=\"numbers-container clear putto_b\"]");
    private final By allNormalNumbersBy = By.cssSelector("div[class='number ng-binding ng-scope']");

    public PuttoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isPuttoPageLoaded() {
        System.out.println(className + ": We check if the 'Puttó' page is loaded");
        WebElement puttóPicture = driver.findElement(puttoPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/putto") && puttóPicture.isDisplayed();
        return isLoaded;
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

    public void clickOnPuttoButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement puttoButton = driver.findElement(puttoButtonBy);
        puttoButton.click();
        System.out.println(className + ": We click on the \"Puttó\" menu button");
    }

    public void selectNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            WebElement numberInput = driver.findElement(numberSelectorBy);
            numberInput.clear();
            numberInput.sendKeys(Integer.toString(number));
        }
    }

    public void selectStakeAmount(int i) {
        WebElement gameTypeElement = driver.findElement(selectStakeAmountBy);
        gameTypeElement.click();
        System.out.println(className + ": We Select the Keno game type");
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

    public void selectEightNumbersForFieldA() {
        List<WebElement> allNormalNumbers = driver.findElements(numbersFieldABy);
        List<WebElement> normalNumbers = Arrays.asList(allNormalNumbers.get(2), allNormalNumbers.get(3), allNormalNumbers.get(6), allNormalNumbers.get(9), allNormalNumbers.get(12), allNormalNumbers.get(15), allNormalNumbers.get(18), allNormalNumbers.get(19));
        for (WebElement number : normalNumbers) {
            number.click();
        }
        System.out.println(className + ": We select eight numbers");

    }

    public void selectSevenNumbersForFieldA() {
        List<WebElement> allNormalNumbers = driver.findElements(numbersFieldABy);
        List<WebElement> normalNumbers = Arrays.asList(allNormalNumbers.get(2), allNormalNumbers.get(3), allNormalNumbers.get(6), allNormalNumbers.get(9), allNormalNumbers.get(12), allNormalNumbers.get(15), allNormalNumbers.get(18));
        for (WebElement number : normalNumbers) {
            number.click();
        }
        System.out.println(className + ": We select eight numbers");
    }

    public void selectOneNumberForFieldB() {
        List<WebElement> allNormalNumbers = driver.findElements(numbersFieldBBy);
        List<WebElement> normalNumbers = Arrays.asList(allNormalNumbers.get(0));
        for (WebElement number : normalNumbers) {
            number.click();
        }
        System.out.println(className + ": We select eight numbers");
    }

    public boolean areNumbersSelected() {
        List<WebElement> unSelectedNumbers = driver.findElements(allNormalNumbersBy);
        boolean zeroNumbers = false;
        if (unSelectedNumbers.size() == 87) {
            zeroNumbers = true;
        }
        return zeroNumbers;
    }
}
