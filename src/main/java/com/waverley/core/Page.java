package com.waverley.core;

import static com.codeborne.selenide.Selenide.open;

/**
 * Key interface for PageObjects, which defines common actions.
 */
public interface Page {

    default Page navigateTo() {
        open(url());
        return this;
    }

    default String url() {
        return "https://waverleybooking.github.io";
    }
}