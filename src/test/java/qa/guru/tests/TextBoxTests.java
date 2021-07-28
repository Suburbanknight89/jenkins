package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.tests.pages.RegistrationPage;

public class TextBoxTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }
    String firstName = "Somebody";
    String lastName = "ToLove";
    String email = "Bogdan@mail.ru";
    String gender = "Male";
    String phone = "2141241242";
    String day = "28";
    String month = "April";
    String year = "1989";
    String subjects = "Maths";
    String hobbies = "Reading";
    String picture = "KNPP1020.970.jpg";
    String adress = "Moscow region, Kraskovo county";
    String state = "NCR";
    String city = "Delhi";


    @Test
    void positiveFillTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName).
                typeLastName(lastName).
                typeEmail(email).
                selectGender(gender).
                typePhone(phone).
                setDateOfBirth(day, month, year).
                typeSubjects(subjects).
                typeHobbies(hobbies).
                uploadFile(picture).
                typeAdress(adress).
                selectState(state).
                selectCity(city).submit();


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
            }
}
