package theryhma.sovellus.question;

import java.util.ArrayList;
import java.util.Map;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.state.State;
/**
 * This class defines a single question. It contains the question text, the answer texts, a weight for each Attribute
 * and the currently selected answer.
 */
public class Question {
    private String questionText;
    private Map<AnswerType, String> answersMap;
    private Map<AttributeType, Double> weightMap;
    private AnswerType answer;

    private static final int ANSWERS_AMOUNT = 5;

    /**
     * Creates a question according to text and weight parameters. If there is no weight for an AttributeType than that type
     * is not taken into account when calculating the resulting State. Answer is set as NEUTRAL by default.
     */
    public Question(String questionText, Map<AnswerType, String> answersMap, Map<AttributeType, Double> weightMap) {
        if (answersMap.size() != ANSWERS_AMOUNT) {
            throw new IllegalArgumentException("A question must have 5 answers");
        }
        this.questionText = questionText;
        this.answersMap = answersMap;
        this.weightMap = weightMap;
        this.answer = AnswerType.NEUTRAL;
    }

    /**
     * A copy constructor
     */
    public Question(Question reference) {
        this.questionText = reference.getQuestionText();
        this.answersMap = reference.getAnswerMap();
        this.weightMap = reference.getWeightMap();
        this.answer = reference.getAnswer();
    }

    /**
     * Creates a state from the question by taking into account the AnswerType and the weights. The value of every
     * Attribute is the same as the value of the AnswerType, while the weight is determined by the Questions weight map.
     */
    public State createResultState() {
        ArrayList<Attribute> attributes = new ArrayList<>();
        // go through the weight map and create an attribute of each AttributeType in the map
        for (Map.Entry<AttributeType, Double> entry : weightMap.entrySet())
        {
            Attribute a = new Attribute(entry.getKey(), answer.getValue(), entry.getValue());
            attributes.add(a);
        }
        State result = new State(attributes);
        return result;
    }

    /**
     * Returns the question text
     */
    public String getQuestionText() {
        return this.questionText;
    }

    /**
     * Returns the map of answer texts
     * @return
     */
    public Map<AnswerType, String> getAnswerMap() {
        return answersMap;
    }

    /**
     * Returns the weight map
     * @return
     */
    public Map<AttributeType, Double> getWeightMap() {
        return weightMap;
    }

    /**
     * Returns the current answerType
     * @return
     */
    public AnswerType getAnswer() {
        return answer;
    }

    /**
     * Sets the current AnswerType
     */
    public void setAnswer(AnswerType answer) {
        this.answer = answer;
    }
}
