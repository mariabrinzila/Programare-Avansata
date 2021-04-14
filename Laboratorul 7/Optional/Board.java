import java.util.*;
import java.lang.Math;
import java.util.Scanner;

public class Board {
    private final List<Token> tokens = new ArrayList<>();
    private List<Token> extracted = new ArrayList<>();
    private int n;

    public Board(int n) {
        int i, j;
        int max = 1000, min = 0, range, val;

        /**
         * pentru a genera numere random de la 1 la 1000 folosim max, min si range
         * si Math.random()
         * token-urile vor fi muchii => (1,2) = (2,1)
         */
        range = max - min + 1;
        this.n = n;

        for (i = 1; i <= n; i++)
            for (j = i + 1; j <= n; j++) {
                val = (int) (Math.random() * range) + min;
                Token T = new Token(i, j, val);
                tokens.add(T);
            }
    }

    public synchronized Token extractTokens(Game game) {
        Token extras;

        if (tokens.isEmpty())
            return null;

        /**
         * daca lista nu esta goala vedem daca utilizatorul vrea sa ia un token random sau nu
         * random => daca lista de token-uri nu este goala, luam primul token din lista si dupa il eliminam din lista
         * manual => utilizatorul va da un index si vom elimina tokenul cu indexul respectiv
         */
        System.out.println("Manual/Random token extraction?");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        /**
         * verificam daca raspunsul jucatorului incepe cu 'R' => random
         * altfel => manual
         */
        if (s.matches("R.*")) {
            extras = tokens.get(0);
            tokens.remove(0);
            extracted.add(extras);
            game.setTurnDone(true);
        }
        else {
            System.out.println("Token index (maximum index is " + (tokens.size() - 1) + ")");
            Scanner in1 = new Scanner(System.in);
            int i = in1.nextInt();
            extras = tokens.get(i);
            tokens.remove(i);
            extracted.add(extras);
            game.setTurnDone(true);
        }

        return extras;
    }

    public List<Token> getExtracted() {
        return extracted;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
