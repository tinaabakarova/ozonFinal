package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class MainPageSteps extends BaseSteps{
    MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    @Step("пользователь выбирает меню {name}")
    public void chooseCategoryByName(String name, WebDriverWait wait){
        waitForVisibleElementLocated(wait, mainPage.getTargetElementlocator());
        mainPage.chooseCategoryFirst(name);
    }
}
