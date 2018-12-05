package theryhma.sovellus.question;

import android.util.Log;

import java.util.ArrayList;

import theryhma.sovellus.status.Status;

public class Question {
    private String questionText;
    private ArrayList<String> answers;
    private Answer answer;
    private Status weights;

    private static final int ANSWERS_AMOUNT = 5;
    private static final double BEST_WEIGHT = 1.0;
    private static final double GOOD_WEIGHT = 0.5;
    private static final double MED_WEIGHT = 0.0;
    private static final double BAD_WEIGHT = -0.5;
    private static final double WORST_WEIGHT = -1.0;


    public Question(String text, ArrayList<String> answers, Status weights) {
        if (answers.size() != ANSWERS_AMOUNT) {
            throw new IllegalArgumentException("A question must have 5 answers");
        }
        this.questionText = text;
        this.answers = answers;
        this.weights = weights;
        this.answer = Answer.NEUTRAL;
        Log.d("supergetstatus", "CREATE: " + getText() + " " + getAnswer() + " answer:" + answer + " status:" + this.weights);
    }

    public void setAnswer(Answer answer) {
        //Log.d("supergetstatus", getText() + " " + getAnswer() + " answer:" + answer + " status:" + this.weights);
        this.answer = answer;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public String getText() {
        return this.questionText;
    }

    public Status getStatus() {
        double weight = 0;
        switch (this.answer) {
            case BEST:
                weight = BEST_WEIGHT;
                break;
            case GOOD:
                weight = GOOD_WEIGHT;
                break;
            case NEUTRAL:
                weight = MED_WEIGHT;
                break;
            case BAD:
                weight = BAD_WEIGHT;
                break;
            case WORST:
                weight = WORST_WEIGHT;
                break;
        }
        //Log.d("supergetstatus", getText() + " " + getAnswer() + " weight:" + Double.toString(weight) + " status:" + this.weights);
        Status status = new Status(this.weights);
        //status.scale(weight);
        return status;
    }
}
