package org.example.app.services;

import org.example.app.database.DBCheck;
import org.example.app.entities.User;
import org.example.app.exceptions.DBException;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserUpdateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdChecker;
import org.example.app.utils.IdValidator;
import org.example.app.utils.PhoneValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserUpdateService {

    UserUpdateRepository repository;
    private static final Logger LOGGER =
            Logger.getLogger(UserUpdateService.class.getName());

    public UserUpdateService(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {
        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException e) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return e.getMessage();
            }
        }

        Map<String, String> errors = validateData(data);

        if (errors.size() > 0) {
            try {
                throw new UpdateException("Check inputs for update data.", errors);
            } catch (UpdateException ue) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPTS_WRONG_MSG);
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(mapData(data));
    }

    private Map<String, String> validateData(String[] data) {
        String strId = data[0].trim();
        int id = 0;

        Map<String, String> errors = new HashMap<>();

        try {
            id = Integer.parseInt(strId);
        } catch(NumberFormatException nfe) {
            errors.put("id", nfe.getMessage());
        }

        if (IdValidator.isIdValid(strId))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (id <= 0)
            errors.put("id", Constants.WRONG_ID_MSG);

        if (IdChecker.isIdExists(id))
            errors.put("id", Constants.ID_NO_EXISTS_MSG);

        if (PhoneValidator.isPhoneValid(data[1]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        return errors;
    }

    private User mapData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0].trim()));
        user.setPhone(data[1].trim());
        return user;
    }
}

