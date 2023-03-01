package ls06.aufgaben.milchkuehe;

import java.util.Comparator;

public class KuhNamensComparator implements Comparator<Milchkuh> {
    @Override
    public int compare(Milchkuh o1, Milchkuh o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
