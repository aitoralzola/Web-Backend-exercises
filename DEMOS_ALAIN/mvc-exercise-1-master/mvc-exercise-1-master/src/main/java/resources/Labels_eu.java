package resources;

import java.util.ListResourceBundle;

public class Labels_eu extends ListResourceBundle{
    private static final Object[][] contents = {
        {"hello", "Kaixo"},
        {"userId", "Erabiltzailearen IDa"},
        {"username", "Erabiltzaile Izena"},
        {"password", "Pasahitza"},
        {"firstName", "Izena"},
        {"secondName", "Abizena"},
        {"email", "e-posta"},
        {"edit", "Aldatu"},
        {"delete", "Ezabatu"},
        {"save", "Gorde"},
        {"home", "Hasiera"},
        {"userList", "Erabiltzaileen Zerrenda"},
        {"createUser", "Erabiltzailea Sortu"},
        {"editUser", "Erabiltzailea Aldatu"},
        {"login", "Saioa Hasi"},
        {"logged", "Saioa hasi duzu!"},
        {"logout", "Saioa Itxi"},
        {"author", "Egilea"},
        {"language.currentLocale", "Momentuko Hizkuntza"},
        {"language.en", "Ingelesa"},
        {"language.es", "Gaztelera"},
        {"language.eu", "Euskara"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}