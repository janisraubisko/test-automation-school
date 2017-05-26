package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanis.raubishko on 5/26/2017.
 */
public class ExtendedSearchPage extends SearchPage {

    @FindBy(name = "sid")
    private WebElement dealTypeDropdown;

    @FindBy(name = "topt[8][min]")
    private WebElement minPriceInput;

    @FindBy(name = "topt[8][max]")
    private WebElement maxPriceInput;

    public ExtendedSearchPage(WebDriver driver) {
        super(driver);
        this.dealTypeDropdown = dealTypeDropdown;
        PageFactory.initElements(driver, this);
    }

    //public ExtendedSearchPage selectDealType()


    public ExtendedSearchPage setMinPrice(String minPrice) {
        minPriceInput.sendKeys(minPrice);
        return this;
    }

    public ExtendedSearchPage setMaxPrice(String maxPrice) {
        minPriceInput.sendKeys(maxPrice);
        return this;
    }


    public ExtendedSearchPage setPriceBoundaries(String minPrice, String MaxPrice) {
        setMinPrice(minPrice)
                .setMaxPrice(MaxPrice);
        return this;
    }

}
