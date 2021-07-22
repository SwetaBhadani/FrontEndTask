package stepDefinition;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.util.Strings;
import pages.HomePage;

import java.util.List;
import java.util.Map;

public class StepDefinition extends BaseUtil {

    private BaseUtil base;
    private HomePage hp;

    public StepDefinition(BaseUtil base) {
        this.base = base;
        this.hp = new HomePage(driver);
    }

    @Given("As a user, I open the website")
    public void as_a_user_i_open_the_website() {

        base.driver.get("https://coinmarketcap.com/");
    }

    @When("I select show rows value as {int}")
    public int i_select_show_rows_value_to(int value) {
        String s = String.valueOf(value);
        hp.selectAValue(s);
        return value;
    }

    @Then("{int} rows should be displayed")
    public void rows_should_be_displayed(Integer int1) {

        int numberSelected = int1;
        hp.findDataRows();
        Assert.assertEquals(numberSelected, hp.findDataRows());
    }

    @When("I click on Filter button")
    public void i_click_on_filter_button() {

        hp.clickOnFilter();
    }

    @When("I click on Add Filter")
    public void i_click_on_add_filter() {

        hp.clickOnAddFilter();
    }

    @When("I click on Show results")
    public void i_click_on_show_results() {

        hp.clickOnShowResults();
    }

    @Then("I see the data with Market Cap 1B to 10B")
    public void i_see_the_data_with_market_cap_1b_to_10b() {

        List<WebElement> marketCapData = hp.getMarketCapInTable();
        for (int i = 0; i < marketCapData.size(); i++) {

            String marketCapValue = marketCapData.get(i).getText().substring(1);

            String[] splitValue = marketCapValue.split(",");

            marketCapValue = Strings.join("", splitValue);

            Long marketCapIntvalue = Long.parseLong(marketCapValue);

            Assert.assertTrue(marketCapIntvalue >= 1000000000l && marketCapIntvalue <= 10000000000l);
        }
    }

    @Then("I see the data with Price range $101 to $1000")
    public void i_see_the_data_with_price_range_to() {

        List<WebElement> priceData = hp.getPriceInTable();
        for (int i = 0; i < priceData.size(); i++) {

            String priceValue = priceData.get(i).getText().substring(1);
            Double priceIntvalue = Double.parseDouble(priceValue);
            Assert.assertTrue(priceIntvalue >= 101 && priceIntvalue <= 1000);
        }
    }


    @When("I select the following filter")
    public void i_select_the_following_filter(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> tableDataToMap = dataTable.asMaps();

        for (int i = 0; i < tableDataToMap.size(); i++) {
            Map<String, String> filterData = tableDataToMap.get(i);

            for (String key : filterData.keySet()) {
                String value = filterData.get(key);
                hp.applyFilter(key, value);
            }
        }

        List<WebElement> marketCapData = hp.getMarketCapInTable();
        for (int i = 0; i < marketCapData.size(); i++) {

            String marketCapValue = marketCapData.get(i).getText().substring(1);

            String[] splitValue = marketCapValue.split(",");

            marketCapValue = Strings.join("", splitValue);

            Long marketCapIntvalue = Long.parseLong(marketCapValue);

            Assert.assertTrue(marketCapIntvalue >= 1000000000l && marketCapIntvalue <= 10000000000l);
        }
    }

}


