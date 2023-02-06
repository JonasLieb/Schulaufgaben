package ls03.aufgaben.klassenundmethoden.aufgabe1;

public class MitarbeiterTest {
    public static void main(String[] args) {
        //Erzeugen eines Mitarbeiters mit falscher id:
        System.out.println("Erzeugen eines Mitarbeiters mit falscher id:");
        try {
            new Mitarbeiter("Karl", -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Erzeugen eines Mitarbeiters mit falschem Namen:
        System.out.println("Erzeugen eines Mitarbeiters mit falschem Namen:");
        try {
            new Mitarbeiter(" ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Erzeugen eines Mitarbeiters mit richtigen Daten:");
        Mitarbeiter ma = new Mitarbeiter("Karl", 5000);
        System.out.println(ma);

        System.out.println("Verändern des Mitarbeiters:");
        ma.setName("Nicht mehr Karl");
        ma.setId(4000);
        System.out.println(ma);
    }
}
