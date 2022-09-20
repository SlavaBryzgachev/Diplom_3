import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.praktikum.pom.HomePage;
import ru.yandex.praktikum.User.User;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class UserAccountTest {
    private  User user;
    private HomePage homePage;
    private  String accessToken;
    private  ValidatableResponse response;
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
