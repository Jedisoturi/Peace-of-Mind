package theryhma.sovellus.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.AttributeType;

public class QuestionConstants {
    private static final Map<String, Question> questions = new HashMap<String, Question>() {
        {
            put("pirteys", new Question("Kuinka pirteäksi koet itsesi?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Tosi");
                        put(AnswerType.POSITIVE, "Melko");
                        put(AnswerType.NEUTRAL, "Neutraali");
                        put(AnswerType.NEGATIVE, "Vähän");
                        put(AnswerType.VERY_NEGATIVE, "En yhtään");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.ENERGY, 1.0);
                    }
                })
            );
            put("mieliala", new Question("Koin mielialani tänään:",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "");
                        put(AnswerType.POSITIVE, "Melko");
                        put(AnswerType.NEUTRAL, "Neutraali");
                        put(AnswerType.NEGATIVE, "Vähän");
                        put(AnswerType.VERY_NEGATIVE, "En yhtään");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.MOOD, 1.0);
                    }
                })
            );
            put("motivaatio", new Question("Kuinka motivoitunut olo?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Tosi");
                        put(AnswerType.POSITIVE, "Melko");
                        put(AnswerType.NEUTRAL, "Neutraali");
                        put(AnswerType.NEGATIVE, "Vähän");
                        put(AnswerType.VERY_NEGATIVE, "En yhtään");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.ENERGY, 0.5);
                        put(AttributeType.MOOD, 0.5);
                    }
                })
            );
            put("syöminen", new Question("Kuinka monta ateriaa olet syönyt?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "5");
                        put(AnswerType.POSITIVE, "4");
                        put(AnswerType.NEUTRAL, "3");
                        put(AnswerType.NEGATIVE, "2");
                        put(AnswerType.VERY_NEGATIVE, "1 tai 0");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.ENERGY, 0.8);
                        put(AttributeType.MOOD, 0.8);
                        put(AttributeType.NUTRITION, 1.0);
                    }
                })
            );
            put("jotain", new Question("Jotain?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "5");
                        put(AnswerType.POSITIVE, "4");
                        put(AnswerType.NEUTRAL, "3");
                        put(AnswerType.NEGATIVE, "2");
                        put(AnswerType.VERY_NEGATIVE, "1 tai 0");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.ENERGY, 0.8);
                        put(AttributeType.MOOD, 0.8);
                        put(AttributeType.NUTRITION, 1.0);
                    }
                })
            );
        }
    };

    public static Question get(String key) {
        Question q = new Question(questions.get(key));
        return q;
    }

    public static ArrayList<Question> createArray() {
        ArrayList<Question> array = new ArrayList<>();
        for (Map.Entry<String, Question> entry : questions.entrySet())
        {
            array.add(entry.getValue());
        }
        return array;
    }

    public static int size() {
        return questions.size();
    }

}
