import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.User.GenerateUser;
import ru.yandex.praktikum.pom.HomePage;
import ru.yandex.praktikum.User.User;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class UserAccountTest {
    private User user;
    private HomePage homePage;
    @Before
    public void setUp() {
        user = GenerateUser.getRandomUser();
        homePage = open(HomePage.URL, HomePage.class);
        homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);
        homePage = null;
    }
    @After
    public void clearState() {
        user = null;
        Selenide.clearBrowserLocalStorage();
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void transitionToConstructor() {
        homePage = open(HomePage.URL, HomePage.class);
        String url = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton()
                .clickConstructor();
        assertEquals(HomePage.URL, url);
    }
    @Test
    @DisplayName("Переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void transitionToLogoBurger() {
        homePage = open(HomePage.URL, HomePage.class);
        String url = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton()
                .clickLogoBurger();
        assertEquals(HomePage.URL, url);
    }
    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutUserByLogoutButton() {
        homePage = open(HomePage.URL, HomePage.class);
        homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        boolean isDisplayed = homePage.clickAccountButtonGoAccountPage()
                .clickLogoutButton(Condition.hidden);
        assertFalse(isDisplayed);
    }
}
