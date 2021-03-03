/**
 * Clasa Algorithm contine algoritmul ce genereaza valorile din matricea de unitati din clasa Solution
 */

public class Algorithm {
    Problem pb;

    /**
     * constructorul clasei
     *
     * @param pb problema pe care vrem sa o rezolvam
     */
    public Algorithm(Problem pb) {
        this.pb = pb;
    }

    /**
     * rezolvarea problemei
     *
     * @return solutia completa a problemei
     */
    public Solution solve() {
        Solution sol = new Solution(pb.getNr_elem(), pb);
        int i, j, nr = sol.getNr();
        int minim = 1000000;
        int copie = minim;
        int[][] m = pb.getMatrice_cost();
        int[][] copie_matrice = new int[nr][nr];
        int[] supply = pb.getSupply();
        int[] demand = pb.getDemand();
        int[][] unit = sol.getUnitati();

        int col = 0, prim;

        //facem o copie a matricei de costuri pentru ca aceasta va fi modificata
        for (i = 0; i < nr; i++)
            for (j = 0; j < nr; j++)
                copie_matrice[i][j] = m[i][j];

        for (i = 0; i < nr; i++) {
            prim = 0;
            while (supply[i] != 0) {
                //calculam costul minim Si -> Dj
                for (j = 0; j < nr; j++)
                    if (m[i][j] < minim) {
                        minim = m[i][j];
                        col = j;
                    }
                m[i][col] = copie;
                minim = copie;

                //calculam minimul dintre supply[i] si demand[col] si modificam matricea units
                if (supply[i] < demand[col]) {
                    if (prim == 0) {
                        prim = 1;
                        unit[i][col] = supply[i];
                        supply[i] = 0;
                    } else {
                        unit[i][col] = supply[i];
                        demand[col] -= supply[i];
                        supply[i] = 0;
                    }
                } else {
                    if (prim == 0)
                        prim = 1;
                    unit[i][col] = demand[col];
                    supply[i] -= demand[col];
                    demand[col] = 0;
                }
            }
        }

        //facem update la matricea din solutie si o returnam
        pb.setMatrice_cost(copie_matrice);
        sol.setUnitati(unit);
        return sol;
    }
}
