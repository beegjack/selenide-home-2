package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.CollectionCondition;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @BeforeAll
    static void beforeAll() {
        open("https://github.com/");
        Configuration.browserSize = "1280x720";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void comparePlans(){
        $(byText("Pricing")).hover();
        $(".dropdown-menu a[href='/pricing#compare-features']").click();
        $$("h1.h2-mktg").shouldHave(CollectionCondition.textsInAnyOrder("Choose the plan that’s right for you."));
    }

}