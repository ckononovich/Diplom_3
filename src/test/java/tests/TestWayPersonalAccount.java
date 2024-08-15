package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.DataForTests;
import model.MainView;
import model.PersonalAccountView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestWayPersonalAccount extends BaseSetupWithUserCreation {
    DataForTests dataForTests = new DataForTests();

    @Test
    @DisplayName("Test personal account")
    @Description("Testing 'Личный кабинет' button")
    public void testPersonalAccountButton() {
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
        String actualResult = personalAccountView.getTextProfile();
        assertThat(actualResult, containsString("Профиль"));
    }
}