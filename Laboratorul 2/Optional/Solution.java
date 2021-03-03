/**
 * Clasa Solution genereaza solutia unei probleme pb
 * unitati[i][j] -> nr. unitatilor distribuite de la sursa Si la destinatia Dj
 * nr este numarul de linii si de coloane a matricei unitati[][]
 */

public class Solution {
    private int[][] unitati;
    private int cost;
    private int nr;
    Problem pb;

    /**
     * constructorul clasei
     *
     * @param nr nr. de linii si de coloane a matricei de costuri si, deci, si a matricei de unitati
     * @param pb problema a carei solutii o vrem
     */
    public Solution(int nr, Problem pb) {
        this.cost = 0;
        this.nr = nr;
        this.pb = pb;
        unitati = new int[nr][nr];
    }

    public int getNr() {
        return nr;
    }

    public int[][] getUnitati() {
        return unitati;
    }

    public void setUnitati(int[][] unitati) {
        this.unitati = unitati;
    }

    /**
     * calculam costul minim
     *
     * @return costul
     */
    public int CalculareCost() {
        int i, j;
        int[][] costuri = pb.getMatrice_cost();

        for (i = 0; i < nr; i++)
            for (j = 0; j < nr; j++)
                cost += unitati[i][j] * costuri[i][j];

        return cost;
    }
}
