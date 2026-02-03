package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormMini extends BaseTest {

    private PracticeFormPage formPage;

    @BeforeEach
    void setUp() {
        formPage = new PracticeFormPage();
    }

    @Test
    void minimalFormTest() {
        formPage.openPage()
                .removeBanners()
                .setFirstName("Anna")
                .setLastName("Ivanova")
                .selectGender("Female")
                .setPhone("1234567890")
                .submit()
                .checkResult("Student Name", "Anna Ivanova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890");
    }

    @Test
    void negativeFormTest() {
        formPage.openPage()
                .removeBanners()
                .setLastName("Petrov")
                .selectGender("Male")
                .setPhone("9876543210")
                .submit();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
