package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class=\"sc-16r8icm-0 ekMmID table-control-page-sizer\"]/child::div")
    WebElement rowDropDown;

    @FindBy(xpath = "//*[@class=\"sc-16r8icm-0 sc-1f0grbq-0 cEoyCq\"]/button[1]")
    WebElement optionList;

    @FindBy(xpath = "//table[@class=\"h7vnx2-2 bFpGkc cmc-table  \"]/tbody/tr")
    List<WebElement> rows;

    @FindBy(xpath = "//div/*[@class=\"x0o17e-0 ewuQaX sc-36mytl-0 bBafzO table-control-filter\"]")
    WebElement filterButton;

    @FindBy(xpath = "//*[@class=\"sc-1erqz0q-0 kSFTVn\"]//*[text()='Add Filter']")
    WebElement addFilterButton;


    @FindBy(xpath = "//button[text()='Apply Filter']")
    WebElement applyFilterButton;

    @FindBy(xpath = "//button[text()='Show results']")
    WebElement showResultsButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]")
    List<WebElement> marketCapData;

    @FindBy(xpath = "//table/tbody/tr[1]/td[4]")
    List<WebElement> priceData;

    public void selectAValue(String noOfDataToBeShownValue) {

        rowDropDown.click();
        WebElement dataToBeShownValue = driver.findElement(By.
                xpath("//button[text()='" + noOfDataToBeShownValue + "' and @class='x0o17e-0 bnhhNH']"));
        dataToBeShownValue.click();
    }

    public int findDataRows() {
        int noOfDataRows = rows.size();
        return noOfDataRows;
    }

    public void clickOnFilter() {
        filterButton.click();
    }

    public void clickOnAddFilter() {
        addFilterButton.click();
    }

    public void applyFilter(String filterName, String filterValueString) {

        WebElement selectedFilter = driver.findElement(By.xpath("//button[text()='" + filterName + "']"));
        selectedFilter.click();

        WebElement selectedFilterValue = driver.findElement(By.xpath("//button[text()='" + filterValueString + "']"));
        selectedFilterValue.click();

        applyFilterButton.click();
    }

    public void clickOnShowResults() {
        showResultsButton.click();
    }

    public List<WebElement> getMarketCapInTable() {
        return marketCapData;
    }

    public List<WebElement> getPriceInTable() {
        return priceData;
    }
}