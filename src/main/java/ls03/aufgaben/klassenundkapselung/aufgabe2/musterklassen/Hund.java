package ls03.aufgaben.klassenundkapselung.aufgabe2.musterklassen;
/**
 * @author rollins
 */

/**
 * @class Hund
 */
public class Hund {

	/*
	Aufgabe: "Kommentieren Sie die Aufgabe
	Alle hierzu verfassten kommentare sind mit "Aufgabe2" gekennzeichnet
	* */

    /*
     * "Aufgabe2"
     * Ohne dass ein Objekt erzeugt wurde werden hier bereits Standardwerte festgelegt. Kann sinnvoll sein, sorgt aber besonders im beispiel Hund eher für Probleme (Weil der Konstruktor zur Zeit noch keine Werte erwartet)
     */
    private String name = "Bob";
    private int groesse = 60;
    private double gewicht = 20;
    private String rasse = "Promenadenmischung";

    /**
     * Aufgabe2
     * Gibt den Namen des Hundes zurück.
     *
     * @return den Namen des Hundes
     */
    public String getName() {
        return name;
    }

    /**
     * Aufgabe2
     * Ändert den Namen des Hundes.
     *
     * @param name der neue Name des Hundes
     */
    public void setName(String name) {

        String erlaubt = this.entferneSonderzeichen(name);

        if (erlaubt.length() > 1)
            this.name = erlaubt;
        else {
            System.out.println("Name ist zu kurz!");
        }
    }

    /**
     * Aufgabe2
     * Gibt die Größe des Hundes zurück.
     *
     * @return die Größe des Hundes
     */
    public int getGroesse() {
        return groesse;
    }

    /**
     * Aufgabe2
     * Überschreibt die Größe des Hundes.
     *
     * @param groesse die neue Größe des Hundes
     */
    public void setGroesse(int groesse) {
        // Der kleinste Hund ist mindestens 10 cm gro� aber nie groesser als 111cm:
        if (groesse < 10) {
            System.out.println(
                    "So klein ist kein Hund.  Der kleinste bekannt Hund war ein Chihuahua Namens Milly und war 9.65 cm hoch.");
            this.groesse = 10;
        } else if (groesse > 111) {
            System.out.println(
                    "So groß ist kein Hund. Der größte bekannte Hund war ein Great Dane Namens Zeus und war 1.118 m groß.");
            this.groesse = 111;
        } else {
            this.groesse = groesse;
        }
    }

    /**
     * Aufgabe2
     * Gibt das Gewicht des Hundes zurück.
     *
     * @return das Gewicht des Hundes
     */
    public double getGewicht() {
        return gewicht;
    }


    /**
     * Aufgabe2
     * Überschreibt das Gewicht des Hundes.
     *
     * @param gewicht das neue Gewicht des Hundes
     */
    //Aufgabe2:
    // Hier ist zu beachten: Wenn ein neuer Weltrekord für den schwersten Hund aufgestellt wird, dann ist der Code nicht mehr nutzbar.
    // Man sollte besser mit ein wenig Spiel arbeiten (>150 z.B.)
    // 1 Pfund entspricht ca. 0,45 Kg. Auch hier ist der Code also unzulässig. Es gibt bereits einen Hund der weniger als 0.5 Kg wog.
    // Auch das Arbeiten mit verschiedenen Einheiten (einmal Kilogramm und einmal Pfund) ist unschön.
    public void setGewicht(double gewicht) {

        if (gewicht < 0.5) {
            this.gewicht = 0.5;
            System.out.println(
                    "So wenig wiegt kein erwachsener Hund. Der leichteste Hund hieß Miracle Milly und wo ca. 1 Pfund.");
        } else if (gewicht > 143) {
            this.gewicht = 143;
            System.out.println("So schwer ist kein Hund. Der schwerste bekannte Hund hieß Zorbas und wog 143kg.");
        } else {
            this.gewicht = gewicht;
        }
    }

    /**
     * Aufgabe2
     * Gibt die Rasse des Hundes zurück.
     *
     * @return die Rasse des Hundes
     */
    public String getRasse() {
        return rasse;
    }

    /**
     * Aufgabe2
     * Überschreibt die Rasse des Hundes.
     *
     * @param rasse die neue Rasse des Hundes
     */
    //Aufgabe2: Die Rasse des Hundes sollte nicht von überall zu ändern sein. das Attribut muss final sein (die Rasse eines Hundes kann sich nicht ändern)
    public void setRasse(String rasse) {

        String erlaubt = this.entferneSonderzeichen(rasse);

        if (erlaubt.length() > 4)
            this.rasse = erlaubt;
        else {
            System.out.println("Die Rasse ist falsch geschrieben!");
        }
    }

    /**
     * Aufgabe2
     * Gibt alle Daten zu diesem Hund in der Konsole aus.
     */
    public void ausgabe() {
        System.out.println(this.name + " ist ein Hund der Rasse " + this.rasse + ".");
        System.out.println("Er ist " + this.groesse + " cm gro� und wiegt " + this.gewicht + " kg.");
    }

    /**
     * Aufgabe2
     * Gibt ein Bellen des Hundes in der Konsole aus.
     */
    public void bellen() {
        System.out.println("Wuff wuff");
    }

    /**
     * Aufgabe2
     * Gibt ein Knurren des Hundes in der Konsole aus.
     */
    public void knurren() {
        System.out.println("GRRRRRR");
    }

    /**
     * Aufgabe2
     * Entfernt Sonderzeichen aus dem übergebenen text.
     *
     * @param text
     * @return
     */
    //Aufgabe2 das gehört eher in eine Util-Klasse statt in die Klasse Hund (Generelle String-Verarbeitung statt spezifisch für den Hund zuständig)
    private String entferneSonderzeichen(String text) {

        String erlaubt = "";

        for (int i = 0, j = 0; i < text.length(); i++)
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                if (j == 0)
                    erlaubt += (char) (text.charAt(i) + ('A' - 'a'));//Abstand zwischen A und a als int
                else
                    erlaubt += text.charAt(i);
                j++;
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                if (j > 0)
                    erlaubt += (char) (text.charAt(i) - ('A' - 'a'));//Abstand zwischen A und a als int
                else
                    erlaubt += text.charAt(i);
                j++;
            }
        return erlaubt;
    }
}
