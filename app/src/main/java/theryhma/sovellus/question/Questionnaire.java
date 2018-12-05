package theryhma.sovellus.question;

import java.util.ArrayList;

import theryhma.sovellus.status.Status;

// todo: questionnaire generator

public class Questionnaire {
    private ArrayList<Question> questions;

    public Questionnaire() {
        this.questions = new ArrayList<>();
        this.questions.add(QuestionConstants.get(0));
        this.questions.add(QuestionConstants.get(1));
        this.questions.add(QuestionConstants.get(2));
        this.questions.add(QuestionConstants.get(3));

    }

    public Question getQuestion(int i) {
        return this.questions.get(i);
    }

    public ArrayList<Status> getResults() {
        ArrayList<Status> statuses = new ArrayList<>();
        for (Question q : questions) {
            statuses.add(q.getResultStatus());
            //Log.d("supergetresult", q.getText() + " " + q.getAnswer() + " " + q.getStatus().toString());
        }
        return statuses;
    }
}
