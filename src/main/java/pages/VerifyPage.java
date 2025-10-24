package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import components.HeaderComponent;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;

public class VerifyPage {
    private final ElementsCollection code = elements(".code");
    private final SelenideElement info = element(".info");

//    Actions actions = new Actions(WebDriverRunner.getWebDriver());
//    actions.moveToElement(info).perform();

    public VerifyPage open() {
        Selenide.open("/verify-account");
        return this;
    }

    public VerifyPage enterCode(String value) {
        code.asFixedIterable().forEach(element -> element.setValue(value));
        return this;
    }

    public String getInfoText() {
        return info.getText();
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent();
    }
}
