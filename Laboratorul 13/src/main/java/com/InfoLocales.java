package com;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class InfoLocales {
    public static void infoLocale(Locale locale) {
        String name = "res.Messages";
        ResourceBundle res = ResourceBundle.getBundle(name, locale);

        System.out.println(res.getString("info"));
        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());

        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: " + currency.getDisplayName());

        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String weekdays[] = dfs.getWeekdays();
        System.out.println("Week days: " + weekdays[0] + ", " + weekdays[1] + ", " + weekdays[2] + ", " + weekdays[3] + ", " + weekdays[4] + ", " + weekdays[5] + ", " + weekdays[6]);

        String months[] = dfs.getMonths();
        System.out.println("Months: " + Arrays.toString(months));

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
        System.out.println("Today: " + today.format(formatter));
    }
}
