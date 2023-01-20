package pageObject.application;

import base.driverInitialize.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.pages.SearchPage;
import utils.JsonFiles;

import java.nio.file.NoSuchFileException;

public class Volaris {
    private WebDriver driver;

    private SearchPage searchPage;

    public Volaris() {
        driver = DriverFactory.getDriver();
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    public SearchPage getSearchPage() { return searchPage; }

    public void goTo() throws NoSuchFileException {
        JsonFiles file = new JsonFiles();
        file.setFileName("env");
        driver.navigate().to(file.getField("url"));
        driver.manage().deleteAllCookies();
    }
}
