package theryhma.sovellus.question;

public enum Answer {
    NEUTRAL, BAD, WORST, GOOD, BEST;

    @Override
    public String toString() {
        switch (this) {
            case BEST:
                return "BEST";
            case GOOD:
                return "GOOD";
            case NEUTRAL:
                return "NEUTRAL";
            case BAD:
                return "BAD";
            case WORST:
                return "WORST";
            default:
                return "NULL";
        }
    }
}
