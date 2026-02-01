package pages;

import pages.locators.PracticeFormLocators;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalPage {

    // Проверка одного поля
    public ResultModalPage checkResult(String key, String value) {
        $(PracticeFormLocators.RESULT_TABLE)
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}
