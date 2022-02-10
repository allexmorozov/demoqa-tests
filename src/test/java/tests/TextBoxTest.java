package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() throws Exception {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));


        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@super.com");
        $("#currentAddress").setValue("address 1");
        $("#permanentAddress").setValue("address 2");
        $("#submit").click();

        $("#output").shouldHave(text("Alex"), text("alex@super.com"), text("address 1"),
                text("address 2"));





    }
}

