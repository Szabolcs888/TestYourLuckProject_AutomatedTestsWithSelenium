package driverFrameworkCore;

import driverFrameworkCore.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class DriverFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup() {
        Utils utils = new Utils();
        List<String> datas = utils.readFromFile();
        try {
            switch (datas.get(2)) {
                case "Chrome":
                    driver = new ChromeDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
            }
        } catch (Exception e) {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(60000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofMillis(60000));
    }

    @AfterSuite(alwaysRun = true)
    public void webDriverTearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
