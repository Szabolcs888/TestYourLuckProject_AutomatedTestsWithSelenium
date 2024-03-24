package szerencsejatek.sorsjegyek.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BlackJackPage {
    static Logger log = Logger.getLogger(BlackJackPage.class);
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;

    private final By keyButtonBy = By.className("scratch-controls__icon");
    private final By numberAsTextBy = By.className("black-jack__label");
    private final By numberAsNumberBy = By.className("black-jack__number");
    private final By blackJackTextBy = By.className("black-jack__text");
    private final By showButtonBy = By.cssSelector("button[data-dictionary-id='8930']");
    private final By resultMessageBy = By.cssSelector("p[id='ngdialog1-aria-describedby']");

    public BlackJackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickKeyButton() {
        WebElement keyButton = driver.findElements(keyButtonBy).get(2);
        keyButton.click();
        log.info("We click on the \"key\" button");
    }

    public void scrollWindow() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,420)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("window.scrollBy(0,430)");
        log.info("We scroll down to the lottery ticket");
    }

    public void scratchMainGameOnETicket() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(1), -50, 0).perform(); //1.szám írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(1), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(1), 200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(2), 50, 0).perform(); //4.szám szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(2), -100, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(2), -200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), -50, 0).perform(); //1.szám szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), -25, -30).perform(); //1.szám szám, felfelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 0, -30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 25, -30).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), -50, 30).perform(); //1.szám szám, lelfelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), -25, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 0, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 25, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(1), 50, 30).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 50, 0).perform();  //4.szám írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), -200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), -50, -50).perform();  //4.szám írás, felfelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), -25, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 0, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 25, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 50, -50).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), -50, 40).perform();  //4.szám írás, lefelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), -25, 40).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 0, 40).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 25, 40).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(2), 50, 40).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(0), 50, 0).perform(); //nyeremény szám
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(0), -50, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(0), 50, 0).perform(); //osztó száma írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(0), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(0), -20, -30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(0), 20, -30).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), 100, 0).perform(); //osztó száma szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), -100, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), -75, 30).perform(); //osztó száma szám, lefelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), -50, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), -25, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), 0, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), 25, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), 50, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(0), 75, 30).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), -50, 0).perform(); //2.szám írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), 200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(3), -25, -50).perform(); //2.szám szám, felfelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(3), 0, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(3), 25, -50).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(4), 50, 0).perform(); //3.szám szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(4), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(4), -200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(3), -50, 0).perform(); //2.szám szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(3), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(3), 200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 50, 0).perform();  //3.szám írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), -200, 0).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), -50, 50).perform();  //2.szám írás, lefelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), -25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), 0, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), 25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(3), 50, 50).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), -50, 20).perform();  //3.szám írás, lefelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), -25, 25).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 0, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 25, 25).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 50, 10).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), -50, -30).perform();  //3.szám írás, felfelé
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), -25, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 0, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 25, -50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(4), 50, -50).perform();

        log.info("We scratch off the main field on the lottery ticket");
    }

    public void scratchSideGameOnETicket() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(2), -30, 0).perform(); //felirat
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(2), 100, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(2), -20, -20).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(2), 0, -20).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(2), 20, -20).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(blackJackTextBy).get(2), 40, -10).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(5), 50, 0).perform(); //jobb felső szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(5), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(5), -25, -15).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(5), 0, -20).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(5), 25, -15).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(5), -100, 0).perform(); //jobb felső írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(5), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(5), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(5), -25, 15).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(5), 0, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(5), 25, 15).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(7), 50, 0).perform(); //jobb alsó szám
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(7), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(7), -100, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsNumberBy).get(7), 25, -15).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), -100, 0).perform(); //bal alsó írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), -25, -30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), 0, -25).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), -25, 20).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), 0, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(6), 25, 30).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), -100, 0).perform(); //jobb alsó írás
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), 50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), -50, 0).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), -25, 15).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), 0, 30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), 25, 15).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), -50, -20).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), -25, -30).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(numberAsTextBy).get(7), 25, -15).perform();

        log.info("We scratch off the side field on the lottery ticket");
    }

    public void clickShowButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");
        WebElement showButton = driver.findElement(showButtonBy);
        showButton.click();
        log.info("We click on the \"Mutasd!\" button");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean assertResultMessage() {
        int playerNumber1 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(1).getText());
        int playerNumber2 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(3).getText());
        int playerNumber3 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(4).getText());
        int playerNumber4 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(2).getText());
        int dealerNumber = Integer.parseInt(driver.findElements(numberAsNumberBy).get(0).getText());
        int bonusNumber1 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(5).getText());
        int bonusNumber2 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(6).getText());
        int bonusNumber3 = Integer.parseInt(driver.findElements(numberAsNumberBy).get(7).getText());
        int bonusNumbersResult = bonusNumber1 + bonusNumber2 + bonusNumber3;

        System.out.println("\nPlayer's numbers: " + playerNumber1 + ", " + playerNumber2 + ", " + playerNumber3 + ", " + playerNumber4);
        System.out.println("Dealer's number: " + dealerNumber);
        System.out.println("Bonus numbers: " + bonusNumber1 + " + " + bonusNumber2 + " + " + bonusNumber3 + " = " + (bonusNumbersResult));

        WebElement resultMessage1 = driver.findElement(resultMessageBy);
        String resultMessageText = resultMessage1.getText().trim();
        System.out.println("\n" + className + ": The message text is: \"" + resultMessageText + "\"\n");

        boolean isResultMessageValid = false;
        if (playerNumber1 > dealerNumber || playerNumber2 > dealerNumber || playerNumber3 > dealerNumber || playerNumber4 > dealerNumber) {
            if (resultMessageText.contains("Gratul")) {
                isResultMessageValid = true;
            }
        }
        if (bonusNumbersResult == 21) {
            if (resultMessageText.contains("Gratul")) {
                isResultMessageValid = true;
            }
        } else if (resultMessageText.contains("most nem nyert")) {
            isResultMessageValid = true;
        }
        return isResultMessageValid;
    }
}
