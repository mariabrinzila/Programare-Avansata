package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static void displayLocales(Locale locale) {
        String name = "res.Messages";
        ResourceBundle res = ResourceBundle.getBundle(name, locale);

        System.out.println(res.getString("locales"));

        Locale available[] = Locale.getAvailableLocales();

        for (Locale L : available) {
            System.out.println(L.getDisplayCountry() + " " + L.getDisplayLanguage(L));
        }
    }
}
