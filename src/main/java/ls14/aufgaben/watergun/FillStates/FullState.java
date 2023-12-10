package ls14.aufgaben.watergun.FillStates;

import ls14.aufgaben.watergun.WaterGun;

public class FullState extends FillState {

    public FullState(WaterGun gun) {
        super(gun);
    }

    @Override
    public int addWater(int ml) {
        return gun.MAX_CAPACITY;
    }

    @Override
    public int shootWater() {
        return 100;
    }
}
