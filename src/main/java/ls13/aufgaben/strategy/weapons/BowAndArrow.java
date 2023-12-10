package ls13.aufgaben.strategy.weapons;

public class BowAndArrow extends WeaponBehavior {
    @Override
    protected void prepareWeapon() {
        System.out.println("Bogen Vorbereiten...");
    }


    @Override
    protected void strikeWeapon() {
        System.out.println("Bogenangriff...");
    }

}