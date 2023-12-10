package ls13.aufgaben.strategy.weapons;

public class Sword extends WeaponBehavior {

    @Override
    protected void strikeWeapon() {
        System.out.println("Schwertschlag...");
    }

}