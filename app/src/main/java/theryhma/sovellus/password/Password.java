package theryhma.sovellus.password;

public class Password {
    private boolean active;
    private String password;

    public Password() {
        active = false;
        password = "";
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public void set(String word) {
        this.password = word;
    }

    public String get() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
}
