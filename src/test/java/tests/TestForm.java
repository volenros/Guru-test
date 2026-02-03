package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class TestForm extends BaseTest {

    private PracticeFormPage formPage;

    @BeforeEach
    void setUp() {
        formPage = new PracticeFormPage();
    }

    @Test
    void practiceFormTest() {
        formPage.openPage()
                .removeBanners()
                .setFirstName("Artur")
                .setLastName("Chernov")
                .setEmail("volenros@mail.ru")
                .selectGender("Male")
                .setPhone("1239812345")
                .setBirthDate("16", "July", "1992")
                .setSubject("English")
                .selectHobby("Music")
                .uploadPicture("cat.png")
                .setAddress("Gaivinskaya 30A")
                .selectStateAndCity("NCR", "Delhi")
                .submit()
                .checkResult("Student Name", "Artur Chernov")
                .checkResult("Student Email", "volenros@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1239812345")
                .checkResult("Date of Birth", "16 July,1992")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "cat.png")
                .checkResult("Address", "Gaivinskaya 30A")
                .checkResult("State and City", "NCR Delhi");
    }
}
