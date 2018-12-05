package theryhma.sovellus.status;

import android.util.Log;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;

public class StatusTools {
    public static Status createMeanStatus(ArrayList<Status> statuses) {
        /*
            Weighted Mean = Ewx / Ew
            (E is sigma: sum over a set of like terms, w is weight, x is value)
         */
        // todo: make this simpler
        // Add types to status, and calculate both the numerator and the denominator
        Status meanStatus = new Status();
        Map<AttributeType, Double> attributeNumeratorMap = new HashMap<>();
        Map<AttributeType, Double> attributeDenominatorMap = new HashMap<>();
        for (Status s : statuses) {
            for (Attribute a : s.getAttributes()) {
                if (meanStatus.containsAttribute(a.getType())) {
                    attributeNumeratorMap.put(a.getType(), attributeNumeratorMap.get(a.getType()) + (a.getValue() * a.getWeight()));
                    attributeDenominatorMap.put(a.getType(), attributeDenominatorMap.get(a.getType()) + a.getWeight());
                } else {
                    meanStatus.addAttribute(new Attribute(a.getType(), 0, 0));
                    attributeNumeratorMap.put(a.getType(), a.getValue() * a.getWeight());
                    attributeDenominatorMap.put(a.getType(), a.getWeight());
                }
            }
        }

        // Populate status values and weights
        for (Attribute a : meanStatus.getAttributes()) {
            a.setValue(attributeNumeratorMap.get(a.getType()) / attributeDenominatorMap.get(a.getType()));
            a.setWeight(attributeDenominatorMap.get(a.getType()));
        }

        return meanStatus;
    }
}
