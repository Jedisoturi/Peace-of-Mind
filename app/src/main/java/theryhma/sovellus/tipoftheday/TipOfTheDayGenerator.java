package theryhma.sovellus.tipoftheday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.tools.Maths;
import theryhma.sovellus.views.calendardetails.CalendarDetailsViewPager;

/**
 * This generator is responsible for generating a random new TipOfTheDay object every day. The tip is selected
 * from TipOfTheDayConstants, which contains all tips.
 * Object variables are the generated tip, the date it was generated, and a list of keys for tips inside the TipOfTheDayConstants.
 * The key list is used to store the keys of all shown tips.
 * This class resets itself once there are no new tips to be found inside the TipOfTheDayConstants
 * (the last tip is added to the key list, so that the tip of the day will never repeat itself).
 */
public class TipOfTheDayGenerator {
    private ArrayList<String> keysOfTipsSeen;
    private TipOfTheDay currentTip;
    private Calendar dateGenerated;

    /**
     * An empty generator is created, with a default date, and an empty list of keys of seen tips
     */
    public TipOfTheDayGenerator() {
        dateGenerated = new GregorianCalendar(1900, 0, 1);
        keysOfTipsSeen = new ArrayList<>();
    }

    /**
     *
     */
    private void addKey(String key) {
        if (!keysOfTipsSeen.contains(key)) {
            keysOfTipsSeen.add(key);
        }
    }

    public TipOfTheDay getCurrentTip() {
        return currentTip;
    }

    public Calendar getDateGenerated() {
        return dateGenerated;
    }

    public void generate() {
        if (isAllSeen()) {
            reset();
        }
        dateGenerated = Calendar.getInstance();
        String key = getRandomTipKey();
        addKey(key);
        currentTip = TipOfTheDayConstants.get(key);
    }

    private String getRandomTipKey() {
        ArrayList<String> allKeys = TipOfTheDayConstants.createKeyArray();
        ArrayList<String> possibleKeys = new ArrayList<>();
        for (String key : allKeys) {
            if (!keysOfTipsSeen.contains(key)) {
                possibleKeys.add(key);
            }
        }
        String key = possibleKeys.get(Maths.getRandomIntegerBetweenRange(0, possibleKeys.size() - 1));
        return key;
    }

    private void reset() {
        String lastTipKey = keysOfTipsSeen.get(keysOfTipsSeen.size() - 1);
        keysOfTipsSeen.clear();
        addKey(lastTipKey);
    }

    private boolean isAllSeen() {
        return TipOfTheDayConstants.size() <= keysOfTipsSeen.size();
    }
}
