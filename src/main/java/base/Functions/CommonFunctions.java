package base.Functions;

import base.driverInitialize.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonFunctions {
    private WebDriver driver = DriverFactory.getDriver();

    protected WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }

    protected boolean waitForElementListVisible(List<WebElement> elements, int timeOutInSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected boolean waitForElementClickable(WebElement element, int timeOutInSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected boolean waitForElementVisibility(WebElement webElement, int timeOutInSeconds){
        try {
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    protected boolean waitForElementPresenceBy(By locator, int timeOutInSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    protected boolean waitForElementToBeClickableBy(By locator, int timeOutInSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    protected boolean waitForPresenceOfAllElementsLocatedBy(By locator, int timeOutInSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected void clickElementClickable(WebElement webElement, int waitTime) throws Exception {
        if(waitForElementClickable(webElement, waitTime)){
            clickWebElementByActions(webElement);
        }else{
            throw new NoSuchElementException("Element not clickable");
        }
    }

    protected void clickElementClickable(By webElement, int waitTime) throws Exception {
        if(waitForElementToBeClickableBy(webElement, waitTime)){
            driver.findElement(webElement).click();
        }else{
            throw new NoSuchElementException("Element not clickable");
        }
    }

    protected void selectDropdownClickable(WebElement webElement, String option,int waitTime) throws Exception {
        if(waitForElementClickable(webElement, waitTime)){
            Select select = new Select(webElement);
            select.selectByVisibleText(option);
        }else{
            throw new NoSuchElementException("Element not clickable");
        }
    }

    protected void sendKeysWebElementByActions(WebElement wElement, String text) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.click(wElement).sendKeys(wElement, text).build().perform();
        } catch (Exception e) {
        }
    }
    protected void sendKeysByActions(String text) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(text).build().perform();
        } catch (Exception e) {
        }
    }
    protected void sendKeysAndMoveToWebElementByActions(WebElement wElement, String text) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(wElement).sendKeys(wElement, text).build().perform();
        } catch (Exception e) {
        }
    }

    protected void sendKeysElementVisible(WebElement webElement, String text, int waitTime) throws Exception {
        if(waitForElementVisibility(webElement, waitTime)){
            sendKeysWebElementByActions(webElement, text);
        }else{
            throw new NoSuchElementException("Element not valid");
        }
    }

    protected void sendKeysElementVisible(By webElement, String text, int waitTime) throws Exception {
        if(waitForElementPresenceBy(webElement, waitTime)){
            sendKeysWebElementByActions(getWebElement(webElement), text);
        }else{
            throw new NoSuchElementException("Element not valid");
        }
    }

    protected String getWebElementText(WebElement webElement){
        return webElement.getText();
    }

    protected String getWebElementText(By webElement){
        return driver.findElement(webElement).getText();
    }

    private void clickAndMoveToWebElementByActions(WebElement wElement) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(wElement).click(wElement).build().perform();
        } catch (Exception e) {
        }
    }

    private void clickWebElementByActions(WebElement wElement) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.click(wElement).build().perform();
        } catch (Exception e) {
        }
    }

    private String getWebElementLocatorPath(WebElement webElement){
        try{
            return webElement.toString().split("-> ")[1].replace("]","");
        }catch(Exception e){
            return webElement.toString().split("DefaultElementLocator")[1].replace("'","");
        }
    }
    private String getWebElementLocatorPath(List<WebElement> webElement){
        try{
            return webElement.toString().split("-> ")[1].replace("]","");
        }catch(Exception e){
            return webElement.toString().split("DefaultElementLocator")[1].replace("'","");
        }
    }

    protected String getUrl(){
        return driver.getCurrentUrl();
    }
}
