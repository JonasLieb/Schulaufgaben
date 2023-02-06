package ls03.aufgaben.klassenundkapselung.aufgabe2.kfz;

public class MainKFZTest {
    public static void main(String[] args) {
        KFZ_Einfach k = new KFZ_Einfach("Nissan", "Skyline", "GT-R R32", 280);
        System.out.println(k);

        //Werte verändern:
        k.setHersteller("Honda");
        k.setBaureihe("Integra");
        k.setSpezifikation("DC2 Type-R");
        k.setLeistung(190);
        System.out.println(k);
    }
}
