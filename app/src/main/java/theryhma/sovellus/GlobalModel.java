package theryhma.sovellus;

import java.util.ArrayList;

import theryhma.sovellus.question.Questionnaire;
import theryhma.sovellus.state.State;

public class GlobalModel {
    private ArrayList<Integer> indicesOfTipsSeen;
    private ArrayList<State> states;
    private Questionnaire questionnaire;
    private static final GlobalModel ourInstance = new GlobalModel();

    public static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        indicesOfTipsSeen = new ArrayList<>();
        states = new ArrayList<>();
        questionnaire = new Questionnaire();
        // init tipsSeen (what tips have been seen?)
    }

    public ArrayList<Integer> getIndicesOfTipsSeen() {
        return this.indicesOfTipsSeen;
    }
    public ArrayList<State> getStates() { return this.states; }
    public Questionnaire getQuestionnaire() { return this.questionnaire; }

    public void addToIndicesOfTipsSeen(int i) {
        if (!this.indicesOfTipsSeen.contains(i)) {
            this.indicesOfTipsSeen.add(i);
        }
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public void addStatuses(State s) {
        this.states.add(s);
    }

    public void clearIndicesOfTipsSeen() {
        this.indicesOfTipsSeen.clear();
    }
}
