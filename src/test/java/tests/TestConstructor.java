package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.MainView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestConstructor extends BaseSetupWithoutUserCreation {

    @Test
    @DisplayName("Test constructor")
    @Description("Test opening Bun section")
    public void testOpeningBunSection() {
        MainView mainView = new MainView(driver);
        mainView.clickFillingSectionMainView();
        mainView.clickBunSectionMainView();
        mainView.waitForBunSection();
        String actualResult = mainView.getTextBunSection();
        assertThat(actualResult, containsString("Булки"));
    }

    @Test
    @DisplayName("Test constructor")
    @Description("Test opening Sauce section")
    public void testOpeningSauceSection() {
        MainView mainView = new MainView(driver);
        mainView.clickFillingSectionMainView();
        mainView.clickSauceSectionMainView();
        mainView.waitForSauceSection();
        String actualResult = mainView.getTextSauceSection();
        assertThat(actualResult, containsString("Соусы"));
    }

    @Test
    @DisplayName("Test constructor")
    @Description("Test opening Filling section")
    public void testOpeningFillingSection() {
        MainView mainView = new MainView(driver);
        mainView.clickFillingSectionMainView();
        mainView.waitForFillingSection();
        String actualResult = mainView.getTextFillingSection();
        assertThat(actualResult, containsString("Начинки"));
    }
}