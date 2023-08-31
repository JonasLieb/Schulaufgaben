package ls09.aufgaben.legokompositum;

import ls09.aufgaben.legokompositum.util.LegoBauteil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FertigBauteil extends LegoBauteil {
    private final List<LegoStein> teile = new ArrayList<>();

    public FertigBauteil(LegoStein... alleBauteile) {
        this(Arrays.asList(alleBauteile));
    }

    public FertigBauteil(List<LegoStein> alleBauteile) {
        alleBauteile.forEach(this::addEinzelteil);
    }

    /**
     * Fügt einen einzelnen Stein zu dem Fertigbauteil hinzu
     *
     * @param stein der neu hinzugefügte Stein
     */
    public void addEinzelteil(LegoStein stein) {
        if (stein == null) return;
        //Kann mehrfach vorhanden sein
        teile.add(stein);
    }

    @Override
    public double preis() {
        double preis = 0;
        for (LegoStein stein : teile) {
            preis += stein.preis();
        }
        return preis;
    }
}
