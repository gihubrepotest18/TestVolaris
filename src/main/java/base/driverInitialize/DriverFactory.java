package base.driverInitialize;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static void addDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void removeDriver() {
        getDriver().quit();
        threadLocalDriver.remove();
    }
}
