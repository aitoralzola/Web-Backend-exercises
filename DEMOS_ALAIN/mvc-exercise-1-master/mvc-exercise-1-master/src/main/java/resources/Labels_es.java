package resources;

import java.util.ListResourceBundle;

public class Labels_es extends ListResourceBundle{
    private static final Object[][] contents = {
        {"hello", "Hola"},
        {"userId", "ID de Usuario"},
        {"username", "Nombre de Usuario"},
        {"password", "Contraseña"},
        {"firstName", "Nombre"},
        {"secondName", "Apellido"},
        {"email", "Correo electrónico"},
        {"edit", "Editar"},
        {"delete", "Borrar"},
        {"save", "Guardar"},
        {"home", "Inicio"},
        {"userList", "Lista de Usuarios"},
        {"createUser", "Crear Usuario"},
        {"editUser", "Editar Usuario"},
        {"login", "Iniciar Sessión"},
        {"logged", "¡Has iniciado la sessión!"},
        {"logout", "Cerrar Session"},
        {"author", "Autor"},
        {"language.currentLocale", "Idioma Actual"},
        {"language.en", "Inglés"},
        {"language.es", "Español"},
        {"language.eu", "Euskera"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}