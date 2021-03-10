import java.time.LocalTime;
import java.util.*;
import java.time.Duration;

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
        Hotel v7 = new Hotel("Hotel Traian", "descriere hotel Traian", 7, 1000, 24);

        List<Location> locatie = new ArrayList<>();
        locatie.add(v1);
        locatie.add(v4);
        locatie.add(v6);
        City c1 = new City("Iasi", "descriere Iasi", 10, locatie, 23);

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

        /**
         * verificam cate locatii sunt visitable si nu payable din orasul c1
         * doar v4 satisface conditia deci verif ar trebui sa contina doar o singura locatie
         * si v5 satisface conditiile
         * cream obiectul v8 Church care va satisface si el conditiile
         * ordinea dupa ora deschiderii: v8, v4, v5
         */
        List<Location> verif = new ArrayList<>();
        verif = c1.locationType();
        System.out.println(verif.size());
        System.out.println(verif.get(0).getName());

        Church v8 = new Church();
        v8.setName("v8");
        c1.addLocation(v5);
        c1.addLocation(v8);

        v4.setOpening(LocalTime.of(12, 15));
        v5.setOpening(LocalTime.of(14, 55));
        v8.setOpening(LocalTime.of(10, 30));

        verif = c1.locationType();
        System.out.println(verif.size());
        System.out.println(verif.get(0).getName());
        System.out.println(verif.get(1).getName());
        System.out.println(verif.get(2).getName());

        /**
         * calculam durata vizitarii unei locatii visitable, sa zicem un muzeu
         * 8:45 -> 17:55 <-> 9h 10 min <-> 33000 sec
         */
        Museum m1 = new Museum();
        m1.setOpening(LocalTime.of(8, 45));
        m1.setClosing(LocalTime.of(17, 55));

        Duration durata = Visitable.getVisitingDuration(m1.getOpening(), m1.getClosing());
        System.out.println(durata.getSeconds());

        /**
         * testam metodele default din interfata Visitable
         */
        Restaurant r = new Restaurant();
        r.setOpening(LocalTime.parse("12:00"));
        r.defaultOpening();
        System.out.println(r.getOpening().getMinute());
        r.defaultClosing();
        System.out.println(r.getClosing().getHour());

        /**
         * cream travel planul unui turist
         * vrea sa mearga la hotel, sa viziteze un muzeu, sa manance la un restaurant
         */
        City c2 = new City();
        c2.setName("Barcelona");
        c2.setRank(10);

        List<Location> toBeVisited = new ArrayList<>();
        toBeVisited.add(v1);
        toBeVisited.add(v2);
        toBeVisited.add(v3);
        toBeVisited.add(v4);
        toBeVisited.add(v5);
        c2.setLocatii(toBeVisited);

        List<Integer> preferinte = new ArrayList<>();
        preferinte.add(1);
        preferinte.add(3);
        preferinte.add(2);
        preferinte.add(5);
        preferinte.add(6);

        TravelPlan t = new TravelPlan(c2, preferinte);
        System.out.println(t.getC().getLocatii().get(3).getName());
        System.out.println(t.getPreferences().get(t.getC().getLocatii().indexOf(v4)));

        /**
         * setam indexii locatiilor pe care le-am creat
         * si adaugam si locatia v6 la travelPlan
         */
        v1.setIndexObiect(1);
        v2.setIndexObiect(2);
        v3.setIndexObiect(3);
        v4.setIndexObiect(4);
        v5.setIndexObiect(5);
        c2.addLocation(v6);
        v6.setIndexObiect(6);
        preferinte.add(4);

        /**
         * Calculam drumul minim de la v1 la v6 (40)
         * afisam drumul minim de la v1 la v6
         */
        Solution sol = new Solution();
        int costMinim;
        int finish = t.getC().getLocatii().get(5).getIndexObiect();
        Algorithm djk = new Algorithm(t, t.getC().getLocatii().get(0).getIndexObiect(), finish);
        sol = djk.Dijkstra();
        costMinim = sol.getCostMinim();
        System.out.println(costMinim);
        String drum = sol.getDrum();
        System.out.println(drum);
    }
}