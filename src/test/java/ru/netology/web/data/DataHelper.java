package ru.netology.web.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
public class DataHelper {

    @Value
    public static class PaymentGateInfo {
    }

    @Value
    @AllArgsConstructor
    public static class PayInfo {
        String cardNumber;
        String cardFinalMonth;
        String cardFinalYear;
        String user;
        String cvvCode;
    }

    public static PayInfo getSuccessPayData() {
        return new PayInfo("4444444444444441", "12", "24", "Elena Leskina", "999");
    }

    public static PayInfo getFailurePayData() {
        return new PayInfo("4444444444444442", "12", "24", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidMonthMore12SuccessCard() {
        return new PayInfo("4444444444444441", "14", "24", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidMonthMore12FailureCard() {
        return new PayInfo("4444444444444442", "14", "24", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidMonthLess01SuccessCard() {
        return new PayInfo("4444444444444441", "00", "24", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidMonthLess01FailureCard() {
        return new PayInfo("4444444444444442", "00", "24", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidYearMoreSuccessCard() {
        return new PayInfo("4444444444444441", "12", "28", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidYearMoreFailureCard() {
        return new PayInfo("4444444444444442", "12", "28", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidYearLessSuccessCard() {
        return new PayInfo("4444444444444441", "12", "20", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidYearLessFailureCard() {
        return new PayInfo("4444444444444442", "12", "20", "Elena Leskina", "999");
    }

    public static PayInfo getInvalidUserSuccessCard() {
        return new PayInfo("4444444444444441", "12", "24", "Елена", "999");
    }

    public static PayInfo getInvalidUserFailureCard() {
        return new PayInfo("4444444444444442", "12", "24", "Елена", "999");
    }

    public static PayInfo getInvalidCVVSuccessCard() {
        return new PayInfo("4444444444444441", "12", "24", "Elena Leskina", "99");
    }

    public static PayInfo getInvalidCVVFailureCard() {
        return new PayInfo("4444444444444442", "12", "24", "Elena Leskina", "99");
    }


    @Value
    @AllArgsConstructor
    public static class APIPayInfo {
        String number;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static APIPayInfo getAPISuccessCardData() {
        return new APIPayInfo("4444 4444 4444 4441", "12", "24", "Elena Leskina", "999");
    }

    public static APIPayInfo getAPIFailCardData() {
        return new APIPayInfo("4444 4444 4444 4442", "12", "24", "Elena Leskina", "999");
    }
}
