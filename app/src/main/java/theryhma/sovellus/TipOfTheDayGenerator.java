package theryhma.sovellus;

import java.util.ArrayList;

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
        TipOfTheDay tip = TipOfTheDayContainer.get(i);
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
        for (int i = 0; i < TipOfTheDayContainer.size(); i++) {
            if (!offLimits.contains(i)) {
                indices.add(i);
            }
        }
        return indices;
    }

    private static int getRandomIndex(ArrayList<Integer> possibleIndices) {
        return possibleIndices.get(getRandomIntegerBetweenRange(0, possibleIndices.size() - 1));
    }

    private static void saveIndex(int i) {
        GlobalModel.getInstance().addToIndicesOfTipsSeen(i);
    }

    private static boolean isAllSeen() {
        int seenSize = GlobalModel.getInstance().getIndicesOfTipsSeen().size();
        if (TipOfTheDayContainer.size() <= seenSize) {
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

    private static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
