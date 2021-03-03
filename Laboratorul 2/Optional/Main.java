/**
 * Clasa main contine toate celelalte clase, verificari si costul minim pe care il cautam
 */

public class Main {
    public static void main(String[] args) {
        int nr = 4;
        Source[] S = new Source[nr];

        /**
         * cream cateva obiecte surse, unele factory, altele warehouse
         * cream un obiect cu acelasi nume si in aceeasi clasa (factory sau warehouse)
         * verificam daca exista duplicate
         * redenumim obiectul respectiv
         */
        int nr_curent = 0;
        S[0] = new Factory("S1", "Factory"); //S1
        S[1] = new Warehouse("S2", "Warehouse"); //S2
        S[2] = new Warehouse("S3", "Warehouse"); //S3
        S[3] = new Warehouse("S3", "Warehouse"); //S4
        if (VerifDuplicate(2, S, 3) == true)
            System.out.println("Numele sursei exista deja. Dati sursei alt nume.");
        else
            nr_curent++;
        S[3].setName("S4");

        /**
         * cream sursele de care avem nevoie in problema: S1, S2, S3
         */
        Source[] surse = new Source[3];
        surse[0] = new Factory("S1", "Factory"); //S1
        surse[1] = new Warehouse("S2", "Warehouse"); //S2
        surse[2] = new Warehouse("S3", "Warehouse"); //S3

        /**
         * cele 3 destinatii D1, D2, D3 si D4
         * cream un obiect destinatie cu acelasi nume ca altul
         * verificam daca exista duplicate
         * redenumim obiectul respectiv
         * verificam ca totul merge bine in clasa Destination
         */
        Destination D1 = new Destination("D1");
        Destination D2 = new Destination("D2");
        Destination D3 = new Destination("D3");

        Destination D4 = new Destination("D3");
        if (VerifDest(D4, D3) == true)
            System.out.println("Numele destinatiei exista deja. Dati-i alt nume.");
        D4.setName("D4");
        System.out.println(D1.getName());
        System.out.println(S[1].getType());
        System.out.println(D2.toString());
        System.out.println(S[2].toString());

        /**
         * cream o instanta a problemei noastre, adica un obiect al clasei Problem
         * si verificam ca totul merge bine
         */
        Destination[] dest = {D1, D2, D3};
        int[] supply = {10, 35, 25};
        int[] demand = {20, 25, 25};
        int[][] matrice = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        Problem exemplu = new Problem(3, supply, demand, surse, dest, matrice);
        System.out.println(exemplu.getSupply());
        System.out.println(exemplu.toString());

        /**
         * cream un obiect al clasei Solution si il initializam cu nr = 3 si Problem pb = exemplu
         * cream si un obiect al clasei Algorithm
         * rezolvam problema exemplu prin algoritmul greedy si retinem solutia in sol
         * afisam solutia (costul minim
         */
        Solution sol = new Solution(3, exemplu);
        Algorithm greedy = new Algorithm(exemplu);
        sol = greedy.solve();
        System.out.println(sol.CalculareCost());
    }

    /**
     * verificam daca in vectorul de surse S, exista duplicate
     * verificam doar S[j] si S[nr] pentru ca restul sunt verificate pe parcurs
     *
     * @param nr primul indice
     * @param S  vectorul de surse
     * @param j  al doilea indice
     * @return daca sunt duplicate (true) sau nu (false)
     */
    public static boolean VerifDuplicate(int nr, Source[] S, int j) {
        if (S[j].equals(S[nr]) == true)
            return true;
        return false;
    }

    /**
     * acelasi lucru ca la functia de mai sus, doar ca pentru destinatii
     *
     * @param D1 o destinatie
     * @param D2 a doua destinatie
     * @return daca cele 2 sunt egale sau nu
     */
    public static boolean VerifDest(Destination D1, Destination D2) {
        if (D2.equals(D1) == true)
            return true;
        return false;
    }
}