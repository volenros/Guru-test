package pages;

import pages.components.CalendarComponent;
import pages.locators.PracticeFormLocators;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final CalendarComponent calendar = new CalendarComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        removeBanners();
        return this;
    }

    public PracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        $(PracticeFormLocators.FIRST_NAME).setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        $(PracticeFormLocators.LAST_NAME).setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        $(PracticeFormLocators.EMAIL).setValue(value);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $(PracticeFormLocators.GENDER_WRAPPER).$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setPhone(String value) {
        $(PracticeFormLocators.PHONE).setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $(PracticeFormLocators.DATE_INPUT).click();
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        $(PracticeFormLocators.SUBJECT_INPUT).setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        $(PracticeFormLocators.HOBBIES_WRAPPER).$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        $(PracticeFormLocators.UPLOAD_PICTURE).uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        $(PracticeFormLocators.ADDRESS).setValue(address);
        return this;
    }

    public PracticeFormPage selectStateAndCity(String state, String city) {
        $(PracticeFormLocators.STATE).click();
        $(PracticeFormLocators.STATE_CITY_WRAPPER).$(byText(state)).click();
        $(PracticeFormLocators.CITY).click();
        $(PracticeFormLocators.STATE_CITY_WRAPPER).$(byText(city)).click();
        return this;
    }

    public ResultModalPage submit() {
        $(PracticeFormLocators.SUBMIT).click();
        return new ResultModalPage();
    }
}
