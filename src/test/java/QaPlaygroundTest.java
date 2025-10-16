import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QaPlaygroundTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://qaplayground.dev/apps";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void verifyAccount() {
        open("/verify-account"); // Arrange

        $$(".code").asFixedIterable().forEach(element -> element.setValue("9")); // Act

        $(".info").shouldHave(text("Success")); // Assert
    }

    @Test
    void multiLevelDropdown() {
        open("/multi-level-dropdown");

        $$(".nav-item").last().click();
//        $$(".menu-item").asFixedIterable().stream().filter(element -> element.text().equals("Settings")).findFirst().get().click();
        $$(".menu-item").find(text("Settings")).click();

        $$(".menu-item").find(text("JavaScript")).click();

//        String result = $$(".menu-item").find(text("JavaScript")).getText();
        ElementsCollection result = $$(".menu-item");
        assertTrue(result.contains("JavaScript"));


//        assertEquals("JavaScript", result);
    }
}
