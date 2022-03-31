package ru.netology.web.page;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private final SelenideElement paymentGateButton = $(byText("Купить"));
    private final SelenideElement creditGateButton = $(byText("Купить в кредит"));

    public StartPage() {
        SelenideElement heading = $(byText("Путешествие дня"));
        heading.shouldBe(visible); }

    public PaymentGatePage paymentGate() {
        paymentGateButton.click();
        return new PaymentGatePage();
    }

    public CreditGatePage creditGate() {
        creditGateButton.click();
        return new CreditGatePage();
    }
}