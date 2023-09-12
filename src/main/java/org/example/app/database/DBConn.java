package org.example.app.database;

import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    public static Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(Constants.DB_DRIVER +
                    Constants.DB_BASE_URL + Constants.DB_NAME);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

