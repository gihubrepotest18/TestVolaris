package base.driverInitialize;

import base.factory.WebDriverFactory;

public class SharedDriver {
    public SharedDriver(String browser) throws Exception {
        if (DriverFactory.getDriver() == null) {
            WebDriverFactory driver = new WebDriverFactory();
            DriverFactory.addDriver(driver.getDriver(browser));
        }
    }
}
