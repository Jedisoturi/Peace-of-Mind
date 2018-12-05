package theryhma.sovellus.question;

import java.util.ArrayList;
import java.util.HashMap;

import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.status.Status;

public class QuestionConstants {
    private static final ArrayList<Question> questions = new ArrayList<Question>() {
        {
            add(new Question("Kuinka väsyneeksi koet itsesi?", new ArrayList<String>() {
                    {
                        add("TOSI ENERGINEN!");
                        add("Olen melko pirteä.");
                        add("Normaali.");
                        add("Väsyttää jonkin verran.");
                        add("Väsynyt kuin nukkuneen rukous.");
                    }
                }, new HashMap<AttributeType, Double>() {
                    {
                        put(AttributeType.ENERGY, 1.0);

                    }
                })
            );
            add(new Question("Koin mielialani tänään:", new ArrayList<String>() {
                        {
                            add("Tosi iloiseksi");
                            add("iloiseksi");
                            add("neutraaliksi");
                            add("surulliseksi");
                            add("masentuneeksi");
                        }
                    }, new HashMap<AttributeType, Double>() {
                        {
                            put(AttributeType.MOOD, 1.0);

                        }
                    })
            );
            add(new Question("Kuinka motivoitunut olo?", new ArrayList<String>() {
                        {
                            add("Todella motivoitunut");
                            add("Motivoitunut");
                            add("Neutraali");
                            add("Epämotivoitunut");
                            add("Mikään ei kiinnosta");
                        }
                    }, new HashMap<AttributeType, Double>() {
                        {
                            put(AttributeType.ENERGY, 0.5);
                            put(AttributeType.MOOD, 0.5);
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
