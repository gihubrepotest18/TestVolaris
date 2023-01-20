package stepDefinition.volarisSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.ApplicationInstance;

public class SearchSteps extends ApplicationInstance {

    @Given("^I am in volaris page$")
    public void openVolarisPage() throws Throwable {
        volaris.goTo();
    }

    @When("^I select currency \"([^\"]*)\" and language \"([^\"]*)\"$")
    public void selectCurrencyLanguage(String currency, String language) throws Throwable {
        volaris.getSearchPage().selectCurrencyLanguage(currency, language);
        Assert.assertEquals(volaris.getSearchPage().getLanguageCurrency(),"English / $ USD","Currency or language is not matching");
    }

    @Then("^I select \"([^\"]*)\" as departure and \"([^\"]*)\" as destination")
    public void selectDepDest(String departure, String destination) throws Throwable {
        volaris.getSearchPage().SearchOriginDestination(departure, destination);
    }

    @And("^I select next future month in departure and return day$")
    public void selectNextMonth() throws Throwable {
        System.out.println(volaris.getSearchPage().getLanguageCurrency());
    }

    @And("^I return the day with lowest price$")
    public void getLowestPrice() throws Throwable {
        System.out.println(volaris.getSearchPage().getLowestCost());
    }

    @And("^I return the day with highest price$")
    public void getHighestPrice() throws Throwable {
        System.out.println(volaris.getSearchPage().getHighestCost());
    }

}
