package theryhma.sovellus.question;

import java.util.ArrayList;

import theryhma.sovellus.state.State;

// todo: questionnaire generator

public class Questionnaire {
    private ArrayList<Question> questions;

    public Questionnaire() {
        this.questions = new ArrayList<>();
        this.questions.add(QuestionConstants.get("pirteys"));
        this.questions.add(QuestionConstants.get("motivaatio"));
        this.questions.add(QuestionConstants.get("mieliala"));
        this.questions.add(QuestionConstants.get("syöminen"));
        this.questions.add(QuestionConstants.get("jotain"));
    }

    public Question getQuestion(int i) {
        return this.questions.get(i);
    }

    public ArrayList<State> createResultStates() {
        ArrayList<State> states = new ArrayList<>();
        for (Question q : questions) {
            states.add(q.createResultState());
            //Log.d("supergetresult", q.getText() + " " + q.getAnswer() + " " + q.getStatus().toString());
        }
        return states;
    }
}
