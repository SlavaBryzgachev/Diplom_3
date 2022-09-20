package ru.yandex.praktikum.pom;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.praktikum.pom.LoginPage;

import static com.codeborne.selenide.Selenide.page;
public class ForgotPasswordPage {
@FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
private SelenideElement loginLink;
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
