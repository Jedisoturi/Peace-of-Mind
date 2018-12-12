package theryhma.sovellus.question;

import java.util.ArrayList;

import theryhma.sovellus.Instruction.Instruction;
import theryhma.sovellus.state.State;
import theryhma.sovellus.tools.Maths;

/**
 * Contains and generates the Questions of a Questionnaire. It's job is to create a list of randomly chosen
 * Questions from the QuestionConstants, be their container, and then return all of their resulting States as a list.
 */
public class Questionnaire {
    private ArrayList<Question> questions;
    private static final int QUESTIONS_AMOUNT = 5;

    /**
     * Creates a new Questionnaire by choosing randomly five different Questions from the QuestionConstants map
     */
    public Questionnaire() {
        ArrayList<Question> reference = QuestionConstants.createArray();
        questions = new ArrayList<>();
        // add five random questions to the list
        for (int i = 0; i < QUESTIONS_AMOUNT; i++) {
            int index = Maths.getRandomIntegerBetweenRange(0, reference.size() - 1);
            questions.add(reference.get(index));
            reference.remove(index);    // remove from the list, so that there will be no duplicates
        }
    }

    /**
     * Returns a Question by index
     */
    public Question getQuestion(int i) {
        return this.questions.get(i);
    }

    /**
     * Returns an array of the resulting States
     */
    public ArrayList<State> createResultStates() {
        ArrayList<State> states = new ArrayList<>();
        for (Question q : questions) {
            states.add(q.createResultState());
        }
        return states;
    }
}
