package base.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                return chromeDriverCreator.createWebDriver();
            case "firefox":
                FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                return firefoxDriverCreator.createWebDriver();
            default:
                throw new Exception("Browser " + browser + " don't supported");
        }

    }
}
