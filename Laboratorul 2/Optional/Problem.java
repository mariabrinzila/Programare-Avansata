import java.util.Arrays;

/**
 * Clasa Problem modeleaza problema
 * matrice_cost[i][j] -> costul Si - Dj
 * nr_elem -> nr. de linii si de coloane ale matricei de costuri
 * avem un vector unde retinem supply-ul, unul pentru demand-uri
 * un vector de surse si unul de destinatii
 */

public class Problem {
    private int nr_elem;
    private int supply[];
    private int demand[];
    private Source[] surse;
    private Destination[] dest;
    private int matrice_cost[][];

    public Problem(int nr_elem, int supply[], int demand[], Source[] surse, Destination[] dest, int matrice_cost[][]) {
        this.nr_elem = nr_elem;
        this.supply = supply;
        this.demand = demand;
        this.surse = surse;
        this.dest = dest;
        this.matrice_cost = matrice_cost;
    }

    public int getNr_elem() {
        return nr_elem;
    }

    public void setNr_elem(int nr_elem) {
        this.nr_elem = nr_elem;
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public Source[] getSurse() {
        return surse;
    }

    public void setSurse(Source[] surse) {
        this.surse = surse;
    }

    public Destination[] getDest() {
        return dest;
    }

    public void setDest(Destination[] dest) {
        this.dest = dest;
    }

    public int[][] getMatrice_cost() {
        return matrice_cost;
    }

    public void setMatrice_cost(int[][] matrice_cost) {
        this.matrice_cost = matrice_cost;
    }

    @Override
    public String toString() {
        //folosim pachetul java.util.Arrays pentru a transforma elementele din vectori/matrice in String-uri
        return "Problem{" +
                "nr_elem=" + nr_elem +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                ", surse=" + Arrays.toString(surse) +
                ", dest=" + Arrays.toString(dest) +
                ", matrice_cost=" + Arrays.toString(matrice_cost) +
                '}';
    }
}
