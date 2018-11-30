package theryhma.sovellus;

import java.util.ArrayList;

class GlobalModel {
    private ArrayList<Integer> indicesOfTipsSeen;
    private static final GlobalModel ourInstance = new GlobalModel();

    static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        indicesOfTipsSeen = new ArrayList<>();
        // init tipsSeen (what tips have been seen?)
    }

    public ArrayList<Integer> getIndicesOfTipsSeen() {
        return this.indicesOfTipsSeen;
    }
    public void addToIndicesOfTipsSeen(int i) {
        if (!this.indicesOfTipsSeen.contains(i)) {
            this.indicesOfTipsSeen.add(i);
        }
    }

    public void clearIndicesOfTipsSeen() {
        this.indicesOfTipsSeen.clear();
    }
}
