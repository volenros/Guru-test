import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://www.duckduckgo.com/");
        $("[name=q]").setValue("vk").pressEnter();
        $(".pAgARfGNTRe_uaK72TAD").shouldHave(text("vk.com"));
    }
}
