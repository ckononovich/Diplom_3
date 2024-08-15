package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.DataForTests;
import model.MainView;
import model.PersonalAccountView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestHeaderButtons extends BaseSetupWithUserCreation {
    DataForTests dataForTests = new DataForTests();

    @Test
    @DisplayName("Test header buttons")
    @Description("Test click on the 'Конструктор' button")
    public void testConstructorButton() {
        MainView mainView = new MainView(driver);
        mainView.clickLoginOnMainView();

        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickEmailField();
        personalAccountView.setEmailField(dataForTests.getEmail());
        personalAccountView.clickPasswordField();
        personalAccountView.setPasswordField(dataForTests.getPassword());
        personalAccountView.clickLoginButton();
        mainView.waitForLoadPage();
        mainView.clickPersonalAccountMainView();
        personalAccountView.waitForProfilePage();
        personalAccountView.clickConstructorButton();

        String actualResult = mainView.getTextConstructorHeader();
        assertThat(actualResult, containsString("Соберите бургер"));
    }

    @Test
    @DisplayName("Test header buttons")
    @Description("Test click on the logo button")
    public void testLogoButton() {
        MainView mainView = new MainView(driver);
        mainView.clickLoginOnMainView();

        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickEmailField();
        personalAccountView.setEmailField(dataForTests.getEmail());
        personalAccountView.clickPasswordField();
        personalAccountView.setPasswordField(dataForTests.getPassword());
        personalAccountView.clickLoginButton();
        mainView.waitForLoadPage();
        mainView.clickPersonalAccountMainView();
        personalAccountView.waitForProfilePage();
        personalAccountView.clickLogoIcon();

        String actualResult = mainView.getTextConstructorHeader();
        assertThat(actualResult, containsString("Соберите бургер"));
    }
}