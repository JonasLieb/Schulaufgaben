package ls14.aufgaben.girlfriend;

public class TestGirlfriend {
    public static void main(String[] args) {
        Girlfriend g = new Girlfriend();

        //happy
        g.saySomething();

        //pissed
        g.angerGirlfriend();
        g.saySomething();

        //neutral
        g.kissGirlfriend();
        g.saySomething();

        //happy
        g.kissGirlfriend();
        g.saySomething();


        //pissed
        g.angerGirlfriend();
        g.saySomething();

        //neutral
        g.kissGirlfriend();
        g.saySomething();

        //pissed
        g.angerGirlfriend();
        g.saySomething();
    }
}
