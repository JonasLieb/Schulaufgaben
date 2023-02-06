package ls03.aufgaben.klassenundkapselung.aufgabe2.aixcargroup;

public class KFZ {
    //Unveränderlich:
    private String hersteller; //z.B. Nissan (Hier ist eine Enum / eine eigene Klasse "Hersteller" sicher schöner)
    private String baureihe; //z.B. Silvia
    private String spezifikation;//z.B. S13
    private int leistung;//z.B. 169 (für 169ps)
    private double maximalerTankInhalt;
    private double maximaleGeschwindigkeit;

    //Veränderbar:
    private boolean isMotorAn = false;
    private double aktuellerTankinhalt = 0d;
    private double aktuelleGeschwindigkeit = 0d;
    private String fahrer = null;

    public KFZ(String hersteller, String baureihe, String spezifikation, int leistung, double maximalerTankInhalt, double maximaleGeschwindigkeit) {
        setHersteller(hersteller);
        setBaureihe(baureihe);
        setSpezifikation(spezifikation);
        setLeistung(leistung);
        setMaximalerTankInhalt(maximalerTankInhalt);
        setMaximaleGeschwindigkeit(maximaleGeschwindigkeit);
    }

    public String getHersteller() {
        return hersteller;
    }

    private void setHersteller(String hersteller) {
        //TODO: hier prüfen ob der Hersteller existiert
        this.hersteller = hersteller;
    }

    public String getBaureihe() {
        return baureihe;
    }

    private void setBaureihe(String baureihe) {
        //TODO: hier prüfen ob die Baureihe existiert
        this.baureihe = baureihe;
    }

    public String getSpezifikation() {
        return spezifikation;
    }

    private void setSpezifikation(String spezifikation) {
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


    public double getMaximalerTankInhalt() {
        return maximalerTankInhalt;
    }

    private void setMaximalerTankInhalt(double maximalerTankInhalt) {
        if (maximalerTankInhalt <= 0)
            throw new IllegalArgumentException("Der Maximale Tankinhalt kann nicht 0 oder kleiner sein");
        this.maximalerTankInhalt = maximalerTankInhalt;
    }

    public double getMaximaleGeschwindigkeit() {
        return maximaleGeschwindigkeit;
    }

    private void setMaximaleGeschwindigkeit(double maximaleGeschwindigkeit) {
        if (maximaleGeschwindigkeit <= 0)
            throw new IllegalArgumentException("Die maximale Geschwindigkeit kann nicht 0 oder kleiner sein");
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
    }


    public boolean isMotorAn() {
        return isMotorAn;
    }

    public void setMotorAn(boolean istMotorAn) {
        this.isMotorAn = istMotorAn;
    }

    public double getAktuellerTankinhalt() {
        return aktuellerTankinhalt;
    }

    //Bereits über tanke abgearbeitet -> private
    private void setAktuellerTankinhalt(double aktuellerTankinhalt) {
        if (aktuellerTankinhalt < 0)
            throw new IllegalArgumentException("Der aktuelle Tankinhalt kann nicht kleiner als null sein");
        if (aktuellerTankinhalt > maximalerTankInhalt)
            throw new IllegalArgumentException("Der aktuelle Tankinhalt kann nicht größer als der maximale Tankinhalt sein");
        this.aktuellerTankinhalt = aktuellerTankinhalt;
    }

    public double getAktuelleGeschwindigkeit() {
        return aktuelleGeschwindigkeit;
    }

    //Über Bremsen und Beschleunigen geregelt -> private
    private void setAktuelleGeschwindigkeit(double aktuelleGeschwindigkeit) {
        if (aktuelleGeschwindigkeit < 0)
            throw new IllegalArgumentException("Die aktuelle Geschwindigkeit kann nicht kleiner als null sein");
        if (aktuelleGeschwindigkeit > maximaleGeschwindigkeit)
            throw new IllegalArgumentException("Die aktuelle Geschwindigkeit kann nicht größer als die maximale Geschwindigkeit sein");
        this.aktuelleGeschwindigkeit = aktuelleGeschwindigkeit;
    }

    public String getFahrer() {
        return fahrer;
    }

    public void setFahrer(String fahrer) {
        this.fahrer = fahrer;
    }


    public void bremse(int geschwindigkeitsminderug) {
        setAktuelleGeschwindigkeit(Math.max(0, getAktuelleGeschwindigkeit() - geschwindigkeitsminderug));
    }

    public void beschleunige(int geschwindigkeitszuwachs) {
        setAktuelleGeschwindigkeit(Math.min(maximaleGeschwindigkeit, getAktuelleGeschwindigkeit() + geschwindigkeitszuwachs));
    }

    public double tanke(double liter) {
        double neuerInhalt = aktuellerTankinhalt + liter;
        setAktuellerTankinhalt(Math.min(maximalerTankInhalt, neuerInhalt));
        if (neuerInhalt > getMaximalerTankInhalt()) return neuerInhalt - getMaximalerTankInhalt();
        return 0d;
    }

    public void fahre(int km) {
        if (km <= 0) throw new IllegalArgumentException("Diese Strecke kann nicht gefahren werden");
        //what to do?!
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
        sb.append(" | ");
        sb.append("Maximaler Tankinhalt: ");
        sb.append(getMaximalerTankInhalt());
        sb.append(" | ");
        sb.append("Maximale Geschwindigkeit: ");
        sb.append(getMaximaleGeschwindigkeit());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Erzeugen eines Strings zur Ausgabe der Unveränderlichen Daten (Stammdaten) des Fahrzeuges.
     *
     * @return einen String der alle Stammdaten des Fahrzeuges enthält
     */
    public String getStammdaten() {
        return this.toString();
    }

    /**
     * Erzeugen eines Strings zur Ausgabe der Veränderlichen Daten (Bewegungsdaten) des Fahrzeuges.
     *
     * @return einen String der alle Bewegungsdaten des Fahrzeuges enthält
     */
    public String getBewegungsdaten() {
        StringBuilder sb = new StringBuilder();
        sb.append("KFZ (Bewegungsdaten): [");
        sb.append("Fahrer: ");
        sb.append(getFahrer());
        sb.append(" | ");
        sb.append("Motorstatus: ");
        sb.append(isMotorAn());
        sb.append(" | ");
        sb.append("Tankinhalt: ");
        sb.append(getAktuellerTankinhalt());
        sb.append(" | ");
        sb.append("Geschwindigkeit: ");
        sb.append(getAktuelleGeschwindigkeit());
        sb.append(" | ");
        sb.append("]");
        return sb.toString();
    }
}

