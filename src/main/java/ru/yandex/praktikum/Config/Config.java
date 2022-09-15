package ru.yandex.praktikum.Config;
import static io.restassured.http.ContentType.JSON;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
public class Config {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    protected RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}
