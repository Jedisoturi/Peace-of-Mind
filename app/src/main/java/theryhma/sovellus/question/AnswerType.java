package theryhma.sovellus.question;

/**
 * Contains all the answer types and values for the questions.
 */
public enum AnswerType {
    NEUTRAL, POSITIVE, NEGATIVE, VERY_POSITIVE, VERY_NEGATIVE;

    private static final double VERY_POSITIVE_VALUE = 1;
    private static final double POSITIVE_VALUE = 0.75;
    private static final double NEUTRAL_VALUE = 0.5;
    private static final double NEGATIVE_VALUE = 0.25;
    private static final double VERY_NEGATIVE_VALUE = 0;

    /**
     * Returns the constant value of an answer
     */
    public double getValue() {
        switch (this) {
            case VERY_POSITIVE:
                return VERY_POSITIVE_VALUE;
            case POSITIVE:
                return POSITIVE_VALUE;
            case NEUTRAL:
                return NEUTRAL_VALUE;
            case NEGATIVE:
                return NEGATIVE_VALUE;
            case VERY_NEGATIVE:
                return VERY_NEGATIVE_VALUE;
            default:
                return NEUTRAL_VALUE;
        }
    }
}
