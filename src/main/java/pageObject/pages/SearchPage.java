package pageObject.pages;

import base.Functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchPage extends CommonFunctions {

    @FindBy(css = "ul.sign-md #mcp a")
    private WebElement buttonCurrency;

    @FindBy(css = "div[class='cdk-overlay-pane mcpDialog'] select")
    private List<WebElement> dropdownLanguageCurrency;

    @FindBy(css = "div[class='cdk-overlay-pane mcpDialog'] button")
    private WebElement buttonApply;

    @FindBy(css = "div[class*='SearchOrigin']")
    private WebElement inputSearchOrigin;

    @FindBy(css = "div[class*='SearchDestination']")
    private WebElement inputSearchDestination;

    @FindBy(css = "mat-dialog-container[class*='mat-dialog-container'] #fnameOrigin")
    private WebElement inputSearchDeparture;

    @FindBy(css = "mat-dialog-container[class*='mat-dialog-container'] #fnameDestination")
    private WebElement inputSearchDest;

    By labelLanguageCurrency = By.cssSelector("ul.sign-md #mcp a span");

    By futureDateList = By.xpath("//div[contains(@class,'calendar right')]//tr[contains(@class,'ng-star-inserted')]//td[not(contains(@class,'off'))]");

    By futureDatePriceList = By.xpath("//div[contains(@class,'calendar right')]//tr[contains(@class,'ng-star-inserted')]//td[not(contains(@class,'off'))]//span[@class='price']");

    @FindBy(css = "div[class*='departure-cont']")
    private WebElement inputDepartureDate;

    public void selectCurrencyLanguage(String language, String currency) throws Exception{
        clickElementClickable(buttonCurrency,20);
        waitForElementListVisible(dropdownLanguageCurrency, 20);
        selectDropdownClickable(dropdownLanguageCurrency.get(0),language,20);
        selectDropdownClickable(dropdownLanguageCurrency.get(1),language,20);
        clickElementClickable(buttonApply,20);
        Thread.sleep(5000);
    }

    public String getLanguageCurrency() {
        waitForElementClickable(buttonCurrency,20);
        waitForElementPresenceBy(labelLanguageCurrency, 20);
        return getWebElementText(labelLanguageCurrency);
    }

    public void SearchOriginDestination(String origin, String destination) throws Exception {
        By org = By.xpath("//mat-dialog-container[contains(@class,'mat-dialog-container')]//div[contains(text(),'"+origin+"')]");
        By dest = By.xpath("//mat-dialog-container[contains(@class,'mat-dialog-container')]//div[contains(text(),'"+destination+"')]");
        clickElementClickable(inputSearchOrigin, 20);
        sendKeysElementVisible(inputSearchDeparture, origin, 10);
        clickElementClickable(org, 20);
        clickElementClickable(inputSearchDestination, 20);
        sendKeysElementVisible(inputSearchDest, destination, 10);
        clickElementClickable(dest,20);
    }

    public String selectRandomDayFutureMonth() throws Exception {
        waitForPresenceOfAllElementsLocatedBy(futureDateList, 20);
        Random rand = new Random();
        WebElement el = getWebElementList(futureDateList).get(rand.nextInt(getWebElementList(futureDateList).size()));
        clickElementClickable(el, 20);
        return getWebElementText(el);
    }

    public int getHighestCost(){
        waitForPresenceOfAllElementsLocatedBy(futureDatePriceList, 20);
        int price = Integer.parseInt(getWebElementList(futureDatePriceList).get(0).getText().replace("$",""));
        for (WebElement el : getWebElementList(futureDatePriceList)) {
            int x = Integer.parseInt(el.getText().replace("$",""));
            if(price > x){
                price = x;
            }
        }
        return price;
    }

    public int getLowestCost(){
        waitForPresenceOfAllElementsLocatedBy(futureDatePriceList, 20);
        int price = Integer.parseInt(getWebElementList(futureDatePriceList).get(0).getText().replace("$",""));
        for (WebElement el : getWebElementList(futureDatePriceList)) {
            int x = Integer.parseInt(el.getText().replace("$",""));
            if(price < x){
                price = x;
            }
        }
        return price;
    }
}
