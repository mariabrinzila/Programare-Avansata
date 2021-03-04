import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Museum m = new Museum();
        m.setOpening(LocalTime.of(9, 30));
        m.setClosing(LocalTime.parse("17:00"));
        m.setFee(20);

        Church c = new Church();
        c.setOpening(LocalTime.of(7, 0));
        c.setClosing(LocalTime.MIDNIGHT);

        Visitable[] arr = {m, c};

        /**
         * cream obiectele aferente exemplului din problema
         */
        Hotel v1 = new Hotel();
        Museum v2 = new Museum();
        Museum v3 = new Museum();
        Church v4 = new Church();
        Church v5 = new Church();
        Restaurant v6 = new Restaurant();
        Hotel v7 = new Hotel("Hotel Traian", "descriere hotel Traian", 7, 1000);

        List<Location> locatie = new ArrayList<>();
        locatie.add(v1);
        locatie.add(v3);
        locatie.add(v6);
        City c1 = new City("Iasi", "descriere Iasi", 10, locatie);

        /**
         * le setam numele si costul
         * daca avem de exemplu v1 -> v2, cost: 10, atunci vom pune la v1 costul catre v2
         * daca avem de exemplu v2 <-> v3, atunci vom pune costul si de la v2 la v3 si de la v3 la v2
         */
        v1.setName("v1");
        v1.setCost(v2, 10); //v1 -> v2, cost: 10
        v1.setCost(v3, 50);

        v2.setName("v2");
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);

        v3.setName("v3");
        v3.setCost(v4, 20);
        v3.setCost(v2, 20);

        v4.setName("v4");
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);

        v5.setName("v5");
        v5.setCost(v6, 20);
        v5.setCost(v4, 30);

        /**
         * afisam niste nume si niste costuri pentru a vedea ca totul merge okay
         */
        System.out.println(v3.getName());

        Map<Location, Integer> costuri = new HashMap<>();

        costuri = v4.getCost();
        System.out.println(costuri.get(v5));

        costuri = v2.getCost();
        System.out.println(costuri.get(v3));

        costuri = v3.getCost();
        System.out.println(costuri.get(v2));

        System.out.println(v7.getFee());
        System.out.println(v7.getDescription());

        List<Location> test = new ArrayList<>();
        test = c1.getLocatii();
        System.out.println(c1.getRank());
        System.out.println(test.contains(v1));
    }
}