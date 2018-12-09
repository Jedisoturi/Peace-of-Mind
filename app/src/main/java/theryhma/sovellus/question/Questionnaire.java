package theryhma.sovellus.question;

import java.util.ArrayList;

import theryhma.sovellus.state.State;

// todo: questionnaire generator

public class Questionnaire {
    private ArrayList<Question> questions;

    public Questionnaire() {
        this.questions = new ArrayList<>();
        this.questions.add(QuestionConstants.get(0));
        this.questions.add(QuestionConstants.get(1));
        this.questions.add(QuestionConstants.get(2));
        this.questions.add(QuestionConstants.get(3));
        this.questions.add(QuestionConstants.get(4));
    }

    public Question getQuestion(int i) {
        return this.questions.get(i);
    }

    public ArrayList<State> getResults() {
        ArrayList<State> states = new ArrayList<>();
        for (Question q : questions) {
            states.add(q.getResultStatus());
            //Log.d("supergetresult", q.getText() + " " + q.getAnswer() + " " + q.getStatus().toString());
        }
        return states;
    }
}
