package resources;

import java.util.ListResourceBundle;

public class Labels_es extends ListResourceBundle{
    private static final Object[][] contents = {
        {"dbPlots", "Tramas de Dragon Ball"},
        {"username", "Nombre de usuario"},
        {"password", "Contraseña"},
        {"hello", "Hola"},
        {"login", "Iniciar sessión"},
        {"logout", "Cerrar session"},
        {"loginForm", "Formulario de inicio de sessión"},
        {"language.eu", "Euskera"},
        {"language.es", "Español"},
        {"language.en", "Inglés"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}