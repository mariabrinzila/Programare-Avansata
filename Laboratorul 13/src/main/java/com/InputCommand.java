package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class InputCommand {
    public static void input(Locale locale) {
        String name = "res.Messages";
        ResourceBundle res = ResourceBundle.getBundle(name, locale);

        System.out.println(res.getString("prompt"));
    }
}
