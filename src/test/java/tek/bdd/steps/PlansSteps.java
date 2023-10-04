package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.PlansPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class PlansSteps extends SeleniumUtility {

    @Then("Validate Section title is {string}")
    public void validateSectionTitle(String expectedSectionTitle) {
        String actualSectionTitle = getElementText(PlansPage.PLANS_SECTION_TITLE);
        Assert.assertEquals("Validate Section Title",
                expectedSectionTitle,
                actualSectionTitle);
    }

    @Then("Validate Table row is {int}")
    public void validateTableRowsCount(int expectedRows) {
        int actualRowSize = getListOfElements(PlansPage.TABLE_ROW_LOCATOR).size();
        Assert.assertEquals("Validate Table Rows",
                expectedRows,
                actualRowSize);
    }

    @Then("Validate All Plans are Valid")
    public void validateAllPlansAreValid() {
       List<WebElement> elements = getListOfElements(PlansPage.PLAN_EXPIRED_COLUMN);

       for(WebElement element : elements) {
         String actualText =  element.getText();
         Assert.assertEquals("Validate All Plans are Valid", "Valid", actualText);
       }
    }

}
