package theryhma.sovellus.attribute;

public class Attribute {
    private AttributeType type;
    private double value;
    public Attribute(AttributeType type, double value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Status values cannot be over 1 or under -1");
        }
        this.type = type;
        this.value = value;
    }

    private static boolean isValid(double val) {
        return -1 <= val && val <= 1;
    }

    public AttributeType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Status values cannot be over 1 or under -1");
        }
        this.value = value;
    }
}
