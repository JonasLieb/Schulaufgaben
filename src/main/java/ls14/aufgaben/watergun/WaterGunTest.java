package ls14.aufgaben.watergun;

public class WaterGunTest {
    public static void main(String[] args) {
        testWaterGun();
    }

    private static void testWaterGun() {
        WaterGun gun = new WaterGun();

        gun.addWater(500); //1. 500ml hinzufügen
        System.out.println("Water added. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());

        while (gun.getCurrent() > 0) { //Solange schießen bis leer
            gun.shootWater();
            System.out.println("Shot water. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());
        }


        gun.shootWater();
        System.out.println("Tried to shoot while pistol was empty. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());

        gun.addWater(100);
        System.out.println("Water added. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());

        while (gun.getCurrent() > 0) { //Solange schießen bis leer
            gun.shootWater();
            System.out.println("Shot water. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());
        }
        gun.shootWater();
        System.out.println("Tried to shoot while pistol was empty. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());
        gun.shootWater();
        System.out.println("Tried to shoot while pistol was empty. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());


        gun.addWater(77);
        System.out.println("Water added. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());

        while (gun.getCurrent() > 0) { //Solange schießen bis leer
            gun.shootWater();
            System.out.println("Shot water. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());
        }

        gun.addWater(600);
        System.out.println("Water added. New water-level: " + gun.getCurrent() + " | State: " + gun.getCurrentState());


    }
}
