package org.example.app.repositories;

import org.example.app.database.DBConn;
import org.example.app.entities.User;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCreateRepository {

    private static final Logger LOGGER =
            Logger.getLogger(UserCreateRepository.class.getName());

    public String createUser(User user) {
        String sql = "INSERT INTO " + Constants.TABLE_USERS + "(name, phone, email) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());
            pstmt.setString(3, user.getEmail());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}