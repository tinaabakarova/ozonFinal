package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CategoriesPage;

public class CategoriesStepPage extends BaseSteps {
    CategoriesPage categoriesPage;

    public CategoriesStepPage(WebDriver driver) {
        categoriesPage = new CategoriesPage(driver);
    }

    @Step("выбирает меню {name}")
    public void chooseCategoryByName(String name, WebDriverWait wait){
        waitForVisibleElementLocated(wait ,categoriesPage.getTargetItemLocator());
        categoriesPage.chooseCategorySecond(name);
    }
}
