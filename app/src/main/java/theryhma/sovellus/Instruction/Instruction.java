package theryhma.sovellus.Instruction;

import theryhma.sovellus.attribute.AttributeType;

public class Instruction {
    private String text;
    private AttributeType attributeType;
    private double minValue;
    private double maxValue;

    public Instruction(String text, AttributeType attributeType, double minValue, double maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("Instruction maxValue cannot be less than minValue");
        }
        this.text = text;
        this.attributeType = attributeType;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getText() {
        return text;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public boolean isInRange(double value) {
        return minValue <= value && value <= maxValue;
    }
}
