package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.fedcm.model.Account;
import tek.bdd.pages.AccountsPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class AccountsSteps extends SeleniumUtility {


    @Then("Validate accounts table has {int} rows")
    public void validateAccountTableRows(int expectedRows) {

        List<WebElement> tableRowsElements = getListOfElements(AccountsPage.TABLE_ROWS);

        Assert.assertEquals("Validate", expectedRows, tableRowsElements.size());


    }

    @When("change item per page to {string}")
    public void changeItemPerPage(String itemPerPage) {
        clickOnElement(AccountsPage.ITEM_PER_PAGE);
        clickOnElement(AccountsPage.ITEM_PER_PAGE_OPTIONS);

        List<WebElement> itemPerPageOptions = getListOfElements(AccountsPage.ITEM_PER_PAGE_OPTIONS);

        for (WebElement element : itemPerPageOptions) {
            if (element.getText().contains(String.valueOf(itemPerPage))) {
                element.click();


            }

        }


    }
}
