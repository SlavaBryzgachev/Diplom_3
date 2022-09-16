package ru.yandex.praktikum.pom;

import com.codeborne.selenide.ElementsCollection;
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
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__list__2A-mT")
    private ElementsCollection menuIngredients;
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
    public boolean findBunIngredient() {
        SelenideElement bun = menuIngredients.get(0).lastChild();
        bun.scrollIntoView(true);
        bun.click();
        return bun.isEnabled();
    }
    public boolean findSauceIngredient() {
        SelenideElement sauce = menuIngredients.get(1).lastChild();
        sauce.scrollIntoView(true);
        sauce.click();
        return sauce.isEnabled();
    }

    public boolean findFillingIngredient() {
        SelenideElement filling = menuIngredients.get(2).lastChild();
        filling.scrollIntoView(true);
        filling.click();
        return filling.isEnabled();
    }
}
