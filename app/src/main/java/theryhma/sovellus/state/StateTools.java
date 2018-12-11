package theryhma.sovellus.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;

public class StateTools {
    public static State createMeanState(ArrayList<State> states) {
        /*
            Weighted Mean = Ewx / Ew
            (E is sigma: sum over a set of like terms, w is weight, x is value)
         */
        // Add types to status, and calculate both the numerator and the denominator
        // todo make simpler
        State meanState = new State();
        Map<AttributeType, Double> attributeNumeratorMap = new HashMap<>();
        Map<AttributeType, Double> attributeDenominatorMap = new HashMap<>();
        for (State s : states) {
            for (Attribute a : s.getAttributes()) {
                if (meanState.containsAttribute(a.getType())) {
                    attributeNumeratorMap.put(a.getType(), attributeNumeratorMap.get(a.getType()) + (a.getValue() * a.getWeight()));
                    attributeDenominatorMap.put(a.getType(), attributeDenominatorMap.get(a.getType()) + a.getWeight());
                } else {
                    meanState.addAttribute(new Attribute(a.getType(), 0, 0));
                    attributeNumeratorMap.put(a.getType(), a.getValue() * a.getWeight());
                    attributeDenominatorMap.put(a.getType(), a.getWeight());
                }
            }
        }

        // Populate status values and weights
        for (Attribute a : meanState.getAttributes()) {
            a.setValue(attributeNumeratorMap.get(a.getType()) / attributeDenominatorMap.get(a.getType()));
            a.setWeight(attributeDenominatorMap.get(a.getType()));
        }

        return meanState;
    }
}
