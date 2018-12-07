package theryhma.sovellus.tipoftheday;
/*
Basic class for tips
 */
public class TipOfTheDay {
    private String title;
    private String text;

    public TipOfTheDay(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public TipOfTheDay(String title) {
        this.title = title;
        this.text = "";
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
