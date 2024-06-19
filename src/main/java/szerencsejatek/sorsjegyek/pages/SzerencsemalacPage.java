package szerencsejatek.sorsjegyek.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.Set;

public class SzerencsemalacPage {
    static Logger log = Logger.getLogger(SzerencsemalacPage.class);

    private final String className = getClass().getSimpleName();
    private final WebDriver driver;

    private final By prizeAsNumber = By.className("szerencsemalac__prize");
    private final By prizeAsText = By.className("szerencsemalac__text");
    private final By showButtonBy = By.cssSelector("button[data-dictionary-id='8930']");
    private final By resultMessageBy = By.cssSelector("p[id='ngdialog1-aria-describedby']");

    public SzerencsemalacPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollWindow() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,360)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("window.scrollBy(0,370)");
        log.info("We scroll down to the lottery ticket");
    }

    public void sratchETicket() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), -50, 0).perform(); //felső sor, első szám
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), 200, 0).perform(); //felső sor, első szám
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsText).get(0), -50, 0).perform(); //felső sor, első felirat
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsText).get(0), 200, 0).perform(); //felső sor, első felirat

        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(3), -50, 0).perform(); //alsó sor, első szám
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(3), 200, 0).perform(); //alsó sor, első szám
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsText).get(3), -50, 0).perform(); //alsó sor, első felirat
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsText).get(3), 200, 0).perform(); //alsó sor, első felirat

        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), 0, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), -50, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), -25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), 25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(0), 50, 50).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(1), 0, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(1), -50, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(1), -25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(1), 25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(1), 50, 50).perform();

        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(2), 0, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(2), -50, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(2), -25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(2), 25, 50).perform();
        new Actions(driver).dragAndDropBy(driver.findElements(prizeAsNumber).get(2), 50, 50).perform();

        log.info("We scratch the lottery ticket");
    }

    public void clickShowButton() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");
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
        Set<String> prizeNumberList = new HashSet<>();
        prizeNumberList.add(driver.findElements(prizeAsNumber).get(0).getText());
        prizeNumberList.add(driver.findElements(prizeAsNumber).get(1).getText());
        prizeNumberList.add(driver.findElements(prizeAsNumber).get(2).getText());
        prizeNumberList.add(driver.findElements(prizeAsNumber).get(3).getText());
        prizeNumberList.add(driver.findElements(prizeAsNumber).get(4).getText());
        prizeNumberList.add(driver.findElements(prizeAsNumber).get(5).getText());

        String num1 = driver.findElements(prizeAsNumber).get(0).getText();
        String num2 = driver.findElements(prizeAsNumber).get(1).getText();
        String num3 = driver.findElements(prizeAsNumber).get(2).getText();
        String num4 = driver.findElements(prizeAsNumber).get(3).getText();
        String num5 = driver.findElements(prizeAsNumber).get(4).getText();
        String num6 = driver.findElements(prizeAsNumber).get(5).getText();
        System.out.println("\nNumbers: " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + num6);

        WebElement resultMessage1 = driver.findElement(resultMessageBy);
        String resultMessageText = resultMessage1.getText().trim();
        System.out.println("\n" + className + ": The message text is: \"" + resultMessageText + "\"\n");

        boolean isResultMessageValid = false;
        if (prizeNumberList.size() <= 4) {
            if (resultMessageText.contains("Gratul")) {
                isResultMessageValid = true;
            }
        } else {
            if (resultMessageText.contains("most nem nyert")) {
                isResultMessageValid = true;
            }
        }
        return isResultMessageValid;
    }
}

