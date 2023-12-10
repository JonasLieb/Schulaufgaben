package ls14.aufgaben.watergun.FillStates;

import ls14.aufgaben.watergun.WaterGun;

public class PartiallyFilledState extends FillState {

    public PartiallyFilledState(WaterGun gun) {
        super(gun);
    }

    @Override
    public int addWater(int ml) {
        return Math.min(gun.getCurrent() + ml, gun.MAX_CAPACITY);
    }

    @Override
    public int shootWater() {
        return Math.min(50, gun.getCurrent());
    }
}
