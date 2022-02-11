package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Frost");
        $("#userEmail").setValue("alex@work.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("May");
        $(byText("8")).click();
        $("#subjectsInput").setValue("civics");
        $(byText("Civics")).click();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("raja.jpg");
        $("#currentAddress").setValue("Lenina street 22");
        $("#stateCity-label").scrollTo();
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Alex"),
                                                   text("Frost"),
                                                   text("alex@work.com"),
                                                   text("Male"),
                                                   text("1111111111"),
                                                   text("8 May,1991"),
                                                   text("Civics"),
                                                   text("Sports, Music"),
                                                   text("Lenina street 22"),
                                                   text("Haryana Karnal"));


    }
}
