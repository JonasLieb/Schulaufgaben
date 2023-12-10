package ls14.aufgaben.girlfriend.mood;

public class PissedMood extends Mood {
    private static final Mood NEUTRAL_MOOD = new NeutralMood();
    @Override
    public Mood kissGirlfriend() {
        return NEUTRAL_MOOD;
    }

    @Override
    public String talk(String text) {
        return "Pff...";
    }
}
