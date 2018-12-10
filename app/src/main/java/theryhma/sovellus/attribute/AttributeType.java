package theryhma.sovellus.attribute;

public enum AttributeType {
    ENERGY, MOOD, ANXIETY, UNSTRESS, NUTRITION;

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



