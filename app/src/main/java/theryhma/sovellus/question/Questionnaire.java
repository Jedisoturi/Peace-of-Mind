package theryhma.sovellus.question;

import java.util.ArrayList;

import theryhma.sovellus.Instruction.Instruction;
import theryhma.sovellus.state.State;
import theryhma.sovellus.tools.Maths;

// todo: questionnaire generator

public class Questionnaire {
    private ArrayList<Question> questions;
    public static final int QUESTIONS_AMOUNT = 5;

    public Questionnaire() {
        ArrayList<Question> reference = QuestionConstants.createArray();
        questions = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            questions.add(getRandomQuestion(reference));
        }

        /*this.questions = new ArrayList<>();
        this.questions.add(QuestionConstants.get("pirteys"));
        this.questions.add(QuestionConstants.get("motivaatio"));
        this.questions.add(QuestionConstants.get("mieliala"));
        this.questions.add(QuestionConstants.get("syöminen"));
        this.questions.add(QuestionConstants.get("jotain"));*/

    }

    private static Question getRandomQuestion(ArrayList<Question> list) {
        int i = Maths.getRandomIntegerBetweenRange(0, list.size() - 1);
        Question q = list.get(i);
        list.remove(i);
        return q;
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
