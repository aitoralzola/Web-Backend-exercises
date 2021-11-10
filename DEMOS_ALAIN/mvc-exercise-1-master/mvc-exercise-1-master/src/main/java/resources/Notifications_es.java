package resources;

import java.util.ListResourceBundle;

public class Notifications_es extends ListResourceBundle{
    private static final Object[][] contents = {
        //LocaleController
        {"message.languageUpdated", "Se ha actualizado el idioma."},
        //LoginController
        {"message.login", "¡Has iniciado sessión!"},
        {"error.login","Usuario y contraseña incorrectos."},
        {"message.logout", "Has cerrado sessión."},
        //UserController
        {"message.deleteUser", "Usuario borrado."},
        {"error.deleteUser", "Problemas al borrar el usuario."},
        {"message.editUser", "Usuario editado."},
        {"error.editUser", "Problemas al editar el usuario."},
        {"message.createUser", "Usuario creado."},
        {"error.createUser", "Problemas al editar el usuario."},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}