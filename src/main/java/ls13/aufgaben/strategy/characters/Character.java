package ls13.aufgaben.strategy.characters;

import ls13.aufgaben.strategy.weapons.WeaponBehavior;

public class Character {
    WeaponBehavior currentWeapon;

    public Character(WeaponBehavior weaponBehavior) {
        setCurrentWeapon(currentWeapon);
    }

    public void setCurrentWeapon(WeaponBehavior currentWeapon) {
        if (currentWeapon == null) throw new IllegalArgumentException();
        this.currentWeapon = currentWeapon;
    }

    public void fight() {
        if (currentWeapon == null) {
            //TODO
            return;
        }
        currentWeapon.useWeapon();

    }
}
