package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationView {
    private final WebDriver driver;
    private final By nameFieldClick = By.xpath(".//div/label[text()='Имя']");
    private final By nameField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private final By emailFieldClick = By.xpath(".//div/label[text()='Email']");
    private final By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private final By passwordFieldClick = By.xpath(".//div/label[text()='Пароль']");
    private final By passwordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath(".//p/a[text()='Войти']");
    private final By incorrectPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");
    public RegistrationView(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on user name field")
    public void clickNameField() {
        driver.findElement(nameFieldClick).click();
    }

    @Step("Populate user name field")
    public void setUserName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Click on email field")
    public void clickEmailField() {
        driver.findElement(emailFieldClick).click();
    }

    @Step("Populate email field")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Click on password field")
    public void clickPasswordField() {
        driver.findElement(passwordFieldClick).click();
    }

    @Step("Populate password field")
    public void setPasswordField(String correctPassword) {
        driver.findElement(passwordField).sendKeys(correctPassword);
    }

    @Step("Click on Registration button")
    public void clickOnRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Check the message about incorrect password")
    public String getMessageIncorrectPassword() {
        return driver.findElement(incorrectPasswordMessage).getText();
    }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
}
