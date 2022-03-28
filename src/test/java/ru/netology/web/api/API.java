package ru.netology.web.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.netology.web.data.DataHelper;
import static io.restassured.RestAssured.*;

public class API {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String APIPaymentGateApprovedCard (DataHelper.APIPayInfo apiPayInfo) {
      return given()
                .spec(requestSpec)
                .body(apiPayInfo)
        .when()
                .post("/api/v1/pay")
        .then()
              .statusCode(200)
              .extract().response().asString();
    }

    public static String APICreditGateApprovedCard (DataHelper.APIPayInfo apiPayInfo) {
        return given()
                .spec(requestSpec)
                .body(apiPayInfo)
        .when()
                .post("/api/v1/credit")
        .then()
                .statusCode(200)
                .extract().response().asString();
    }

    public static String APICreditGateDeclinedCard (DataHelper.APIPayInfo apiPayInfo) {
        return given()
                .spec(requestSpec)
                .body(apiPayInfo)
        .when()
                .post("/api/v1/credit")
        .then()
                .statusCode(200)
                .extract().response().asString();
    }
}
