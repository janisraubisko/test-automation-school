package test.automation.school.tests;


import org.testng.annotations.Test;
import test.automation.school.BaseTest;
import test.automation.school.enums.TimePeriod;
import test.automation.school.pageobjects.*;

import static org.testng.Assert.assertTrue;
import static test.automation.school.enums.Language.RU;
import static test.automation.school.enums.Location.RIGA;

public class Task2Test extends BaseTest {
    private TopMenuBar topMenuBar;
    private HomePage homePage;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;
    private ExtendedSearchPage extendedSearchPage;
    @Test
    public void Task2Test() throws Exception {
        //Arrange
        homePage = new HomePage(getDriver());
        topMenuBar = new TopMenuBar(getDriver());
        topMenuBar.switchLangTo(RU);
        searchPage = topMenuBar.goToSearchPage();

        //Act
        searchResultPage = searchPage.searchForPhrase("Компьютер")
                .selectSubDivision("Электротехника")
                .selectCategory("Компьютеры, оргтехника")
                .selectLocation(RIGA)
                .selectTimePeriod(TimePeriod.LAST_MONTH)
                .performSearch();

        extendedSearchPage = searchResultPage.sortByPrice().selectDealType("Продажа").goToExtendedSearch();
    //    extendedSearchPage = searchResultPage.sortByPrice().goToExtendedSearch();

        searchResultPage = extendedSearchPage.setPriceBoundaries("0","300")
                .selectTimePeriod(TimePeriod.ALL_PERIOD)
                .performSearch();
    }


}