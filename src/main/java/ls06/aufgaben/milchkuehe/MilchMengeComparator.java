package ls06.aufgaben.milchkuehe;

import java.util.Comparator;

public class MilchMengeComparator implements Comparator<Milchkuh> {
    @Override
    public int compare(Milchkuh o1, Milchkuh o2) {
        return Double.compare(o1.getMaxMilchMenge(), o2.getMaxMilchMenge());
    }
}
