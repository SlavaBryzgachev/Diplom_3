package ru.yandex.praktikum.pom;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
public class HomePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = "//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement bun;
    @FindBy(how = How.XPATH, using = "//div/span[text() = 'Соусы']")
    private SelenideElement sause;
    @FindBy(how = How.XPATH,using = "//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement selectedSause;
    @FindBy(how = How.XPATH, using = "//div/span[text() = 'Начинки']")
    private SelenideElement filling;
    @FindBy(how = How.XPATH, using = "//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement selectedFilling;

    public LoginPage clickAccountButton() {
        accountButton.click();
        return page(LoginPage.class);
    }

    public AccountPage clickAccountButtonGoAccountPage() {
        accountButton.click();
        return page(AccountPage.class);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    public String findBunIngredient() {
        return bun.getAttribute("class");
    }
    public HomePage clickSauseIngredient(){
        sause.click();
        return page(HomePage.class);
    }
    public String findSauceIngredient() {
        return selectedSause.getAttribute("class");
    }
    public HomePage clickFillingIngredient() {
        filling.click();
        return page(HomePage.class);
    }
    public String findFillingIngredient() {
        return selectedFilling.getAttribute("class");
    }
}

