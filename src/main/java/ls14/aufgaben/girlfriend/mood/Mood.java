package ls14.aufgaben.girlfriend.mood;

public abstract class Mood {
    public Mood angerGirlfriend() {
        return new PissedMood();
    }

    public abstract Mood kissGirlfriend();

    public abstract String talk(String text);
}
