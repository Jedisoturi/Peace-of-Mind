package theryhma.sovellus.attribute;

public class Attribute {
    private final AttributeType type;
    private double value;
    private double weight;

    public Attribute(AttributeType type, double value, double weight) {
        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Attribute value cannot be over 1 or under -1");
        }
        if (!isValidWeight(weight)) {
            throw new IllegalArgumentException("Attribute weight cannot be less than 0");
        }
        this.type = type;
        this.value = value;
        this.weight = weight;
    }

    private static boolean isValidValue(double val) {
        return 0 <= val && val <= 1;
    }
    private static boolean isValidWeight(double val) {
        return 0 <= val;
    }

    public AttributeType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public void setValue(double value) {
        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Attribute value cannot be over 1 or under -1");
        }
        this.value = value;
    }

    public void setWeight(double weight) {
        if (!isValidWeight(weight)) {
            throw new IllegalArgumentException("Attribute weight cannot be less than 0");
        }
        this.weight = weight;
    }

    @Override
    public String toString() {
        return getType() + ": " + Double.toString(value) + ", " + Double.toString(weight);
    }
}
