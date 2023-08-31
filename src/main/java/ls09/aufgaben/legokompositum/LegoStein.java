package ls09.aufgaben.legokompositum;

import ls09.aufgaben.legokompositum.util.LegoBauteil;

import java.awt.*;
import java.util.List;

public class LegoStein extends LegoBauteil {
    private Color farbe;
    private int groesse;
    private double preis;

    public LegoStein(Color farbe, int groesse, double preis) {
        //TODO insert setters to catch invalid values
        this.preis = preis;
        this.groesse = groesse;
        this.farbe = farbe;
    }

    @Override
    public double preis() {
        return preis;
    }

    @Override
    public String toString() {
        return "Stein:[FARBE" + farbe + ",GRÖßE:" + groesse + ",PREIS:" + preis + "]";
    }
}
