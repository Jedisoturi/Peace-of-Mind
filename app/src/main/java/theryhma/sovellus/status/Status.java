package theryhma.sovellus.status;

import android.util.Log;

import java.util.ArrayList;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;

/**
 * This is basically an AttributeContainer with a rule: "no duplicate attributes"
 */

public class Status {
    private ArrayList<Attribute> attributes;

    public Status(ArrayList<Attribute> attributes) {
        if (hasDuplicateAttribute(attributes)) {
            throw new IllegalArgumentException("Status cannot contain more than one attribute of each type");
        }
        this.attributes = attributes;
    }

    public Status() {
        this.attributes = new ArrayList<>();
    }

    public Status(Status reference) {
        this.attributes = reference.attributes;
    }

    public void addAttribute(Attribute attribute) {
        // todo: move the check in front of the assignment
        attributes.add(attribute);
        if (hasDuplicateAttribute(attributes)) {
            throw new IllegalArgumentException("Status cannot contain more than one attribute of each type");
        }
    }

    public void setAllAttributeValues(double value) {
        for (Attribute a : attributes) {
            a.setValue(value);
        }
    }

    public Attribute getAttribute(AttributeType type) {
        for (Attribute a : attributes) {
            if (a.getType() == type) {
                return a;
            }
        }
        throw new IllegalArgumentException("Doesn't contain this attribute");
    }

    public boolean containsAttribute(AttributeType type) {
        for (Attribute a : attributes) {
            if (a.getType() == type) {
                return true;
            }
        }
        return false;
    }

    // todo: this method is confusing in its idea
    public boolean hasDuplicateAttribute(ArrayList<Attribute> attributes) {
        ArrayList<AttributeType> typesFound = new ArrayList<>();
        for (Attribute a : attributes) {
            AttributeType type = a.getType();
            for (AttributeType foundType : typesFound) {
                if (type == foundType) {
                    return true;
                }
            }
            typesFound.add(a.getType());
        }
        return false;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    /*public void scale(double scale) {
        if (!isValidValue(scale)) {
            throw new IllegalArgumentException("Scale cannot be over 1 or under -1");
        }
        this.energy = this.energy * scale;
        this.mood = this.mood * scale;
        this.anxiety = this.anxiety * scale;
        this.stress = this.stress * scale;
    }*/

    @Override
    public String toString() {
        String s = "Status:\n";
        for (Attribute a : attributes) {
            s = s + a.toString() + "\n";
        }
        s = s + "----\n";
        return s;
    }
}
