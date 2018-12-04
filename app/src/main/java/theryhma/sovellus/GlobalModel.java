package theryhma.sovellus;

import java.util.ArrayList;

import theryhma.sovellus.question.Questionnaire;
import theryhma.sovellus.status.Status;

public class GlobalModel {
    private ArrayList<Integer> indicesOfTipsSeen;
    private ArrayList<Status> statuses;
    private Questionnaire questionnaire;
    private static final GlobalModel ourInstance = new GlobalModel();

    public static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        indicesOfTipsSeen = new ArrayList<>();
        statuses = new ArrayList<>();
        questionnaire = new Questionnaire();
        // init tipsSeen (what tips have been seen?)
    }

    public ArrayList<Integer> getIndicesOfTipsSeen() {
        return this.indicesOfTipsSeen;
    }
    public ArrayList<Status> getStatuses() { return this.statuses; }
    public Questionnaire getQuestionnaire() { return this.questionnaire; }

    public void addToIndicesOfTipsSeen(int i) {
        if (!this.indicesOfTipsSeen.contains(i)) {
            this.indicesOfTipsSeen.add(i);
        }
    }

    public void addStatuses(Status s) {
        this.statuses.add(s);
    }

    public void clearIndicesOfTipsSeen() {
        this.indicesOfTipsSeen.clear();
    }
}
