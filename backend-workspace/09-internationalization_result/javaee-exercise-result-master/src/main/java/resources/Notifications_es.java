package resources;

import java.util.ListResourceBundle;

public class Notifications_es extends ListResourceBundle{
    private static final Object[][] contents = {
        //LocaleController
        {"message.languageUpdated", "Se ha actualizado el idioma."},
        //LoginController
        {"message.login", "¡Sessión iniciada!"},
        {"error.login","Usuario y contraseña incorrectos."},
        {"message.logout", "Has cerrado la sessión."},
        //dbController
        {"error.pageNotFound", "Página no encontrada."},
        {"error.forbidden", "No tienes permisos."},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}