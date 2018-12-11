package theryhma.sovellus.password;

/**
 * This class is for the user to set a password for the app
 */
public class Password {
    private boolean active;
    private String password;

    public Password() {
        active = false;
        password = "";
    }

    /** Activates the password
     */
    public void activate() {
        active = true;
    }

    /** Deactivates the password
     */
    public void deactivate() {
        active = false;
    }

    /** Sets password
     */
    public void set(String word) {
        this.password = word;
    }

    /** Returns the word
     */
    public String get() {
        return password;
    }

    /** Retruns true if password in use, and false if not
     */
    public boolean isActive() {
        return active;
    }
}
