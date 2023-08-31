package ls09.aufgaben.oberserver.wetterstation;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import ls09.aufgaben.oberserver.wetterstation.observable.WetterDaten;
import ls09.aufgaben.oberserver.wetterstation.observer.AktuelleBedingungen;
import ls09.aufgaben.oberserver.wetterstation.observer.WetterVorhersage;

import javax.swing.*;
import java.util.Random;

public class Main {

    private static final Random zM = new Random();

    public static void main(String[] args) {
        WetterDaten wetterDaten = new WetterDaten(26, 20, 1000);
        AktuelleBedingungen aktuell = new AktuelleBedingungen(wetterDaten);
        WetterVorhersage vorhersage = new WetterVorhersage(wetterDaten);
        //GUI einbauen
        FlatArcDarkIJTheme.setup();
        WetterGUI gui = new WetterGUI(aktuell, vorhersage);
        gui.setVisible(true);

        manipulateWeather(wetterDaten);
    }

    private static void manipulateWeather(WetterDaten wetterDaten) {
        try {
            while (true) {
                int welcher = zM.nextInt(3);
                float wert = 0f;
                switch (welcher) {
                    case 0:
                        wetterDaten.setTemperatur(wetterDaten.getTemperatur() + (zM.nextInt(8) - 4));
                        break;
                    case 1:
                        wert = wetterDaten.getFeuchtigkeit() + zM.nextInt(40) - 20;
                        if (wert >= 0)
                            wetterDaten.setFeuchtigkeit(wert);
                        break;
                    case 2:
                        wert = wetterDaten.getLuftdruck() + zM.nextInt(30) - 15;
                        if (wert >= 650)
                            wetterDaten.setLuftdruck(wert);
                        break;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
