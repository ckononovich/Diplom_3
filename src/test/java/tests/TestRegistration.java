package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.DataForTests;
import model.MainView;
import model.PersonalAccountView;
import model.RegistrationView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestRegistration extends BaseSetupWithoutUserCreation {

    DataForTests dataForTests = new DataForTests();

    @Test
    @DisplayName("Test registration")
    @Description("Test registration with correct password")
    public void testRegistrationCorrectPassword() {
        MainView mainView = new MainView(driver);
        mainView.clickPersonalAccountMainView();

        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickRegistrationButton();

        RegistrationView registrationView = new RegistrationView(driver);
        registrationView.clickNameField();
        registrationView.setUserName(dataForTests.getName());
        registrationView.clickEmailField();
        registrationView.setEmailField(dataForTests.getEmail());
        registrationView.clickPasswordField();
        registrationView.setPasswordField(dataForTests.getPassword());
        registrationView.clickOnRegistrationButton();
        personalAccountView.waitForLoadPage();
        String headerText = personalAccountView.getTextLoginView();
        assertThat(headerText, containsString("Вход"));
    }

    @Test
    @DisplayName("Test registration")
    @Description("Test registration with wrong password")
    public void testRegistrationWrongPassword() {
        MainView mainView = new MainView(driver);
        mainView.clickPersonalAccountMainView();

        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickRegistrationButton();

        RegistrationView registrationView = new RegistrationView(driver);
        registrationView.clickNameField();
        registrationView.setUserName(dataForTests.getName());
        registrationView.clickEmailField();
        registrationView.setEmailField(dataForTests.getEmail());
        registrationView.clickPasswordField();
        registrationView.setPasswordField(dataForTests.getWrongPassword());
        registrationView.clickOnRegistrationButton();
        String wrongPassword = registrationView.getMessageIncorrectPassword();
        assertThat(wrongPassword, containsString("Некорректный пароль"));
    }
}
