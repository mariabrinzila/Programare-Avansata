import java.util.Objects;

/**
 * Clasa Source este abstracta si contine sursele (numele si tipul lor)
 * protected -> pentru ca este abstracta
 * nu are vreo metoda abstracta -> clasele ce o vor mosteni vor avea toate aceste metode asa cum sunt scrise aici
 */

public abstract class Source {
    protected String name;
    protected String type;

    public Source(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name);
    }
}
