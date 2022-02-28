import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebitCardOrderTest {
    @Test
    void shouldPlaceOrder () {
        open("http://localhost:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[Data-test-id=name] input").setValue("Иванов Иван");
        form.$("[Data-test-id=phone] input").setValue("+79998887766");
        form.$(By.className("checkbox__box")).click();
        form.$(By.tagName("button")).click();
        $("[Data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
