package stepDefinition;

import base.driverInitialize.DriverFactory;
import base.driverInitialize.SharedDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import runner.TestNGCucumber;

public class Hooks {
    private WebDriver driver = null;

    @Before
    public void Initialize() throws Exception {
        String browser = TestNGCucumber.browser;
        SharedDriver df = new SharedDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @After
    public void CloseDriver(){
        DriverFactory.removeDriver();
    }

}
