package szerencsejatek.lotto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JokerPage {
    private final String className = getClass().getSimpleName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By jokerPictureBy = By.xpath("/html/body/div/div[3]/section/div[1]/div[1]/div/div[1]");
    private final By oneFieldOneJokerOtoslottoBy = By.cssSelector("a[href='/lottoapi?sz=L5-1-JJJ']");
    private final By oneFieldOneJokerHatoslottoBy = By.cssSelector("a[href='/lottoapi?sz=L6-J'");
    private final By oneFieldOneJokerSkandinavLottoBy = By.cssSelector("a[href='/lottoapi?sz=LS-J'");
    private final By oneFieldOneJokerKenoBy = By.cssSelector("a[href='/lottoapi?sz=KN1-10-1-J'");
    private final By oneFieldOneJokerNapiMazliBy = By.cssSelector("a[href='/lottoapi?sz=NM1-1-1-J'");
    private final By oneFieldThreeJokerEurojackpotBy = By.cssSelector("a[href='/lottoapi?sz=EJ-JJJ'");
    private final By twoFieldOneJokerLuxorBy = By.cssSelector("a[href='/lottoapi?sz=LU-J'");

    public JokerPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isJokerPageLoaded() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(className + ": We check if the Joker page is loaded");
        WebElement jokerPicture = driver.findElement(jokerPictureBy);
        boolean isLoaded = (driver.getCurrentUrl()).equals("https://bet.szerencsejatek.hu/jatekok/joker") && jokerPicture.isDisplayed();
        return isLoaded;
    }

    public void clickOnOneFieldOneJokerOtoslotto() {
        WebElement oneFieldOneJokerOtoslotto = driver.findElement(oneFieldOneJokerOtoslottoBy);
        oneFieldOneJokerOtoslotto.click();
        System.out.println(className + ": We click on the \"1 mező + 1 Joker\" button under 'Ötöslottó'");
    }

    public void clickOnOneFieldOneJokerHatoslotto() {
        WebElement oneFieldOneJokerHatoslotto = driver.findElement(oneFieldOneJokerHatoslottoBy);
        oneFieldOneJokerHatoslotto.click();
        System.out.println(className + ": We click on the \"1 mező + 1 Joker\" button under 'Hatoslottó'");
    }

    public void clickOnOneFieldOneJokerSkandinavLotto() {
        WebElement oneFieldOneJokerSkandinavLotto = driver.findElement(oneFieldOneJokerSkandinavLottoBy);
        oneFieldOneJokerSkandinavLotto.click();
        System.out.println(className + ": We click on the \"1 mező + 1 Joker\" button under 'Skandináv lottó'");
    }

    public void clickOnOneFieldOneJokerKeno() {
        WebElement oneFieldOneJokerKeno = driver.findElement(oneFieldOneJokerKenoBy);
        oneFieldOneJokerKeno.click();
        System.out.println(className + ": We click on the \"1 mező + 1 Joker\" button under 'Kenó'");
    }

    public void clickOnOneFieldOneJokerNapiMazli() {
        WebElement oneFieldOneJokerNapiMazli = driver.findElement(oneFieldOneJokerNapiMazliBy);
        oneFieldOneJokerNapiMazli.click();
        System.out.println(className + ": We click on the \"1 mező + 1 Joker\" button under 'Napi mázli'");
    }

    public void clickOnOneFieldThreeJokerEurojackpot() {
        WebElement oneFieldThreeJokerEurojackpot = driver.findElement(oneFieldThreeJokerEurojackpotBy);
        oneFieldThreeJokerEurojackpot.click();
        System.out.println(className + ": We click on the \"1 mező + 3 Joker\" button under 'Eurojackpot'");
    }

    public void clickOnTwoFieldOneJokerLuxor() {
        WebElement twoFieldOneJokerLuxor = driver.findElement(twoFieldOneJokerLuxorBy);
        twoFieldOneJokerLuxor.click();
        System.out.println(className + ": We click on the \"2 mező + 1 Joker\" button under 'Luxor'");
    }
}
