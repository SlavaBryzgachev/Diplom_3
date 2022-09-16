import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.HomePage;

import static com.codeborne.selenide.Selenide.getFocusedElement;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class BurgerCostructorTest {
    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = open(HomePage.URL, HomePage.class);
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void navigateToBunIngredient() {
         boolean isDisplayed = homePage.findBunIngredient();
         assertTrue(isDisplayed);

    }
    @Test
    @DisplayName("Переход к разделу Соусы")
    public void navigateToSauceIngredient() {
        boolean isDisplayed = homePage.findSauceIngredient();
        assertTrue(isDisplayed);
    }
    @Test
    @DisplayName("Переход к разделу Начинки")
    public void navigateToFillingIngredient() {
        boolean isDisplayed = homePage.findFillingIngredient();
        assertTrue(isDisplayed);
    }
}
