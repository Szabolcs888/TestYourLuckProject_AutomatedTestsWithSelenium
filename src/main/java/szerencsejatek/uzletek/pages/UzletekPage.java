package szerencsejatek.uzletek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UzletekPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By shopsButtonBy = By.cssSelector("a[href='/uzletkereso']");
    private final By filterButtonBy = By.cssSelector("button.n-shop-finder__typing__opener");
    private final By accessibleButtonBy = By.cssSelector("[data-dictionary-id='2745']");
    private final By bankCardButtonBy = By.cssSelector("[data-dictionary-id='2746']");
    private final By foodAndDrinkButtonBy = By.cssSelector("[data-dictionary-id='2751']");
    private final By horseRacingButtonBy = By.cssSelector("[data-dictionary-id='7404']");
    private final By noSearchCriteriaFoundBy = By.className("n-shop-finder__shop-list__result");

    public UzletekPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickShopsButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement uzletekButton = driver.findElement(shopsButtonBy);
        uzletekButton.click();
        System.out.println(className + ": We click on the uzletek button");
    }

    public void setAccessibleButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement accessibleButton = driver.findElement(accessibleButtonBy);
        accessibleButton.click();
        System.out.println(className + ": We click on the Akadalymentesitett button");
    }

    public void setBankCardButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement setBankkartyas = driver.findElement(bankCardButtonBy);
        setBankkartyas.click();
        System.out.println(className + ": We click on the Bankkartyas button");
    }

    public void setFoodAndDrinkButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement foodAndDrinkButton = driver.findElement(foodAndDrinkButtonBy);
        foodAndDrinkButton.click();
        System.out.println(className + ": We click on the EtelitalButton button");
        WebElement assertButton = driver.findElement(By.cssSelector("span[class='n-shop-finder__shop-list__title n-shop-finder__shop-list__title--small ng-binding']"));
        String predictedString = "Rikicsi Tabak Bt.";
        String actualString = assertButton.getText();
        Assert.assertEquals(actualString, predictedString, "A szöveg nem megfelelő");
    }

    public void setHorseRacingButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement horseRacingButton = driver.findElement(horseRacingButtonBy);
        horseRacingButton.click();
        System.out.println(className + ": We click on the Loverseny button");
        WebElement assertButton = driver.findElement(By.cssSelector("span[class='ico-info n-shop-finder__shop-list__result__icon']"));
        Assert.assertTrue(assertButton.isDisplayed());
    }

    public void filterButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement filterButton = driver.findElement(filterButtonBy);
        filterButton.click();
        System.out.println(className + ": We click on the szures button");
        WebElement assertButton = driver.findElement(By.cssSelector("a[href='#']"));
        String predictedString = "Mit jelentenek ezek?";
        String actualString = assertButton.getText();
        Assert.assertEquals(actualString, predictedString, "A szöveg nem megfelelő");
    }

    public void assertNoSearchCriteriaFound() throws InterruptedException {
        Thread.sleep(2000);
        WebElement noSearchCriteriaButton = driver.findElement(noSearchCriteriaFoundBy);
        noSearchCriteriaButton.isDisplayed();
        System.out.println(className + ":  Nem talalhato a keresesi felteteleknek megfelelo lottozo!");
    }
}
