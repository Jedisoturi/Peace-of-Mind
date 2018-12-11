package theryhma.sovellus.attribute;

/** Creates enum class for attribute types
 */
public enum AttributeType {
    ENERGY, MOOD, ANXIETY, UNSTRESS, NUTRITION;

    /** Returns a Finnish string for a given attribute type
     */
        public String toFinnish(){
            switch (this) {
                case ENERGY:
                    return "Energia";
                case NUTRITION:
                    return "Ravinto";
                case MOOD:
                    return "Mieliala";
                case UNSTRESS:
                    return "Stressittömyys";
                case ANXIETY:
                    return "Ahdistuneisuus";
                default:
                    return null;
            }
        }
}



