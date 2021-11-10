package resources;

import java.util.ListResourceBundle;

public class Notifications_eu extends ListResourceBundle{
    private static final Object[][] contents = {
        //LocaleController
        {"message.languageUpdated", "Hizkuntza aldatu da."},
        //LoginController
        {"message.login", "Saioa hasi duzu!"},
        {"error.login","Erabiltzaile edo pasahitz okerrak."},
        {"message.logout", "Saioa itxi duzu"},
        //dbController
        {"error.pageNotFound", "Ez dago eskuragarri."},
        {"error.forbidden", "Baimenik ez."},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}