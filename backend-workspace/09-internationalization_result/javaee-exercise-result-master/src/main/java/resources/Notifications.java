package resources;

import java.util.ListResourceBundle;

public class Notifications extends ListResourceBundle{
    private static final Object[][] contents = {
        //LocaleController
        {"message.languageUpdated", "Language has been updated."},
        //LoginController
        {"message.login", "Successfully loged!"},
        {"error.login","Wrong username or password"},
        {"message.logout", "You loged out"},
        //dbController
        {"error.pageNotFound", "Page not found."},
        {"error.forbidden", "Forbidden"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}