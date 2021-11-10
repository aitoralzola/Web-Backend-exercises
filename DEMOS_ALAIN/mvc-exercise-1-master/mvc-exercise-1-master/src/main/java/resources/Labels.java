package resources;

import java.util.ListResourceBundle;

public class Labels extends ListResourceBundle{
    private static final Object[][] contents = {
        {"hello", "Hello"},
        {"userId", "User ID"},
        {"username", "Username"},
        {"password", "Password"},
        {"firstName", "First Name"},
        {"secondName", "Second Name"},
        {"email", "Email"},
        {"edit", "Edit"},
        {"delete", "Delete"},
        {"save", "Save"},
        {"home", "Home"},
        {"userList", "UserList"},
        {"createUser", "Create User"},
        {"editUser", "Edit User"},
        {"login", "Login"},
        {"logged", "You are logged!"},
        {"logout", "Logout"},
        {"author", "Author"},
        {"language.currentLocale", "Current Language"},
        {"language.en", "English"},
        {"language.es", "Spanish"},
        {"language.eu", "Basque"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}