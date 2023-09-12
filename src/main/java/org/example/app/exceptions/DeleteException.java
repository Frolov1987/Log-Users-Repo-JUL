package org.example.app.exceptions;

import java.util.HashMap;
import java.util.Map;

public class DeleteException extends RuntimeException {

    Map<String, String> errors;

    public DeleteException(String msg, Map<String, String> errors) {
        super(msg);
        this.errors = errors;
    }

    public String getErrors(Map<String, String> errors) {
        this.errors = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        errors.forEach((key, value) ->
                stringBuilder.append("\n>> ")
                        .append(key)
                        .append(": ")
                        .append(value)

        );
        return stringBuilder.toString();
    }
}

