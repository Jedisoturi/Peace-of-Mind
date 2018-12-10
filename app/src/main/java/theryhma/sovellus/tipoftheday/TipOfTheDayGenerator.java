package theryhma.sovellus.tipoftheday;

import java.util.ArrayList;
import java.util.Calendar;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.tools.Maths;
import theryhma.sovellus.views.calendardetails.CalendarDetailsViewPager;

/*
Communicates with GlobalModel to generate a new TipOfTheDay that is random and not the same as the last one
 */

public class TipOfTheDayGenerator {
    private ArrayList<String> keysOfTipsSeen;
    private TipOfTheDay currentTip;
    private Calendar dateGenerated;

    public TipOfTheDayGenerator() {
        keysOfTipsSeen = new ArrayList<>();
    }

    public void addKey(String key) {
        if (!keysOfTipsSeen.contains(key)) {
            keysOfTipsSeen.add(key);
        }
    }

    public TipOfTheDay getCurrentTip() {
        return currentTip;
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
