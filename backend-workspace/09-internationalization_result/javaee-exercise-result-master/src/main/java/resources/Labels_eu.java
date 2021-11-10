package resources;

import java.util.ListResourceBundle;

public class Labels_eu extends ListResourceBundle{
    private static final Object[][] contents = {
        {"dbPlots", "Dragoi Bolako trama"},
        {"username", "Erabiltzaile izena"},
        {"password", "Pasahitza"},
        {"hello", "Kaixo"},
        {"login", "Saioa Hasi"},
        {"logout", "Saioa Itxi"},
        {"loginForm", "Saio hasierako formulategia"},
        {"language.eu", "Euskara"},
        {"language.es", "Gaztelera"},
        {"language.en", "Ingelesa"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}