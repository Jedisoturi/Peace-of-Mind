package theryhma.sovellus.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.AttributeType;

public class QuestionConstants {
    private static final Map<String, Question> questions = new HashMap<String, Question>() {
        {
            put("pirteys", new Question("Kuinka pirteäksi koit itsesi tänään?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Todella");
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
                        put(AnswerType.VERY_POSITIVE, "Erinomaiseksi");
                        put(AnswerType.POSITIVE, "Hyväksi");
                        put(AnswerType.NEUTRAL, "Neutraali");
                        put(AnswerType.NEGATIVE, "Heikoksi");
                        put(AnswerType.VERY_NEGATIVE, "Huonoksi");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.MOOD, 1.0);
                    }
                })
            );
            put("motivaatio", new Question("Kuinka motivoituneeksi tunsit itsesi tänään?",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Todella");
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
            put("rentoutuminen", new Question("Oletko pystynyt rentoutumaan tänään?",
                            new HashMap<AnswerType, String>() {
                                {
                                    put(AnswerType.VERY_POSITIVE, "Paljon");
                                    put(AnswerType.POSITIVE, "Riittävästi");
                                    put(AnswerType.NEUTRAL, "Vähän");
                                    put(AnswerType.NEGATIVE, "En juurikaan");
                                    put(AnswerType.VERY_NEGATIVE, "En lainkaan");
                                }
                            }, new HashMap<AttributeType, Double>() {
                        {
                            put(AttributeType.ENERGY, 0.4);
                            put(AttributeType.MOOD, 0.25);
                            put(AttributeType.UNSTRESS, 1.0);
                        }
                    })
            );
            put("alkoholi", new Question("Oletko nauttinut alkoholia tänään?",
                            new HashMap<AnswerType, String>() {
                                {
                                    put(AnswerType.VERY_POSITIVE, "Paljon");
                                    put(AnswerType.POSITIVE, "Huomattavasti");
                                    put(AnswerType.NEUTRAL, "Muutaman");
                                    put(AnswerType.NEGATIVE, "Yhden annoksen");
                                    put(AnswerType.VERY_NEGATIVE, "En yhtään");
                                }
                            }, new HashMap<AttributeType, Double>() {
                        {
                            put(AttributeType.ENERGY, 0.25);
                            put(AttributeType.MOOD, 0.25);
                            put(AttributeType.UNSTRESS, 0.25);
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
                        put(AttributeType.ENERGY, 1.0);
                        put(AttributeType.MOOD, 0.75);
                        put(AttributeType.NUTRITION, 1.0);
                    }
                })
            );
            put("liikunta", new Question("Oletko liikkunut tänään...",
                new HashMap<AnswerType, String>() {
                    {
                        put(AnswerType.VERY_POSITIVE, "Paljon");
                        put(AnswerType.POSITIVE, "Melko paljon");
                        put(AnswerType.NEUTRAL, "Jonkin verran");
                        put(AnswerType.NEGATIVE, "Vähän");
                        put(AnswerType.VERY_NEGATIVE, "En yhtään");
                    }
                }, new HashMap<AttributeType, Double>(){
                {
                    put(AttributeType.ENERGY, 1.0);

                }
            })
            );
            put("unenlaatu", new Question("Oliko unenlaatusi mielestäsi...",
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
                        put(AttributeType.ENERGY, 1.0);
                        put(AttributeType.MOOD, 0.5);
                        put(AttributeType.UNSTRESS, 0.4);
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
