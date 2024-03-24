package szerencsejatek.sorsjegyek.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SorsjegyekPage {
    static Logger log = Logger.getLogger(SorsjegyekPage.class);
    private final WebDriver driver;

    private final By sorsjegyekTitleBy = By.cssSelector("h1[data-dictionary-id='2647']");
    private final By orderMenuButtonBy = By.id("orderBy");
    private final By increasePriceButtonBy = By.cssSelector("option[value='price']");
    private final By decreasePrizeButtonBy = By.cssSelector("option[value='-win1']");
    private final By sorsjegyItemsBy = By.className("instant-ticket__box__text--bold");

    public SorsjegyekPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSorsjegyekTitle() {
        WebElement sorsjegyekTitle = driver.findElement(sorsjegyekTitleBy);
        log.info("The \"SORSJEGYEK\" page is displayed");
        return sorsjegyekTitle;
    }

    public void clickOrderMenuButton() {
        WebElement orderMenuButton = driver.findElement(orderMenuButtonBy);
        orderMenuButton.click();
        log.info("We click on the \"Sorsjegyek rendezese\" button");
    }

    public void clickAscendingPriceButton() {
        WebElement ascendingPriceButton = driver.findElement(increasePriceButtonBy);
        ascendingPriceButton.click();
        log.info("We click on the \"Ar szerint szerint novekvo\" option button");
    }

    public void clickDescendingPrizeButton() {
        WebElement descendingPrizeButton = driver.findElement(decreasePrizeButtonBy);
        descendingPrizeButton.click();
        log.info("We click on the \"Fonyeremeny szerint csokkeno\" option button");
    }

    public List<Integer> getItemListAsPriceForSorjegyPage() {
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

    public List<Integer> getItemListAsPrizeForSorjegyPage() {
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
