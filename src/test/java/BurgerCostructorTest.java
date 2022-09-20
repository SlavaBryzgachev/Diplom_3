import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.HomePage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.getFocusedElement;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
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
        String isSelected = homePage.findBunIngredient();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        Assert.assertEquals(expected,isSelected);
    }
    @Test
    @DisplayName("Переход к разделу Соусы")
    public void navigateToSauceIngredient() {
        homePage.clickSauseIngredient();
        String isSelected = homePage.findSauceIngredient();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        Assert.assertEquals(expected, isSelected);
    }
    @Test
    @DisplayName("Переход к разделу Начинки")
    public void navigateToFillingIngredient() {
        homePage.clickFillingIngredient();
        String isSelected = homePage.findFillingIngredient();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        Assert.assertEquals(expected, isSelected);
    }
}
