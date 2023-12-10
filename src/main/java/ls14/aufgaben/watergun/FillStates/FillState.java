package ls14.aufgaben.watergun.FillStates;

import ls14.aufgaben.watergun.WaterGun;

public abstract class FillState {
    protected final WaterGun gun;

    public FillState(WaterGun gun) {
        this.gun = gun;
    }

    public abstract int addWater(int ml); //Gibt die neue Füllmenge zurück

    public abstract int shootWater(); //Gibt geschossene Menge zurück

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
