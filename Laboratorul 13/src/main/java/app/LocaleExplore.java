package app;

import com.*;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        String command;
        boolean okayCommand;
        Locale L = Locale.getDefault();

        while (!done) {
            InputCommand i = new InputCommand();
            i.input(L);

            okayCommand = false;
            command = sc.nextLine();

            //display locales
            if (command.contains("display")) {
                DisplayLocales d = new DisplayLocales();
                d.displayLocales(L);

                okayCommand = true;
            }

            //set locales
            if (command.contains("set")) {
                String[] split = command.split(" ");
                L = Locale.forLanguageTag(split[1]);

                SetLocale s = new SetLocale();
                s.setLocale(L);

                okayCommand = true;
            }

            //info
            if (command.contains("info")) {
                String[] split = command.split(" ");
                Locale info;

                if (split[1] != null) {
                    info = Locale.forLanguageTag(split[1]);
                }
                else {
                    info = L;
                }

                InfoLocales inf = new InfoLocales();
                inf.infoLocale(info);

                okayCommand = true;
            }

            //invalid
            if (!okayCommand) {
                InvalidCommand inv = new InvalidCommand();
                inv.invalidCommand(L);
            }

            //exit
            if (command.equals("exit")) {
                done = true;
            }
        }
    }
}
