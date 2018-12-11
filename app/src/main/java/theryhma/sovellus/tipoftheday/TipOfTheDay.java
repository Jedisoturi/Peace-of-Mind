package theryhma.sovellus.tipoftheday;
/** A simple class that contains title and text
 */
public class TipOfTheDay {
    private String title;
    private String text;

    /** Creates a new Tip Of The Day with title and text
     */
    public TipOfTheDay(String title, String text) {
        this.title = title;
        this.text = text;
    }

    /** Creates new Tip Of The Day for the tips without text
     */
    public TipOfTheDay(String title) {
        this.title = title;
        this.text = "";
    }

    /** A copy constructor
     */
    public TipOfTheDay(TipOfTheDay reference) {
        this.title = reference.getTitle();
        this.text = reference.getText();
    }

    /** Returns the title part of the Tip Of The Day
     */
    public String getTitle() {
        return this.title;
    }

    /** Returns the text part of the Tip Of The Day
     */
    public String getText() {
        return this.text;
    }

    /** Returns the title to string
     */
    @Override
    public String toString() {
        return this.title;
    }
}
