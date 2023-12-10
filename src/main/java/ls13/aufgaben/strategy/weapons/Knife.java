package ls13.aufgaben.strategy.weapons;

public class Knife extends WeaponBehavior {

    @Override
    protected void strikeWeapon() {
        System.out.println("Messerstich...");
    }

}