package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountView {
    private final WebDriver driver;
    private final By emailFieldClick = By.xpath(".//div/label[text()='Email']");
    private final By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private final By passwordFieldClick = By.xpath(".//div/label[text()='Пароль']");
    private final By passwordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registrationButton = By.xpath(".//p/a[text()='Зарегистрироваться']");
    private final By restorePasswordButton = By.xpath(".//p/a[text()='Восстановить пароль']");
    private final By constructorHeader = By.xpath(".//p[text()='Конструктор']");
    private final By logoHeaderIcon = By.className("AppHeader_header__logo__2D0X2");
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By loginHeader = By.xpath(".//div/h2[text()='Вход']");
    private final By profileOption = By.xpath(".//li[@class='Account_listItem__35dAP']/a[text()='Профиль']");
    public PersonalAccountView(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click 'Email' field")
    public void clickEmailField() {
        driver.findElement(emailFieldClick).click();
    }

    @Step("Populate 'Email' field")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Click 'Password' field")
    public void clickPasswordField() {
        driver.findElement(passwordFieldClick).click();
    }

    @Step("Populate 'Password' field")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Click on registration button")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Click on restore password button")
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    @Step("Click on 'Конструктор' button at the top of the page")
    public void clickConstructorButton() {
        driver.findElement(constructorHeader).click();
    }

    @Step("Click on logo icon at the top of the page")
    public void clickLogoIcon() {
        driver.findElement(logoHeaderIcon).click();
    }

    @Step("Click on exit button")
    public void clickLogoutButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Check the header of the login view")
    public String getTextLoginView() {
        return driver.findElement(loginHeader).getText();
    }

    @Step("Waiting for loading data")
    public void waitForLoadPage() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div/h2[text()='Вход']")));
    }

    @Step("Waiting for loading data")
    public void waitForProfilePage() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@class='Account_listItem__35dAP']/a[text()='Профиль']")));
    }

    @Step("Check the profile option in the personal account")
    public String getTextProfile() {
        return driver.findElement(profileOption).getText();
    }
}