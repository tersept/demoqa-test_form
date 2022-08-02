package com.demoqa;


import com.codeborne.selenide.Configuration;
import io.netty.handler.codec.http.multipart.FileUpload;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PractiiceFormTest {
    @BeforeAll
    static void configure() {
        Configuration.browserSize = "650x952";
    }

    @Test
    void fillForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Testova");
        $("#userEmail").setValue("test@test.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("9091234455");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOptionByValue("2000");
        $("[class=react-datepicker__month-select]").selectOptionByValue("4");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resource/test.jpg"));
        $("#currentAddress").setValue("Moscow");
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Irina Testova"),
                text("test@test.ru"),
                text("Female"),
                text("9091234455"),
                text("Maths"),
                text("Reading"),
                text("test.jpg"),
                text("Moscow"),
                text("Haryana Karnal"));
    }
}
