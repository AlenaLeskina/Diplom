package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQL;
import ru.netology.web.page.StartPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() throws SQLException {
        open("http://localhost:8080");
        SQL.truncateTables();
    }

    @Test
    void shouldFailPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getFailurePayData();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMessage();
        assertEquals("DECLINED", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldSuccessCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getSuccessPayData();
        creditGatePage.cardData(payInfo);
        creditGatePage.successMessage();
        assertEquals("APPROVED", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getFailurePayData();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMessage();
        assertEquals("DECLINED", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailMonthMore12SuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthMore12SuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailMonthMore12FailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthMore12FailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailMonthMore12SuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthMore12SuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
        assertEquals("",SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailMonthMore12FailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthMore12FailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailMonthLess01SuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthLess01SuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailMonthLess01FailCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthLess01FailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailMonthLess01SuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthLess01SuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailMonthLess01FailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthLess01FailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailYearMoreSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearMoreSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailYearMoreFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearMoreFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailYearMoreSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearMoreSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailYearMoreFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearMoreFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailYearLessSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearLessSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureYearLessNow();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailYearLessFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearLessFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureYearLessNow();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailYearLessSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearLessSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureYearLessNow();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailYearLessFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearLessFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureYearLessNow();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailUserSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidUserSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureUser();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailUserFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidUserFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureUser();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailUserSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidUserSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureUser();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailUserFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidUserFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureUser();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailCVVSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidCVVSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureCVV();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailCVVFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidCVVFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureCVV();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailCVVSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidCVVSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureCVV();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailCVVFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidCVVFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureCVV();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @Test
    void shouldFailEmptyFieldsPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        paymentGatePage.emptyFields();
        paymentGatePage.failureEmptyFields();
        assertEquals("", SQL.getCardStatusPaymentGate(SQL.getPayTable()));
    }

    @Test
    void shouldFailEmptyFieldsCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        creditGatePage.emptyFields();
        creditGatePage.failureEmptyFields();
        assertEquals("", SQL.getCardStatusCreditGate(SQL.getCreditTable()));
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
}
