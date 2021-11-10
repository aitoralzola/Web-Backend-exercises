package resources;

import java.util.ListResourceBundle;

public class Notifications_eu extends ListResourceBundle{
    private static final Object[][] contents = {
        //LocaleController
        {"message.languageUpdated", "Hizkuntza eguneratu duzu."},
        //LoginController
        {"message.login", "Saioa hasi duzu!"},
        {"error.login","Erabiltzaile edo pasahitz okerrak."},
        {"message.logout", "Saioa itxi duzu."},
        //UserController
        {"message.deleteUser", "Erabiltzailea ezabatu da."},
        {"error.deleteUser", "Arazoak erabiltzailea ezabatzen."},
        {"message.editUser", "Erabiltzailea aldatu da."},
        {"error.editUser", "Arazoak erabiltzailea aldatzen."},
        {"message.createUser", "Erabiltzailea sortu da."},
        {"error.createUser", "Arazoak erabiltzailea sortzen."},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}