import java.util.HashMap;
import java.util.Map;

public class Algorithm {
    int[][] G;
    private int n, start, finish;

    public Algorithm(TravelPlan t, int start, int finish) {
        this.n = t.getC().getLocatii().size();
        this.start = start;
        this.finish = finish;

        /**
         * Cream graful asociat "hartii" orasului
         */
        int lg;
        int index;
        int i, nod1, nod2, cost, j;
        int[][] G = new int[1000][1000];
        Map<Location, Integer> costuri = new HashMap<>();

        for (i = 0; i < n; i++) {
            costuri = t.getC().getLocatii().get(i).getCost();

            for (j = 0; j < n; j++) {
                if (costuri.get(t.getC().getLocatii().get(j)) != null) {
                    cost = costuri.get(t.getC().getLocatii().get(j));
                    G[i + 1][j + 1] = cost;
                }
            }
        }
        this.G = G;
    }

    public Solution Dijkstra() {
        Solution sol = new Solution();
        int j, i, vfmin = 0, cmin, x;
        int INF = 100000000;
        boolean[] M = new boolean[1000];
        int[] dmin = new int[1000];
        int[] prec = new int[1000];
        int[] drum = new int[1000];

        //initializari
        M[start] = true;
        for (i = 1; i <= n; i++) {
            dmin[i] = INF;
            prec[i] = start;
        }
        prec[start] = 0;
        dmin[start] = 0;
        for (i = 1; i <= n; i++)
            if (G[start][i] > 0)
                dmin[i] = G[start][i];

        for (j = 1; j <= n; j++) {
            //aflu vfmin
            cmin = INF + 1;
            for (x = 1; x <= n; x++)
                if (!M[x] && dmin[x] < cmin) {
                    cmin = dmin[x];
                    vfmin = x;
                }
            if (cmin == INF)
                break;
            M[vfmin] = true;
            for (i = 1; i <= n; i++)
                if (!M[i] && G[vfmin][i] > 0)
                    if (dmin[i] > dmin[vfmin] + G[vfmin][i]) {
                        dmin[i] = dmin[vfmin] + G[vfmin][i];
                        prec[i] = vfmin;
                    }
        }

        /**
         * construim drumul minim start - finish
         */
        int lg;
        drum[0] = finish;
        lg = 1;
        while (drum[lg - 1] != start) {
            drum[lg] = prec[drum[lg - 1]];
            lg++;
        }

        /**
         * in dmin[] avem costurile minime de la start la orice varf
         * retinem drumul minim intr-un String
         */
        String drumMin = String.valueOf(drum[lg - 1]);
        for (i = lg - 2; i >= 0; i--)
            drumMin = drumMin + " " + String.valueOf(drum[i]);

        sol.setDrum(drumMin);
        sol.setCostMinim(dmin[finish]);
        return sol;
    }
}
