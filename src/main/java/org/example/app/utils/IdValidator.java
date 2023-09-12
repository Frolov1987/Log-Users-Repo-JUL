package org.example.app.utils;

public class IdValidator {
    public static boolean isIdValid(String id) {
        return id.isEmpty() || !id.matches(Constants.ID_RGX );
    }
}

