package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;

public class ResultModalComponent {

    private final String TABLE = ".table-responsive";

    public ResultModalComponent checkResult(String key, String value) {
        $(TABLE).$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
