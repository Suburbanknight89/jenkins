package qa.guru.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DifferentsBetweenLocators {
    /*
    Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
    Если может - приведите пример, когда.
    */
    @Test
    void firstLocatorTest() {
        //открыть страницу selenide
        open("https://github.com/selenide/selenide");

        //запустить поиск $("h1 div")
        $("div h1").should(exist);
    }
    @Test
    void secondLocatorTest() {
        //открыть страницу selenide
        open("https://github.com/selenide/selenide");

        //запустить поиск $("h1").$("div")
        $("div").$("h1").should(exist);
    }
    /*
    Как видно из тестов - разница есть.
    Первый тест проходит, т.к. поиск вида $("h1 div") ищет div, в котором есть дочерний h1 (такой div на странице есть)
    Второй тест падает, т.к. пытается найти дочерний элемент h1 в первом же div на странице (такого элемента в первом div нет)
     */
}