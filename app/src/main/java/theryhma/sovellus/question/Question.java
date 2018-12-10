package theryhma.sovellus.question;

import java.util.ArrayList;
import java.util.Map;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.state.State;

public class Question {
    private String questionText;
    private Map<AnswerType, String> answersMap;
    private Map<AttributeType, Double> weightMap;
    private AnswerType answer;

    private static final int ANSWERS_AMOUNT = 5;

    public Question(String questionText, Map<AnswerType, String> answersMap, Map<AttributeType, Double> weightMap) {
        if (answersMap.size() != ANSWERS_AMOUNT) {
            throw new IllegalArgumentException("A question must have 5 answers");
        }
        // todo: check that weights are correct
        // remember that maps don't have duplicate keys
        this.questionText = questionText;
        this.answersMap = answersMap;
        this.weightMap = weightMap;
        this.answer = AnswerType.NEUTRAL;
        //Log.d("supergetstatus", "CREATE: " + getText() + " " + getAnswer() + " answerType:" + answerType + " status:" + this.weights);
    }

    public Question(Question reference) {
        this.questionText = reference.getQuestionText();
        this.answersMap = reference.getAnswerMap();
        this.weightMap = reference.getWeightMap();
        this.answer = reference.getAnswer();
    }

    public State createResultState() {
        ArrayList<Attribute> attributes = new ArrayList<>();
        for (Map.Entry<AttributeType, Double> entry : weightMap.entrySet())
        {
            Attribute a = new Attribute(entry.getKey(), AnswerType.getValue(answer), entry.getValue());
            attributes.add(a);
        }
        State result = new State(attributes);
        return result;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public Map<AnswerType, String> getAnswerMap() {
        return answersMap;
    }

    public Map<AttributeType, Double> getWeightMap() {
        return weightMap;
    }

    public AnswerType getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerType answer) {
        this.answer = answer;
    }
}
