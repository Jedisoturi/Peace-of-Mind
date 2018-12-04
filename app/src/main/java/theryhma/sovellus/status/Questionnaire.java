package theryhma.sovellus.status;

import android.util.Log;

import java.util.ArrayList;

public class Questionnaire {
    private ArrayList<Question> questions;

    public Questionnaire() {
        this.questions = new ArrayList<>();
        this.questions.add(QuestionContainer.get(0));
        this.questions.add(QuestionContainer.get(1));
        this.questions.add(QuestionContainer.get(2));
    }

    public Question getQuestion(int i) {
        return this.questions.get(i);
    }

    public Status getResult() {
        ArrayList<Status> statuses = new ArrayList<>();
        for (Question q : questions) {
            statuses.add(q.getStatus());
            //Log.d("supergetresult", q.getText() + " " + q.getAnswer() + " " + q.getStatus().toString());
        }
        Status result = StatusTools.getNonZeroMeanStatus(statuses);
        return result;
    }
}
