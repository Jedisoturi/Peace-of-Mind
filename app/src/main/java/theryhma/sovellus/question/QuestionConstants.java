package theryhma.sovellus.question;

import java.util.ArrayList;
import java.util.HashMap;

import theryhma.sovellus.attribute.AttributeType;

public class QuestionConstants {
    private static final ArrayList<Question> questions = new ArrayList<Question>() {
        {
            add(new Question("Kuinka pirteäksi koit itsesi?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Todella ");
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
            add(new Question("Koin mielialani tänään...",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Erinomaiseksi");
                        put(AnswerType.POSITIVE, "Hyväksi");
                        put(AnswerType.NEUTRAL, "Neutraaliksi");
                        put(AnswerType.NEGATIVE, "Heikoksi");
                        put(AnswerType.VERY_NEGATIVE, "Huonoksi");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.MOOD, 1.0);
                    }
                })
            );
            add(new Question("Kuinka motiivoituneeksi olo?",
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
            add(new Question("Kuinka monta ateriaa olet syönyt?",
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
            add(new Question("Oliko unenlaatusi mielestäsi...",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Erinomainen");
                        put(AnswerType.POSITIVE, "Hyvä");
                        put(AnswerType.NEUTRAL, "Tyydyttävä");
                        put(AnswerType.NEGATIVE, "Heikko");
                        put(AnswerType.VERY_NEGATIVE, "Huono");
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

    public static Question get(int i) {
        return questions.get(i);
    }

    public static int size() {
        return questions.size();
    }

}
