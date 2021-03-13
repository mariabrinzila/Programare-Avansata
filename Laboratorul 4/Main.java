import java.util.stream.IntStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * cream obiectele din problema folosind stream-uri
         */
        Student[] students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        System.out.println(students[1].getName());

        School[] schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i)).toArray(School[]::new);
        System.out.println(schools[0].getName());

        int i = 2;
        for (School h : schools)
            h.setCapacity(i);
        schools[0].setCapacity(1);
        System.out.println(schools[2].getCapacity());

        /**
         * lista de studenti cu LinkedList
         * sortam studentii
         */
        LinkedList<Student> listStud = new LinkedList<>();
        for (Student s : students)
            listStud.add(s);
        System.out.println(listStud.get(3).getName());

        Collections.sort(listStud, Comparator.comparing(Student::getName));
        String nume = null;
        for (i = 0; i < listStud.size(); i++)
            if (nume != null)
                nume = nume + listStud.get(i).getName() + " ";
            else
                nume = listStud.get(i).getName() + " ";
        System.out.println(nume);

        /**
         * lista de scoli cu TreeSet
         */
        TreeSet<School> listSch = new TreeSet<>();
        for (School h : schools)
            listSch.add(h);
        System.out.println(listSch.first().getName());

        /**
         * map pentru studenti cu scoli (LinkedHashMap)
         * map pentru scoli cu studenti (TreeMap)
         */
        LinkedHashMap<Student, List<School>> studSch = new LinkedHashMap<>();
        for (Student s : students)
            studSch.put(s, Arrays.asList(schools[0], schools[1], schools[2]));
        studSch.put(students[2], Arrays.asList(schools[0], schools[1]));
        studSch.put(students[3], Arrays.asList(schools[0], schools[2]));
        System.out.println(studSch.get(students[1]).get(1).getName());

        TreeMap<School, List<Student>> schStud = new TreeMap<>();
        schStud.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schStud.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schStud.put(schools[2], Arrays.asList(students[0], students[1], students[3]));
        System.out.println(schStud.get(schools[2]).get(2).getName());
    }
}
