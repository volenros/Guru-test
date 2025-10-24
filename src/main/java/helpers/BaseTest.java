package helpers;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://qaplayground.dev/apps";
        Configuration.pageLoadStrategy = "eager";
    }
}
