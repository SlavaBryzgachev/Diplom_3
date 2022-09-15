import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.HomePage;
import ru.yandex.praktikum.User.User;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class UserRegisterTest {
    private User user;
    private HomePage homePage;
    @Before
    public void setUp() {
        user = User.getRandomUser();
        homePage = open(HomePage.URL, HomePage.class);
    }
    @After
    public void clearState() {
        user = null;
        Selenide.clearBrowserLocalStorage();
    }
    @Test
    @DisplayName("Регистрация пользователя с верными данными")
    public void registerUserByValidCredentials() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);

        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Регистрация пользователя с неверным паролем")
    public void registerUserByInvalidPassword() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), "888")
                .clickRegisterButton(Condition.visible);

        assertTrue(isDisplayed);
    }
    @Test
    @DisplayName("Аннотация о неверном пароле")
    public void registerUserIsDisplayedPasswordError() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), "888")
                .isDisplayedPasswordError();

        assertTrue(isDisplayed);
    }
}
