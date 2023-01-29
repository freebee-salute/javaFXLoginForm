package com.example.loginForm;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "USERACCOUNTS";
        String url = "jdbc:derby:memory:" + databaseName + ";create=true;";

        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            databaseLink = DriverManager.getConnection(url);

            Statement stmt = databaseLink.createStatement();

            setupDB(stmt);

        } catch (Exception e) {
        }
        return databaseLink;
    }

    private void setupDB(Statement statement) throws SQLException {
        statement.execute("create TABLE UserAccounts " +
                "(idUserAccount int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1) ," +
                " FirstName varchar(50) not null ," +
                " LastName varchar(50) not null ," +
                " UserName varchar(50) unique not null ," +
                " Password varchar(50) not null)"
        );
        statement.execute("insert into USERACCOUNTS (Firstname, LASTNAME,USERNAME,PASSWORD) " +
                "values ('Test', 'Tester', 'test', 'test')");
        statement.execute("insert into USERACCOUNTS (Firstname, LASTNAME,USERNAME,PASSWORD) " +
                "values ('Zweiter', 'Muller', 'zmuller', 'password')");
    }


}
