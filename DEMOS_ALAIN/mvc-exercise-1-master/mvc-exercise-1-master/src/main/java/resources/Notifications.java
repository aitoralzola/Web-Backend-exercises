package resources;

import java.util.ListResourceBundle;

public class Notifications extends ListResourceBundle{
    private static final Object[][] contents = {
        {"error.forbidden","Forbidden"},
        //LocaleController
        {"message.languageUpdated", "Language has been updated."},
        //LoginController
        {"message.login", "Successfully loged!"},
        {"error.login","Wrong username or password"},
        {"message.logout", "You loged out"},
        //UserController
        {"message.deleteUser", "User deleted."},
        {"error.deleteUser", "Problems removing User."},
        {"message.editUser", "User correctly edited."},
        {"error.editUser", "Problems editing User."},
        {"message.createUser", "User correctly created."},
        {"error.createUser", "Problems editing User."},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}