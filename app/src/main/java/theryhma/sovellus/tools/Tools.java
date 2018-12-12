package theryhma.sovellus.tools;

import java.util.Calendar;

/** This code compares two Calendar objects' dates, and checks whether they are the same or not.
 * This method is used in the Tip Of The Day -generator.*/
public class Tools {
    public static boolean isSameDay(Calendar date1, Calendar date2) {
        return date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR) &&
                date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH) &&
                date1.get(Calendar.DAY_OF_MONTH) == date2.get(Calendar.DAY_OF_MONTH);
    }
}
