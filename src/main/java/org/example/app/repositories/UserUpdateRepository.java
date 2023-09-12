package org.example.app.repositories;

import org.example.app.database.DBConn;
import org.example.app.entities.User;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserUpdateRepository {

    private static final Logger LOGGER =
            Logger.getLogger(UserUpdateRepository.class.getName());

    public String updateUser(User user) {

        String sql = "UPDATE " + Constants.TABLE_USERS + " SET phone = ? WHERE id = ?";

        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getPhone());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
            return Constants.DATA_UPDATE_MSG;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}

