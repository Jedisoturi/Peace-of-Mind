package theryhma.sovellus.attribute;

public enum AttributeType {
    ENERGY, MOOD, ANXIETY, STRESS;

    @Override
    public String toString() {
        switch (this) {
            case ENERGY:
                return "Energy";
            case MOOD:
                return "Mood";
            case ANXIETY:
                return "Anxiety";
            case STRESS:
                return "Stress";
            default:
                return "NULL";
        }
    }
}

