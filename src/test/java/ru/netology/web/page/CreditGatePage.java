package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;

public class CreditGatePage {
    private final SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("input[placeholder='08']");
    private final SelenideElement yearField = $("input[placeholder='22']");
    private final ElementsCollection userField = $$(".input__control");
    private final SelenideElement cardUser = userField.get(3);
    private final SelenideElement cvvField = $("[placeholder='999']");
    private final SelenideElement continueButton = $(byText("Продолжить"));
    private final SelenideElement success = $(byText("Операция одобрена Банком."));
    private final SelenideElement failure = $(byText("Банк отказал в проведении операции"));
    private final SelenideElement invalidDates = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement invalidDatesLessNow = $(byText("Истёк срок действия карты"));
    private final SelenideElement invalidUser = $(byText("Владелец на найден"));
    private final SelenideElement invalidCVV = $(byText("Неверный формат"));
    private final SelenideElement requiredField = $(byText("Поле обязательно для заполнения"));

    public CreditGatePage() {
        SelenideElement heading = $(byText("Кредит по данным карты"));
        heading.shouldBe(Condition.visible);}

    public void cardData(DataHelper.PayInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getCardFinalMonth());
        yearField.setValue(info.getCardFinalYear());
        cardUser.setValue(info.getUser());
        cvvField.setValue(info.getCvvCode());
        continueButton.click();
    }

    public void successMessage() {
        success.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void failureMessage() {
        failure.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void failureMonthOrYear() {
        invalidDates.shouldBe(visible);
    }

    public void failureYearLessNow() {
        invalidDatesLessNow.shouldBe(visible);
    }

    public void failureUser() {
        invalidUser.shouldBe(visible);
    }

    public void failureCVV() {
        invalidCVV.shouldBe(visible);
    }

    public void emptyFields() {
        continueButton.click();
    }

    public void failureEmptyFields() {
        invalidCVV.shouldBe(visible);
        requiredField.shouldBe(visible);
    }
}
