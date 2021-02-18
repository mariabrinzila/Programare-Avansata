/*
    Autor: Brinzila Maria, grupa B5, anul 2
*/

public class Laboratorul1
{
    public static void main(String[] args)
    {
        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        System.out.println(n);

        String nr_binar = "10101";
        String rezultat = (n + nr_binar);
        //copie este pentru inmultirea cu 6
        String copie = (n + nr_binar);

        String nr_hexa = "FF";
        rezultat = (rezultat + nr_hexa);
        System.out.println(rezultat);

        //inmultim cu 6 numarul obtinut dupa ce adaugam 10101 si dupa ii adaugam din nou FF
        long rez = Long.parseLong(copie);
        rez *= 6;
        String rez_final = (rez + nr_hexa);
        System.out.println(rez_final);

        //suma cifrelor
        while (rez_final.length() > 1)
        {
            int sum = 0;
            int lg = rez_final.length();
            int i;
            char ch;
            for (i = 0; i < lg; i++)
            {
                ch = rez_final.charAt(i);
                if (Character.isDigit(ch))
                    sum += Character.getNumericValue(ch);
            }
            System.out.println(sum);
            rez_final = String.valueOf(sum);
        }

        int result = Integer.parseInt(rez_final);
        System.out.println(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
