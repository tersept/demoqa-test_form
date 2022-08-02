package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PractiiceFormTest {
    @BeforeAll
    static void configure(){
        //Configuration.browserSize = '1300x952';
    }

    @Test
    void fillForm(){
    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue("Irina");
    $("#lastName").setValue("Testova");
    $("#userEmail").setValue("test@test.ru");
    $(byText("Female")).click();
    $("#userNumber").setValue("123456789");
    $("#dateOfBirthInput").click();
    $("[class=react-datepicker__year-select]").selectOptionByValue("2000");
    $("[class=react-datepicker__month-select]").selectOptionByValue("4");
    $(".react-datepicker__day--019").click();

        $("#dateOfBirthInput").click();
    }
}
