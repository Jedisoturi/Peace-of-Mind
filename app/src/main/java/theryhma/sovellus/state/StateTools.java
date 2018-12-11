package theryhma.sovellus.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;

/**
 * Some creators for the State class, and possibly other methods that aren't linked to a single State object.
 */
public class StateTools {
    /**
     * Creates a weighted mean State from a list of States. It basically calculates a weighted mean Attribute for
     * each AttributeType. Moreover the new weight of the new Attribute is the sum of all the weights of its type.
     *
     * This is static because it makes no sense to make this a object method as its argument
     * is a list of States not just one State, and it creates a new state and doesn't modify one.
     *
     * Weighted Mean = Ewx / Ew
     * (E is sigma: sum over a set of like terms, w is weight, x is value)
     * 1. It creates two maps that both have AttributeType as key and double as value:
     *      -Numerator (Ewx): contains the numerator of the weighted mean for a given AttributeType
     *      -Denominator (Ew): contains the denominator of the weighted mean for a given AttributeType
     * 2. It goes through each Status' Attributes and adds the Attribute's:
     *      -Numerator (wx): product of it's weight and value
     *      -Denominator (w): it's weight
     * 3. It calculates the resulting Attribute value for each AttributeType by dividing the numerator of a given AttributeType
     * with the denominator of that AttributeType
     * 4. The weight of each Attribute is set to be the same it AttributeType's denominator (Ew)
     */
    public static State createMeanState(ArrayList<State> states) {
        State meanState = new State();  // create the mean State already as it's used in calculations
        // see 1: create both maps
        Map<AttributeType, Double> numeratorsMap = new HashMap<>();
        Map<AttributeType, Double> denominatorMap = new HashMap<>();
        // see 2: calculate each AttributeType's numerator and denominator
        for (State s : states) {
            for (Attribute a : s.getAttributes()) {
                AttributeType type = a.getType();
                double x = a.getValue();
                double w = a.getWeight();
                if (!meanState.containsAttribute(type)) {    // if mean State contains this attribute
                    meanState.addAttribute(new Attribute(type, 0, 0));   // add attribute to mean state
                    // set the initial value of both the AttributeType's numerator and denominator
                    numeratorsMap.put(type, x * w);
                    denominatorMap.put(type, w);
                } else {
                    double numeratorValue = numeratorsMap.get(type);
                    double denominatorValue = denominatorMap.get(type);
                    // we just add to both the numerator and denominator values of each AttributeType
                    numeratorsMap.put(type, numeratorValue + (x * w));
                    denominatorMap.put(type, denominatorValue + w);
                }
            }
        }

        // see 3 and 4: both the value and weight of each attribute in mean State is set
        for (Attribute a : meanState.getAttributes()) {
            AttributeType type = a.getType();
            double numeratorValue = numeratorsMap.get(type);
            double denominatorValue = denominatorMap.get(type);
            a.setValue(numeratorValue / denominatorValue);
            a.setWeight(denominatorValue);
        }

        return meanState;
    }
}
