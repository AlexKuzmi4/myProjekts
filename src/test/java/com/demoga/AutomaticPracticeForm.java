package com.demoga;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomaticPracticeForm {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void automaticPracticeForm () {
        String userName = "Alex";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Kuzmi4");
        $("#userEmail").setValue("kuzm5@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#gender-radio-1").parent().click();
      //  $("#gender-radio-1").parent().click(); // also check radiobutton
        $("#genterWrapper").$(byText("Male")).click(); //best
      //  $(byText("Male")).click(); тоже способ активировать радиобаттон
      //  $("label[for=gender-radio-1]").click(); also posiible
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
      //  $(".react-datepicker__month-select").selectOptionByValue("8"); so also can choose "August" in select
        $(".react-datepicker__year-select").selectOption("1968");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click(); // found differnts from dates in datapickers
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click(); // so to test check-boxes
       // $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png")); // it's also the method for upload files
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Gazetnaya 88");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Kuzmi4"), text("kuzm5@mail.ru") );



      //  $(".subjects-auto-complete__input").setValue("QA");

       // <div class="react-datepicker__day react-datepicker__day--001"
       // <div class="react-datepicker__day react-datepicker__day--001 react-datepicker__day--selected react-datepicker__day--weekend react-datepicker__day--outside-month"  aria-label="Choose Sunday, September 1st, 2024"





    }
}
