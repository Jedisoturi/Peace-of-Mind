package theryhma.sovellus.tipoftheday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.tools.Maths;
import theryhma.sovellus.tools.Tools;
import theryhma.sovellus.views.calendardetails.CalendarDetailsViewPager;

/*
Uses:
Tools
Maths
 */

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
        // the following date will not cause problems if the user's date is set correctly
        dateGenerated = new GregorianCalendar(1900, 0, 1);
        keysOfTipsSeen = new ArrayList<>();
    }

    /**
     * Returns the current tip
     */
    public TipOfTheDay getCurrentTip() {
        return currentTip;
    }

    /**
     * Checks if the date has changed from the last time a tip was generated. If so a new tip is generated
     */
    public void invalidate() {
        Calendar currentDate = Calendar.getInstance();
        if (!Tools.isSameDay(dateGenerated, currentDate)) {
            dateGenerated = currentDate;
            generate();
        }
    }

    private void generate() {   // generates a new TipOfTheDay
        if (isAllSeen()) {
            reset();
        }
        String key = getRandomKey();
        addKey(key);
        currentTip = TipOfTheDayConstants.get(key);
    }

    private boolean isAllSeen() {   // returns true if there are more keys than tipConstants
        return TipOfTheDayConstants.size() <= keysOfTipsSeen.size();
    }

    private void reset() {  // clears the list of keys and adds the last key to the now empty list
        String lastTipKey = keysOfTipsSeen.get(keysOfTipsSeen.size() - 1);
        keysOfTipsSeen.clear();
        addKey(lastTipKey);
    }

    private void addKey(String key) {   // adds a key to the list. Doesn't allow duplicate keys inside
        if (!keysOfTipsSeen.contains(key)) {
            keysOfTipsSeen.add(key);
        }
    }

    private String getRandomKey() { // gets a random key
        ArrayList<String> allKeys = TipOfTheDayConstants.createKeyArray();  // creates an array of the keys of Tip constants
        ArrayList<String> possibleKeys = new ArrayList<>();
        for (String key : allKeys) {
            if (!keysOfTipsSeen.contains(key)) {    // if the key is not in the list, add it to the list of possible keys
                possibleKeys.add(key);
            }
        }
        // get a random key from the list of possible keys
        String key = possibleKeys.get(Maths.getRandomIntegerBetweenRange(0, possibleKeys.size() - 1));
        return key;
    }
}
