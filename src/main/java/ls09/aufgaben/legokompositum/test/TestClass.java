package ls09.aufgaben.legokompositum.test;

import ls09.aufgaben.legokompositum.FertigBauteil;
import ls09.aufgaben.legokompositum.Komposition;
import ls09.aufgaben.legokompositum.LegoGebaeude;
import ls09.aufgaben.legokompositum.LegoStein;
import ls09.aufgaben.legokompositum.util.LegoBauteilAutoToString;

import java.awt.*;

public class TestClass {

    public static void main(String[] args) {
        //Einfach mal so tun als wären diese Testdaten sinnvoll...
        LegoStein stein1 = new LegoStein(Color.RED, 2, .07);
        LegoStein stein2 = new LegoStein(Color.RED, 4, .06);
        LegoStein stein3 = new LegoStein(Color.RED, 8, .17);
        LegoStein stein4 = new LegoStein(Color.RED, 6, .27);
        LegoStein stein5 = new LegoStein(Color.RED, 3, .07);
        LegoStein stein6 = new LegoStein(Color.RED, 1, .05);
        LegoStein stein7 = new LegoStein(Color.RED, 4, .01);
        LegoStein stein8 = new LegoStein(Color.RED, 6, .19);
        LegoStein stein9 = new LegoStein(Color.RED, 1, .21);
        LegoStein stein10 = new LegoStein(Color.RED, 8, .22);
        LegoStein stein11 = new LegoStein(Color.RED, 2, .34);

        FertigBauteil bauteil1 = new FertigBauteil(stein1, stein1, stein1, stein2, stein2, stein5, stein5, stein5, stein7, stein7, stein11);
        FertigBauteil bauteil2 = new FertigBauteil(stein2, stein2, stein2, stein3, stein3, stein4, stein4, stein6, stein8, stein8, stein8, stein8, stein8, stein9, stein9, stein9, stein10, stein10);
        FertigBauteil bauteil3 = new FertigBauteil(stein1, stein1, stein2, stein2, stein2, stein4, stein4, stein4, stein4, stein5, stein5, stein5, stein7, stein11);
        FertigBauteil bauteil4 = new FertigBauteil(stein2, stein2, stein2, stein3, stein3, stein4, stein4, stein6, stein8, stein8, stein8, stein9, stein9, stein9, stein9, stein9);
        FertigBauteil bauteil5 = new FertigBauteil(stein6, stein7, stein9, stein9, stein9, stein9, stein9, stein10, stein10, stein10, stein10, stein10);

        LegoGebaeude haus1 = new LegoGebaeude();
        haus1.addBauteil(bauteil1);
        haus1.addBauteil(bauteil1);
        haus1.addBauteil(bauteil2);
        haus1.addEinzelteil(stein1);
        haus1.addEinzelteil(stein2);
        haus1.addEinzelteil(stein2);
        haus1.addEinzelteil(stein2);

        LegoGebaeude haus2 = new LegoGebaeude();
        haus2.addBauteil(bauteil3);
        haus2.addBauteil(bauteil4);
        haus2.addEinzelteil(stein11);
        haus2.addEinzelteil(stein11);
        haus2.addEinzelteil(stein11);
        haus2.addEinzelteil(stein11);

        Komposition stadt = new Komposition(haus1, haus2, bauteil5, stein1, stein2, stein3, stein4);

        System.out.println(stadt.preis());

    }
}
