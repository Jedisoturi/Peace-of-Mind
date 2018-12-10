package theryhma.sovellus.Instruction;

import theryhma.sovellus.attribute.AttributeType;

public class Instruction {
    private String text;
    private AttributeType attributeType;
    private double minValue;
    private double maxValue;

    /** Sets Instruction's parameters */
    public Instruction(String text, AttributeType attributeType, double minValue, double maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("Instruction maxValue cannot be less than minValue");
        }
        this.text = text;
        this.attributeType = attributeType;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**Copies and creates a new Instruction of the given one */
    public Instruction(Instruction reference) {
        this.text = reference.text;
        this.attributeType = reference.attributeType;
        this.minValue = reference.minValue;
        this.maxValue = reference.maxValue;
    }
    /**Returns text */
    public String getText() {
        return text;
    }

    /** Gets attribute type */
    public AttributeType getAttributeType() {
        return attributeType;
    }

    /** Checks if value is in range or not */
    public boolean isInRange(double value) {
        return minValue <= value && value <= maxValue;
    }
}
