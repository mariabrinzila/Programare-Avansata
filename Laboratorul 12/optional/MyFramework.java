import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class MyFramework {
    private static List<Class> classes = new ArrayList<Class>();

    public static void main(String[] args) throws Exception {
        int passed = 0, failed = 0;

        /**
         * get the path, the package and the class name from args[0]
         * split args[0] by "/"
         * check if the class that was given has a specific path => split[0] shpuld either be c, d, e or f
         */
        String[] split = args[0].split("/");
        String className, path;
        int lg = split.length, i;
        Class arg;

        if (split[0].contains("c") || split[0].contains("d") || split[0].contains("e") || split[0].contains("f")) {
            //it has been given via a path
            //we know that split[lg - 1] is the class name
            //we try all the combinations possbile
            boolean works = false;
            int n = 1;
            arg = Class.forName(args[0]);
            className = split[lg - 1];

            while (!works) {
                path = split[0];

                for (i = 1; i < lg - n; i++) {
                    path = path + "/" + split[i];
                }

                className = split[lg - n];
                for (i = lg - n + 1; i < lg; i++)
                    className = className + "." + split[i];

                File f = new File(path);
                URL[] cp = {f.toURI().toURL()};
                URLClassLoader urlcl = new URLClassLoader(cp);

                try {
                    arg = urlcl.loadClass(className);

                    for (Method m : arg.getMethods()) {
                        if (m.isAnnotationPresent(Test.class)) {
                            try {
                                m.invoke(null);
                                passed++;
                            } catch (Throwable ex) {
                                System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                                failed++;
                            }
                        }
                    }

                    works = true;
                } catch (Exception e) {
                    System.out.println("Not the right path and class name.");
                }
            }
        }
        else {
            //args[0] either has the package and the name of the class or just the name of the class
            //if it has a package, we need to put "." between the names <=> com/example/name => com.example.name
            //if we split args[0] by "/" and we only have one String, then we know that we only have the class name
            //otherwise, we have to change the "/" to "."
            className = split[0];

            if (lg > 1) {
                for (i = 1; i < lg; i++) {
                    className = className + "." + split[i];
                }

                arg = Class.forName(className);

                for (Method m : arg.getMethods()) {
                    if (m.isAnnotationPresent(Test.class)) {
                        try {
                            m.invoke(null);
                            passed++;
                        } catch (Throwable ex) {
                            System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                            failed++;
                        }
                    }
                }
            }
            else {
                //verificam daca avem o clasa sa un folder
                File trying = new File(className);

                if (trying.isDirectory()) {
                    classes = getClassesFromDir(trying, "");

                    int L = classes.size();

                    for (i = 0; i < L; i++) {
                        arg = classes.get(i).getClass();

                        //@Test static
                        for (Method m : arg.getMethods()) {
                            if (m.isAnnotationPresent(Test.class)) {
                                try {
                                    m.invoke(null);
                                    passed++;
                                } catch (Throwable ex) {
                                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                                    failed++;
                                }
                            }
                        }
                    }
                }
                else {
                    //avem o clasa
                    arg = Class.forName(className);

                    for (Method m : arg.getMethods()) {
                        if (m.isAnnotationPresent(Test.class)) {
                            try {
                                m.invoke(null);
                                passed++;
                            } catch (Throwable ex) {
                                System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                                failed++;
                            }
                        }
                    }
                }
            }
        }

        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }

    public static List<Class> getClassesFromDir(File folder, String namePackage) throws ClassNotFoundException {
        if (!folder.exists())
            return null;

        File[] files = folder.listFiles();

        for (File current : files) {
            if (current.isDirectory()) {
                //procedam in acelasi fel ca la acest director
                if (namePackage.equals("")) {
                    classes.addAll(getClassesFromDir(current, namePackage + current.getName()));
                }
                else
                    classes.addAll(getClassesFromDir(current, namePackage + "." + current.getName()));
            }
            else {
                //testam daca am gasit o clasa
                if (current.getName().endsWith(".class")) {
                    String name = namePackage + '.';
                    int classLg = current.getName().length();
                    String className = current.getName().substring(0, classLg - 6); //.class => 6 caractere
                    name = name + className;

                    classes.add(Class.forName(name));
                }
            }
        }

        return classes;
    }
}
