package szerencsejatek.sorsjegyek.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlackJackPrePage {
    static Logger log = Logger.getLogger(BlackJackPrePage.class);
    private final WebDriver driver;

    private final By probajatekInditasaButtonBy = By.cssSelector("a[data-dictionary-id='2665']");

    public BlackJackPrePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProbajatekInditasaButton() {
        WebElement probajatekInditasaButton = driver.findElement(probajatekInditasaButtonBy);
        probajatekInditasaButton.click();
        log.info("We click on the \"PROBAJATEK INDITASA\" option button");
    }
}
