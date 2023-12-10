package ls14.aufgaben.watergun;

import ls14.aufgaben.watergun.FillStates.EmptyState;
import ls14.aufgaben.watergun.FillStates.FillState;
import ls14.aufgaben.watergun.FillStates.FullState;
import ls14.aufgaben.watergun.FillStates.PartiallyFilledState;

public class WaterGun {
    public final int MAX_CAPACITY = 500;
    private int current = 0;
    private final FillState FILLED_STATE;
    private final FillState PARTIALLY_FILLED_STATE;
    private final FillState EMPTY_STATE;
    private FillState currentState;

    public WaterGun() {
        FILLED_STATE = new FullState(this);
        PARTIALLY_FILLED_STATE = new PartiallyFilledState(this);
        EMPTY_STATE = new EmptyState(this);
        currentState = EMPTY_STATE;
    }

    public int getCurrent() {
        return current;
    }

    private void setCurrent(int current) {
        this.current = current;
    }

    public FillState getCurrentState() {
        return currentState;
    }

    public void addWater(int ml) {
        this.setCurrent(currentState.addWater(ml));
        updateState();
    }

    public void shootWater() {
        this.setCurrent(getCurrent() - currentState.shootWater());
        updateState();
    }

    private void updateState() {
        int ml = getCurrent();
        if (ml == 0) {
            currentState = EMPTY_STATE;
        } else if (ml >= MAX_CAPACITY) {
            currentState = FILLED_STATE;
        } else {
            currentState = PARTIALLY_FILLED_STATE;
        }
    }
}
