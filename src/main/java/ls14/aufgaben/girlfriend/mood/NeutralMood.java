package ls14.aufgaben.girlfriend.mood;

public class NeutralMood extends Mood {
    private static final Mood HAPPY_MOOD = new HappyMood();

    @Override
    public Mood kissGirlfriend() {
        return HAPPY_MOOD;
    }

    @Override
    public String talk(String text) {
        return text;
    }
}
