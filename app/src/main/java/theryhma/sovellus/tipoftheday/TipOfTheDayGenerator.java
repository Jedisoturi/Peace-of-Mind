package theryhma.sovellus.tipoftheday;

import java.util.ArrayList;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.tools.Maths;

/*
Communicates with GlobalModel to generate a new TipOfTheDay that is random and not the same as the last one
 */

public class TipOfTheDayGenerator {

    public static TipOfTheDay generate() {
        if (isAllSeen()) {
            reset();
        }
        int i = getNewIndex();
        saveIndex(i);
        TipOfTheDay tip = TipOfTheDayConstants.get(i);
        return tip;
    }

    private static int getNewIndex() {
        ArrayList<Integer> offLimits = GlobalModel.getInstance().getIndicesOfTipsSeen();
        ArrayList<Integer> possibleIndices = createPossibleIndices(offLimits);
        int i = getRandomIndex(possibleIndices);
        return i;
    }

    private static ArrayList<Integer> createPossibleIndices(ArrayList<Integer> offLimits) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < TipOfTheDayConstants.size(); i++) {
            if (!offLimits.contains(i)) {
                indices.add(i);
            }
        }
        return indices;
    }

    private static int getRandomIndex(ArrayList<Integer> possibleIndices) {
        return possibleIndices.get(Maths.getRandomIntegerBetweenRange(0, possibleIndices.size() - 1));
    }

    private static void saveIndex(int i) {
        GlobalModel.getInstance().addToIndicesOfTipsSeen(i);
    }

    private static boolean isAllSeen() {
        int seenSize = GlobalModel.getInstance().getIndicesOfTipsSeen().size();
        if (TipOfTheDayConstants.size() <= seenSize) {
            return true;
        } else {
            return false;
        }
    }

    private static void reset() {
        int lastIndex = GlobalModel.getInstance().getIndicesOfTipsSeen().get(GlobalModel.getInstance().getIndicesOfTipsSeen().size() - 1);
        clear();
        saveIndex(lastIndex);
    }

    private static void clear() {
        GlobalModel.getInstance().clearIndicesOfTipsSeen();
    }
}
