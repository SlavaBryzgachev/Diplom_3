import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.HomePage;
import ru.yandex.praktikum.User.User;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;

public class UserLoginTest {
    private User user;
    private HomePage homePage;
    private String accessToken;
    private ValidatableResponse response;

    @Before
    public void setUp() {
        user = User.getRandomUser();
        response = user.createUser(user);
        accessToken = response.extract().path("accessToken");
    }
    @After
    public void clearState() {
        user.deleteUser(StringUtils.substringAfter(accessToken, " "));
        user = null;
        Selenide.clearBrowserLocalStorage();
    }
    @Test
    @DisplayName("Вход пользователя через кнопку Войти в аккаунт")
    public void loginUserByLoginButton() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Вход пользователя через кнопку личный кабинет")
    public void loginUserByAccountButton() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginUserByRegisterPage() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .clickLoginLink()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginUserByForgotPasswordPage() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickForgotPasswordLink()
                .clickLoginLink()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        assertFalse(isDisplayed);
    }
}
