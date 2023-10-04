package tek.bdd.pages;

import org.openqa.selenium.By;

public class PlansPage {

    public final static By PLANS_SECTION_TITLE = By.xpath("//app-plans-list/mat-card/mat-card-title");

    public final static By TABLE_ROW_LOCATOR = By.xpath("//table/tbody/tr");
    public final static By PLAN_EXPIRED_COLUMN = By.xpath("//table/tbody/tr/td[6]");
}
