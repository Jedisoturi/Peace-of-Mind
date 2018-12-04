package theryhma.sovellus.status;

import java.util.ArrayList;

public class QuestionContainer {
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
                }, new Status(1, 0, 0, 0))
            );
            add(new Question("Koin mielialani tänään:", new ArrayList<String>() {
                        {
                            add("Tosi iloiseksi");
                            add("iloiseksi");
                            add("neutraaliksi");
                            add("surulliseksi");
                            add("masentuneeksi");
                        }
                    }, new Status(0, 1, 0, 0))
            );
            add(new Question("Kuinka motivoitunut olo?", new ArrayList<String>() {
                        {
                            add("Todella motivoitunut");
                            add("Motivoitunut");
                            add("Neutraali");
                            add("Epämotivoitunut");
                            add("Mikään ei kiinnosta");
                        }
                    }, new Status(0.6, 0.6, 0, 0))
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
