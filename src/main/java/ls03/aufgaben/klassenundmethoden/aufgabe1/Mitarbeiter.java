package ls03.aufgaben.klassenundmethoden.aufgabe1;

public class Mitarbeiter {
    private int id;
    private String name;

    public Mitarbeiter(String name, int id) {
        setName(name);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("Die ID eines Mitarbeiters kann nur positiv sein.");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Der Name eines Mitarbeiters kann nicht leer sein.");
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mitarbeiter: [");
        sb.append("Name: ");
        sb.append(getName());
        sb.append(" | ");
        sb.append("ID: ");
        sb.append(id);
        sb.append("]");
        return sb.toString();
    }
}
