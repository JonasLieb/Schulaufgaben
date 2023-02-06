package ls03.aufgaben.klassenundkapselung.aufgabe2.aixcargroup;


import java.util.HashSet;
import java.util.Set;

public class Standort {
    private final Set<KFZ> fuhrpark = new HashSet<>();

    private String name;

    public Standort(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Der Name eines Standortes darf niemals leer sein");
        this.name = name;
    }

    protected void addFahrzeug(KFZ kfz) {
        if (fuhrpark.contains(kfz)) {
            System.out.println("Das Fahrzeug " + kfz + " ist im Fuhrpark bereits enthalten.");
        }
        if (!fuhrpark.add(kfz)) System.out.println("Das Fahrzeug war bereits vorhanden");
    }

    protected void removeFahrzeug(KFZ kfz) {
        fuhrpark.remove(kfz);
    }
}
