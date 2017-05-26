package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.utils.WebDriverHelper;

import java.util.List;

public class SearchResultPage {
    private WebDriverWait wait;
    private WebDriver driver;

    //@FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
    @FindBy(css = "[id*='tr_']:not([id*='tr_bnr_'])")
    private List<WebElement> searchResultElements;

    @FindBy(id = "page_main")
    private WebElement searchResultMainSection;


    @FindBy(xpath = "//*[text()='Цена' or text()='Cena'][ancestor::*[@id='head_line']]")
    private WebElement priceSortingButton;

    @FindBy(css = ".filter_opt_dv:nth-child(3) select")
    private WebElement dealTypeDropdown;

    @FindBy(xpath = "//*[text()='Расширенный поиск' or text()='Paplašināta meklēšana']")
    private WebElement extendedSearchLink;

    //private static final String CHECKBOXLIST_LIST_LOCATOR = "name='mid[]'"

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchResultMainSection));
    }

    public int getSearchResultElementCount() {
        return searchResultElements.size();
    }

    public SearchResultPage sortByPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(priceSortingButton));
        priceSortingButton.click();
        return this;
    }

    public SearchResultPage selectDealType(String dropdownValue) {
        WebDriverHelper.selectDropdownValueByText(dealTypeDropdown, dropdownValue);
        return this;
    }


    public ExtendedSearchPage goToExtendedSearch() {
        extendedSearchLink.click();
        return new ExtendedSearchPage(driver);


    }

    //   public SearchResultPage checkCheckboxes(int checkCount){
    //       for (int i = 0; i < checkCount ; i++) {
    //           this.searchResultElements;
    //
    //
    //      }
    //       return this;
    //    }

}
