package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static void setLocale(Locale locale) {
        String name = "res.Messages";
        ResourceBundle res = ResourceBundle.getBundle(name, locale);

        System.out.println(res.getString("locale.set"));
    }
}
