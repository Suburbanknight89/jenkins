package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.tests.pages.RegistrationPage;
import qa.guru.tests.utils.RandomUtils;
import java.text.DecimalFormat;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TextBoxTestsWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    RandomUtils ru = new RandomUtils();
    DecimalFormat dF = new DecimalFormat("00");

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender =  ru.getRandomGender();
    String phone = faker.numerify("79########");
    String day = dF.format(faker.random().nextInt(1, 28));
    String month = ru.getRandomMonth();
    String year = faker.random().nextInt(1900, 2100).toString();
    String subjects = ru.getRandomSubject();
    String hobbies = ru.getRandomHobby();
    String picture = ru.getRandomPicture();
    String adress = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";


    @Test
    void positiveFillTest(){
        step("Open students registration form", () ->{
            registrationPage.openPage();
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });

        step("Fill students registration form", () -> {
            step("Fill common data", () -> {
                registrationPage.typeFirstName(firstName).
                        typeLastName(lastName).
                        typeEmail(email).
                        selectGender(gender).
                        typePhone(phone);
            });

            step("Set date", () -> {
                registrationPage.setDateOfBirth(day, month, year);
            });

            step("Set subjects", () -> {
                registrationPage.typeSubjects(subjects);
            });
            step("Set hobbies", () -> {
                registrationPage.typeHobbies(hobbies);
            });
            step("Upload image", () ->
                    registrationPage.uploadFile(picture));
            step("Set address", () -> {
                registrationPage.typeAdress(adress).
                        selectState(state).
                        selectCity(city);
            });
            step("Submit form", () ->
                    $("#submit").click());
        });

        step("Verify successful form submit", () -> {
            registrationPage.checkResultsTitle();
            registrationPage.checkResultsValue(firstName + " " + lastName)
                    .checkResultsValue(email)
                    .checkResultsValue(gender)
                    .checkResultsValue(phone)
                    .checkResultsValue(day + " " + month + "," + year)
                    .checkResultsValue(subjects)
                    .checkResultsValue(hobbies)
                    .checkResultsValue(picture)
                    .checkResultsValue(adress)
                    .checkResultsValue(state + " " + city);
        });
    }

}