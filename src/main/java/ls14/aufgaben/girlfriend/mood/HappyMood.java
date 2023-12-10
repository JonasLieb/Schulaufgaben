package ls14.aufgaben.girlfriend.mood;

public class HappyMood extends Mood {

    @Override
    public Mood kissGirlfriend() {
        return new HappyMood();
    }

    @Override
    public String talk(String text) {
        String[] words = text.split(" ");
        String ret = "";
        for (int i = 0; i < words.length; i++) {
            if (i != 0) ret += " *kicher* ";
            ret += words[i];
        }
        return ret;
    }
}
