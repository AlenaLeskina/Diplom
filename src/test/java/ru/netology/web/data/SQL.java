package ru.netology.web.data;
import lombok.Getter;

import java.sql.*;

public class SQL {
    private static final String url = System.getProperty("dp.url");
    private static final String user = System.getProperty("dp.user");
    private static final String password = System.getProperty("dp.password");

    @Getter
    private static final String payTable = "payment_entity";
    @Getter
    private static final String creditTable = "credit_request_entity";


    public static void truncateTables() throws SQLException {
        String dropPaymentTables = "TRUNCATE public.payment_entity;";
        String dropCreditTables = "TRUNCATE public.credit_request_entity;";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropPaymentTables);
        statement.executeUpdate(dropCreditTables);
    }

    //получение статуса
    public static String getCardStatusPaymentGate(String payTable) {
        String status = "";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT status FROM " + payTable + " ;")) {
                while (resultSet.next()) status = resultSet.getString("status");
            }
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
        return status;
    }

    public static String getCardStatusCreditGate(String creditTable) {
        String status = "";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT status FROM " + creditTable + " ;")) {
                while (resultSet.next()) status = resultSet.getString("status");
            }
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
        return status;
    }
}