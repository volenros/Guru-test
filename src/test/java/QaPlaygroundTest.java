import com.codeborne.selenide.*;
import helpers.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.VerifyPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QaPlaygroundTest extends BaseTest {

    @Test
    void verifyAccount() {
        VerifyPage verifyPage = new VerifyPage();

        verifyPage.open();
        verifyPage.enterCode("9");
        String infoText = verifyPage.getInfoText();

        new VerifyPage()
                .open()
                .getHeaderComponent();

        assertEquals("Success", infoText);
    }

    @Test
    void multiLevelDropdown() {
        open("/multi-level-dropdown");

        $$(".nav-item").last().click();
//        $$(".menu-item")
//        .asFixedIterable()
//        .stream()
//        .filter(element -> element.text().equals("Settings"))
//        .findFirst()
//        .get()
//        .click();
        $$(".menu-item").find(text("Settings")).click();

        $$(".menu-item").find(text("JavaScript")).click();

//        String result = $$(".menu-item").find(text("JavaScript")).getText();
        ElementsCollection result = $$(".menu-item");
        assertTrue(result.contains("JavaScript"));


//        assertEquals("JavaScript", result);
    }
}
