package ls03.aufgaben.klassenundkapselung.aufgabe2.kfz;

/**
 * KFZ-Klasse nach Vorlage der Klasse Hund mit einigen kleinen Anpassungen
 */
public class KFZ_Einfach {
    private String hersteller; //z.B. Nissan (Hier ist eine Enum / eine eigene Klasse "Hersteller" sicher schöner)
    private String baureihe; //z.B. Silvia
    private String spezifikation;//z.B. S13

    private int leistung;//z.B. 169 (für 169ps)
    //Hier kann man unendlich weitermachen: Fahrer, Motor, status des Motors, Anzahl der Türen, verbaute Spezialteile, Preis, usw.

    public KFZ_Einfach(String hersteller, String baureihe, String spezifikation, int leistung) {
        setHersteller(hersteller);
        setBaureihe(baureihe);
        setSpezifikation(spezifikation);
        setLeistung(leistung);
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        //TODO: hier prüfen ob der Hersteller existiert
        this.hersteller = hersteller;
    }

    public String getBaureihe() {
        return baureihe;
    }

    public void setBaureihe(String baureihe) {
        //TODO: hier prüfen ob die Baureihe existiert
        this.baureihe = baureihe;
    }

    public String getSpezifikation() {
        return spezifikation;
    }

    public void setSpezifikation(String spezifikation) {
        //TODO: hier prüfen ob die Spezifikation existiert
        this.spezifikation = spezifikation;
    }

    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) {
        if (leistung < 1) {
            throw new IllegalArgumentException("Die Leistung eines Fahrzeugs kann nicht kleiner als 1 sein");
        }
        this.leistung = leistung;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KFZ: [");
        sb.append("Hersteller: ");
        sb.append(getHersteller());
        sb.append(" | ");
        sb.append("Baureihe: ");
        sb.append(getBaureihe());
        sb.append(" | ");
        sb.append("Spezifikation: ");
        sb.append(getSpezifikation());
        sb.append(" | ");
        sb.append("Leistung: ");
        sb.append(getLeistung());
        sb.append("ps");
        sb.append("]");
        return sb.toString();
    }
}
