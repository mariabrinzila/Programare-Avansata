import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> itemList = new ArrayList<>();
    private int nrElemList;

    public Catalog() {
        nrElemList = 0;
    }

    public Catalog(String name, String path, List<Item> itemList, int nrElemList) {
        this.name = name;
        this.path = path;
        this.itemList = itemList;
        this.nrElemList = nrElemList;
    }

    public void add(Item other) {
        nrElemList++;
        itemList.add(other);
    }

    public void list() {
        int i;
        System.out.println("Nr elementelor din catalog este: ");
        System.out.println(nrElemList);
        System.out.println("Itemii din catalog sunt:");
        for (i = 0; i < nrElemList; i++)
            System.out.println(itemList.get(i).getName());
        System.out.println("Lista a fost afisata.");
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getNrElemList() {
        return nrElemList;
    }

    public void setNrElemList(int nrElemList) {
        this.nrElemList = nrElemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
