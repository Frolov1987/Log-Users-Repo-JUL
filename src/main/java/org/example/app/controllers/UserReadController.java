package org.example.app.controllers;

import org.example.app.services.UserReadService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.UserReadView;


public class UserReadController {
    UserReadService service;
    UserReadView view;

    public UserReadController(UserReadService service, UserReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readUsers() {
        String str = service.readUsers();
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput("\n______ USERS ___________\n" + str);
            AppStarter.startApp();
        }
    }
}

