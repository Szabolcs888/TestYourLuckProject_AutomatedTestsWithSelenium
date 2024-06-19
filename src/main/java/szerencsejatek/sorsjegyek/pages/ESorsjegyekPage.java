package szerencsejatek.sorsjegyek.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ESorsjegyekPage {
    static Logger log = Logger.getLogger(ESorsjegyekPage.class);
    private final WebDriver driver;

    private final By eSorsjegyekTitleBy = By.cssSelector("h1[data-dictionary-id='8921']");
    private final By orderMenuButtonBy = By.id("orderBy");
    private final By increasePrizeButtonBy = By.cssSelector("option[value='win1']");
    private final By decreasePriceButtonBy = By.cssSelector("option[value='-price']");
    private final By sorsjegyItemsBy = By.className("instant-ticket__box__text--bold");

    private final By reszletekButtonOnBlackJackETicketBy = By.cssSelector("a[ng-href='/e-sorsjegy/black-jack']");
    private final By reszletekButtonOnSzerencsemalacETicketBy = By.cssSelector("a[ng-href='/e-sorsjegy/szerencsemalac']");

    public ESorsjegyekPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getESorsjegyekTitle() {
        WebElement eSorsjegyekTitle = driver.findElement(eSorsjegyekTitleBy);
        return eSorsjegyekTitle;
    }

    public void clickOrderMenuButton() {
        WebElement orderMenuButton = driver.findElement(orderMenuButtonBy);
        orderMenuButton.click();
        log.info("We click on the \"E-sorsjegyek rendezese\" button");
    }

    public void clickAscendingPrizeButton() {
        WebElement ascendingPrizeButton = driver.findElement(increasePrizeButtonBy);
        ascendingPrizeButton.click();
        log.info("We click on the \"Fonyeremeny szerint novekvo\" option button");
    }

    public void clickDescendingPriceButton() {
        WebElement descendingPrizeButton = driver.findElement(decreasePriceButtonBy);
        descendingPrizeButton.click();
        log.info(": We click on the \"We click on the \"Ar szerint csokkeno\" option button");
    }

    public void clickReszletekButtonOnBlackJackETicket() {
        WebElement reszletekButtonOnBlackJackETicket = driver.findElement(reszletekButtonOnBlackJackETicketBy);
        reszletekButtonOnBlackJackETicket.click();
        log.info("We click on the \"Reszletek\" button of the 'Black Jack' E-lottery ticket");
    }

    public void clickReszletekButtonOnSzerencsemalacETicket() {
        WebElement reszletekButtonOnSzerencsemalacETicket = driver.findElement(reszletekButtonOnSzerencsemalacETicketBy);
        reszletekButtonOnSzerencsemalacETicket.click();
        log.info(": We click on the \"Reszletek\" button of the 'Szerencsemalac' E-lottery ticket");
    }

    public List<Integer> getItemListAsPriceForESorjegyPage() {
        List<WebElement> priceAndJackpotPrizeList = driver.findElements(sorsjegyItemsBy);
        List<Integer> priceList = new ArrayList<>();
        int i = 0;
        for (WebElement item : priceAndJackpotPrizeList) {
            if (i % 2 == 0) {
                String[] rowData = item.getText().split("Ft");
                priceList.add(Integer.parseInt(rowData[0].replace(" ", "")));
            }
            i++;
        }
        return priceList;
    }

    public List<Integer> getItemListAsPrizeForESorjegyPage() {
        List<WebElement> priceAndJackpotPrizeList = driver.findElements(sorsjegyItemsBy);
        List<Integer> jackpotPrizeList = new ArrayList<>();
        int i = 1;
        for (WebElement item : priceAndJackpotPrizeList) {
            if (i % 2 == 0) {
                String[] rowData = item.getText().split(" ");
                jackpotPrizeList.add(Integer.parseInt(rowData[0]));
            }
            i++;
        }
        return jackpotPrizeList;
    }

    public void listsPrint(List<Integer> originalList, List<Integer> sortedList) {
        System.out.println("\nThe list is in the order it appears on the page:");
        for (Integer item : originalList) {
            System.out.println(item);
        }
        System.out.println("\nThe list is in the order it should be:");
        for (Integer item : sortedList) {
            System.out.println(item);
        }
    }
}
