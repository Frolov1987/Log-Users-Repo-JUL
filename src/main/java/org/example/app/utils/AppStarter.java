package org.example.app.utils;

import org.example.app.controllers.AppController;
import org.example.app.services.AppService;
import org.example.app.views.AppView;

public class AppStarter {

    public static void startApp() {
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }
}
