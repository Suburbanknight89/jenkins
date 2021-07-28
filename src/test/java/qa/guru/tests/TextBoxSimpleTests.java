package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxSimpleTests {
    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").val("Bogdan");
        $("#lastName").val("Shvets");
        $("#userEmail").val("Bogdan@mail.ru");
        $("[name=gender][value=Male]").parent().click();
        $("#userNumber").val("7412589632");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").val("Maths").pressEnter();
        $("#subjectsInput").val("Social Studies").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/main/resources/KNPP1020.970.jpg"));
        $("#currentAddress").val("Moscow region, Kraskovo county");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Bogdan"));
        $(".table-responsive").shouldHave(text("Shvets"));
        $(".table-responsive").shouldHave(text("Bogdan@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7412589632"));
        $(".table-responsive").shouldHave(text("28"));
        $(".table-responsive").shouldHave(text("April"));
        $(".table-responsive").shouldHave(text("1989"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Social Studies"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("KNPP1020.970.jpg"));
        $(".table-responsive").shouldHave(text("Moscow region, Kraskovo county"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Delhi"));

    }

}
