package theryhma.sovellus.question;

import java.util.ArrayList;

import theryhma.sovellus.Instruction.Instruction;
import theryhma.sovellus.state.State;
import theryhma.sovellus.tools.Maths;

// todo: questionnaire generator

public class Questionnaire {
    private ArrayList<Question> questions;
    private static final int QUESTIONS_AMOUNT = 5;

    public Questionnaire() {
        ArrayList<Question> reference = QuestionConstants.createArray();
        questions = new ArrayList<>();
        for (int i = 0; i < QUESTIONS_AMOUNT; i++) {

            int index = Maths.getRandomIntegerBetweenRange(0, reference.size() - 1);
            questions.add(reference.get(index));
            reference.remove(index);
        }
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
