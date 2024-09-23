package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordView {
    private final WebDriver driver;
    private final By loginButton = By.xpath(".//p/a[text()='Войти']");

    public RestorePasswordView(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on login button from restore password view")
    public void clickLoginRestorePasswordView() {
        driver.findElement(loginButton).click();
    }
}