package ls09.aufgaben.legokompositum;

import ls09.aufgaben.legokompositum.util.LegoBauteil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Komposition extends LegoBauteil {

    private final List<LegoBauteil> alleBauteile = new ArrayList<>();
    //TODO: Ggf. einzelne Listen für die verschiedenen Bauteile einbauen

    public Komposition(LegoBauteil... alleBauteile) {
        this(Arrays.asList(alleBauteile));
    }

    public Komposition(List<LegoBauteil> alleBauteile) {
        alleBauteile.forEach(this::addBauteil);
    }

    /**
     * Fügt ein neues Bauteil zu dem Kompositum hinzu.
     *
     * @param bauteil das neu hinzugefügte Bauteil
     */
    public void addBauteil(LegoBauteil bauteil) {
        if (bauteil == null) return;
        //Kann mehrfach vorhanden sein
        alleBauteile.add(bauteil);
    }

    @Override
    public double preis() {
        double preis = 0;
        for (LegoBauteil bauteil : alleBauteile) preis += bauteil.preis();
        return preis;
    }
}
