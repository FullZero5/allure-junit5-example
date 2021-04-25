import controllers.UserController;
import io.qameta.allure.*;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.IOException;


@DisplayName("Проверка АПИ")
public class SampleTestCase {
    private UserController userController;

    @BeforeEach
    public void setUp() {
        userController = new UserController();
    }

    @Test
    @DisplayName("╯°□°）╯-1")
    @Epic("Epic1")
    @Feature("Test API - url")
    @Story("Start")
    @Owner(value = "Пупкин Валерий Иванович")
    @Description("Тестирование")
    public void testUserInfoResponse() {
        checkUrl("FullZero5");
    }
    @Step("Проверка что remoteUser содержит определенное имя {userName}")
    private void checkUrl(String userName) {
        User remoteUser = userController.getUserByUsername(userName);
        assertTrue(remoteUser.getHtml_url().contains("https://github.com/FullZero5"), () -> "Путь содержит https://github.com/FullZero5");
    }

    @Test
    @DisplayName("╯°□°）╯-2")
    @Epic("Epic2")
    @Feature("Test API - followers length")
    @Story("Start")
    public void testFollowers() {
        User[] followers = userController.getFollowersByUser("FullZero5");
        assertEquals(followers.length, 4, "Количестов фоловеров равно");
    }
}