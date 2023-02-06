package ls03.aufgaben.klassenundkapselung.aufgabe2.musterklassen;

public class MainHundetest {

    public static void main(String[] args) {
        Hund bob = new Hund();
        bob.setGewicht(40.8);
        bob.setGroesse(80);
        bob.setRasse("Collie");
        bob.ausgabe();
    }

}
