package ls03.aufgaben.klassenundkapselung.aufgabe2.aixcargroup;

import java.util.HashSet;
import java.util.Set;

public class KFZVerwaltung {
    public Set<Standort> standorte = new HashSet<>();

    public void addStandort(Standort sOrt) {
        if (sOrt == null)
            throw new IllegalArgumentException("Einen leeren Standort können wir nicht speichern");
        if (!standorte.add(sOrt)) System.out.println("Der Standort war bereits vorhanden");
    }

    public void addFahrzeug(Standort s, KFZ kfz) {
        s.addFahrzeug(kfz);
    }

    public void removeFahrzeug(Standort s, KFZ kfz) {
        s.removeFahrzeug(kfz);
    }
}
