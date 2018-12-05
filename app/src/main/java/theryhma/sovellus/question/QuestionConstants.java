package theryhma.sovellus.question;

import java.util.ArrayList;

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
                }, new Status())
            );
            add(new Question("Koin mielialani tänään:", new ArrayList<String>() {
                        {
                            add("Tosi iloiseksi");
                            add("iloiseksi");
                            add("neutraaliksi");
                            add("surulliseksi");
                            add("masentuneeksi");
                        }
                    }, new Status())
            );
            add(new Question("Kuinka motivoitunut olo?", new ArrayList<String>() {
                        {
                            add("Todella motivoitunut");
                            add("Motivoitunut");
                            add("Neutraali");
                            add("Epämotivoitunut");
                            add("Mikään ei kiinnosta");
                        }
                    }, new Status())
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
