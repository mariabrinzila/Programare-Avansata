package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class InvalidCommand {
    public static void invalidCommand(Locale locale) {
        String name = "res.Messages";
        ResourceBundle res = ResourceBundle.getBundle(name, locale);

        System.out.println(res.getString("invalid"));
    }
}
