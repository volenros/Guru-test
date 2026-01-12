package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //ввод значений
        $("#firstName").setValue("Artur");
        $("#lastName").setValue("Chernov");
        $("#userEmail").setValue("volenros@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1239812345");

        //дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("July");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--016:not(.react-datepicker__day--outside-month)").click();

        //ввод subject
        $("#subjectsContainer input").setValue("English").pressEnter();

        //выбор хобби
        $("#hobbiesWrapper").$(byText("Music")).click();

        //загрузка изображения
        $("#uploadPicture").uploadFromClasspath("cat.png");

        //ввод текущего адреса
        $("#currentAddress").setValue("Gaivinskaya 30A");

        //выбор штата и города
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //отправка формы
        $("#submit").click();

        //проверка формы
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Artur Chernov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("volenros@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1239812345"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("16 July,1992"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("cat.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("aivinskaya 30A"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
