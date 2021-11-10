package resources;

import java.util.ListResourceBundle;

public class Labels extends ListResourceBundle{
    private static final Object[][] contents = {
        {"dbPlots", "Dragon Ball Plots"},
        {"username", "Username"},
        {"password", "Password"},
        {"hello", "Hello"},
        {"login", "Login"},
        {"logout", "Logout"},
        {"loginForm", "Login Form"},
        {"language.eu", "Basque"},
        {"language.es", "Spanish"},
        {"language.en", "English"},
    };
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}