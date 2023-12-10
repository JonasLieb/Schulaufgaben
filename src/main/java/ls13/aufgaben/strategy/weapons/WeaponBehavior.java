package ls13.aufgaben.strategy.weapons;

public abstract class WeaponBehavior {
    public final void useWeapon() {
        drawWeapon();
        prepareWeapon();
        aimWeapon();
        strikeWeapon();
        holsterWeapon();
    }

    protected void drawWeapon() {
        System.out.println(getClass().getSimpleName() + " ziehen...(Default)");
    }

    protected void prepareWeapon() {
        System.out.println(getClass().getSimpleName() + " vorbereiten...(Default)");
    }

    protected void aimWeapon() {
        System.out.println("Ziel für " + getClass().getSimpleName() + " auswählen...(Default)");
    }

    protected void strikeWeapon() {
        System.out.println(getClass().getSimpleName() + "-Angriff...(Default)");
    }

    protected void holsterWeapon() {
        System.out.println(getClass().getSimpleName() + " wegpacken...(Default)");
    }
}
