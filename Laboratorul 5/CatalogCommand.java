import sun.awt.shell.ShellFolder;

import java.awt.*;
import java.io.*;

public class CatalogCommand {
    public static void play(Item i)
            throws IOException, InvalidCatalogException {
        try {
            Desktop d = Desktop.getDesktop();
            String path = i.getPath();
            File f = new File(path);
            d.open(f);
        } catch (IOException ex) {
            System.out.println("Exception caught.");
        }
    }

    public static void save(Catalog catalog)
            throws InvalidCatalogException, IOException {
        FileOutputStream f = new FileOutputStream(catalog.getPath());
        try (ObjectOutputStream obs = new ObjectOutputStream(f)) {
            obs.writeObject(catalog);
        } catch (IOException ex) {
            System.out.println("Exception caught.");
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, FileNotFoundException {
        Catalog obj = null;
        try {
            FileInputStream f = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(f);
            obj = (Catalog) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception caught.");
        }
        return obj;
    }
}