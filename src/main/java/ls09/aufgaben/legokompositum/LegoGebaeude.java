package ls09.aufgaben.legokompositum;

import ls09.aufgaben.legokompositum.util.LegoBauteil;

import java.util.ArrayList;
import java.util.List;

public class LegoGebaeude extends LegoBauteil {
    private final List<LegoStein> einzelteile = new ArrayList<>();
    private final List<FertigBauteil> fertigteile = new ArrayList<>();

    public LegoGebaeude(
            /*Hier könnten bsp. zwei ArrayLists mitgegeben werden*/) {
    }


    /**
     * Fügt einen einzelnen Stein zu dem Gebäude hinzu
     *
     * @param stein der neu hinzugefügte Stein
     */
    public void addEinzelteil(LegoStein stein) {
        if (stein == null) return;
        //Kann mehrfach vorhanden sein
        einzelteile.add(stein);
    }

    /**
     * Fügt ein neues FertigBauteil zu dem Kompositum hinzu
     *
     * @param bauteil das neu hinzugefügte Bauteil
     */
    public void addBauteil(FertigBauteil bauteil) {
        if (bauteil == null) return;
        //Kann mehrfach vorhanden sein
        fertigteile.add(bauteil);
    }

    @Override
    public double preis() {
        double preis = 0;
        for (LegoStein stein : einzelteile) preis += stein.preis();
        for (FertigBauteil stein : fertigteile) preis += stein.preis();
        return preis;
    }
}
