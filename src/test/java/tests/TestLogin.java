package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestLogin extends BaseSetupWithUserCreation {

    DataForTests dataForTests = new DataForTests();

    @Test
    @DisplayName("Test login")
    @Description("Login by clicking on the button from the main view")
    public void testLoginMainViewButton() {
        MainView mainView = new MainView(driver);
        mainView.clickLoginOnMainView();
        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickEmailField();
        personalAccountView.setEmailField(dataForTests.getEmail());
        personalAccountView.clickPasswordField();
        personalAccountView.setPasswordField(dataForTests.getPassword());
        personalAccountView.clickLoginButton();
        mainView.waitForLoadPage();
        String actualResult = mainView.getTextConstructorHeader();
        assertThat(actualResult, containsString("Соберите бургер"));
    }

    @Test
    @DisplayName("Test login")
    @Description("Login by clicking on the button 'Личный кабинет' on the main view")
    public void testLoginPersonalAccountButton() {
        MainView mainView = new MainView(driver);
        mainView.clickPersonalAccountMainView();
        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickEmailField();
        personalAccountView.setEmailField(dataForTests.getEmail());
        personalAccountView.clickPasswordField();
        personalAccountView.setPasswordField(dataForTests.getPassword());
        personalAccountView.clickLoginButton();
        mainView.waitForLoadPage();
        String actualResult = mainView.getTextConstructorHeader();
        assertThat(actualResult, containsString("Соберите бургер"));
    }

    @Test
    @DisplayName("Test login")
    @Description("Login by clicking on the login button from the registration view")
    public void testLoginRegistrationView() {
        MainView mainView = new MainView(driver);
        mainView.clickPersonalAccountMainView();
        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickRegistrationButton();

        RegistrationView registrationView = new RegistrationView(driver);
        registrationView.clickOnLoginButton();

        personalAccountView.clickEmailField();
        personalAccountView.setEmailField(dataForTests.getEmail());
        personalAccountView.clickPasswordField();
        personalAccountView.setPasswordField(dataForTests.getPassword());
        personalAccountView.clickLoginButton();
        mainView.waitForLoadPage();
        String actualResult = mainView.getTextConstructorHeader();
        assertThat(actualResult, containsString("Соберите бургер"));
    }

    @Test
    @DisplayName("Test login")
    @Description("Login by clicking on the login button from the restore password view")
    public void testLoginRestorePasswordView() {
        MainView mainView = new MainView(driver);
        mainView.clickPersonalAccountMainView();
        PersonalAccountView personalAccountView = new PersonalAccountView(driver);
        personalAccountView.clickRestorePasswordButton();

        RestorePasswordView restorePasswordView = new RestorePasswordView(driver);
        restorePasswordView.clickLoginRestorePasswordView();

        personalAccountView.clickEmailField();
        personalAccountView.setEmailField(dataForTests.getEmail());
        personalAccountView.clickPasswordField();
        personalAccountView.setPasswordField(dataForTests.getPassword());
        personalAccountView.clickLoginButton();
        mainView.waitForLoadPage();
        String actualResult = mainView.getTextConstructorHeader();
        assertThat(actualResult, containsString("Соберите бургер"));
    }
}