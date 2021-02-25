public class Main {
    public static void main(String[] args) {
        //cele 3 surse S1, S2, S3
        Source S1 = new Source("S1", SourceType.FACTORY);
        Source S2 = new Source("S2", SourceType.WAREHOUSE);
        Source S3 = new Source("S3", SourceType.WAREHOUSE);

        //cele 3 destinatii D1, D2, D3
        Destination D1 = new Destination("D1");
        Destination D2 = new Destination("D2");
        Destination D3 = new Destination("D3");

        //verificam ca merge totul okay in clasele Source si Destination
        System.out.println(D1.getName());
        System.out.println(S2.getType());
        System.out.println(D2.toString());
        System.out.println(S3.toString());

        //cream o instanta a problemei
        Source[] surse = {S1, S2, S3};
        Destination[] dest = {D1, D2, D3};
        int[] supply = {10, 35, 25};
        int[] demand = {20, 25, 25};
        int[][] matrice = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        Problem exemplu = new Problem(3, supply, demand, surse, dest, matrice);

        //afisare (pentru a verifica ca totul functioneaza corect
        System.out.println(exemplu.getMatrice_cost());
        System.out.println(exemplu.getSupply());
        System.out.println(exemplu.toString());
    }
}
