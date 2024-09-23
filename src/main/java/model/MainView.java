package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainView {
    private final WebDriver driver;
    private final By loginButtonMainView = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By bunSection = By.xpath(".//div/span[text()='Булки']");
    private final By sauceSection = By.xpath(".//div/span[text()='Соусы']");
    private final By fillingSection = By.xpath(".//div/span[text()='Начинки']");
    private final By bunHeader = By.xpath(".//div/h2[text()='Булки']");
    private final By sauceHeader = By.xpath(".//div/h2[text()='Соусы']");
    private final By fillingHeader = By.xpath(".//div/h2[text()='Начинки']");
    private final By headerConstructor = By.xpath(".//h1[text()='Соберите бургер']");
    public MainView(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on login button at the main page")
    public void clickLoginOnMainView() {
        driver.findElement(loginButtonMainView).click();
    }

    @Step("Click on 'Personal Account' button at the main page")
    public void clickPersonalAccountMainView() {
        driver.findElement(personalAccount).click();
    }

    @Step("Select 'Bun' section at the main page")
    public void clickBunSectionMainView() {
        driver.findElement(bunSection).click();
    }

    @Step("Select 'Sauce' section at the main page")
    public void clickSauceSectionMainView() {
        driver.findElement(sauceSection).click();
    }

    @Step("Select 'Filling' section at the main page")
    public void clickFillingSectionMainView() {
        driver.findElement(fillingSection).click();
    }

    @Step("Check the header of the Bun section")
    public String getTextBunSection() {
        return driver.findElement(bunHeader).getText();
    }

    @Step("Waiting for loading data")
    public void waitForBunSection() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h2[text()='Булки']")));
    }

    @Step("Check the header of the Sauce section")
    public String getTextSauceSection() {
        return driver.findElement(sauceHeader).getText();
    }

    @Step("Waiting for loading data")
    public void waitForSauceSection() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div/h2[text()='Соусы']")));
    }

    @Step("Check the header of the Filling section")
    public String getTextFillingSection() {
        return driver.findElement(fillingHeader).getText();
    }

    @Step("Waiting for loading data")
    public void waitForFillingSection() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div/h2[text()='Начинки']")));
    }

    @Step("Check the header of the constructor")
    public String getTextConstructorHeader() {
        return driver.findElement(headerConstructor).getText();
    }

    @Step("Waiting for loading data")
    public void waitForLoadPage() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
    }
}