package theryhma.sovellus.attribute;

/** This class defines the attributes which has to have a type, value and weight.
 * Attribute class is basically a mental health attribute with a weight value which is used in the State class.
 */
public class Attribute {
    private final AttributeType type;
    private double value;
    private double weight;

    /** Creates an Attribute which has been given a value, type and weight
     */
    public Attribute(AttributeType type, double value, double weight) {
        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Attribute value cannot be over 1 or under 0");
        }
        if (!isValidWeight(weight)) {
            throw new IllegalArgumentException("Attribute weight cannot be less than 0");
        }
        this.type = type;
        this.value = value;
        this.weight = weight;
    }

    /** Returns true or false
     */
    private boolean isValidValue(double val) {
        return 0 <= val && val <= 1;
    }
    /** Returns true or false
     */
    private static boolean isValidWeight(double val) {
        return 0 <= val;
    }

    /** Returns attributes type
     */
    public AttributeType getType() {
        return type;
    }

    /** Returns the value
     */
    public double getValue() {
        return value;
    }

    /** Returns the weight
     */
    public double getWeight() {
        return weight;
    }

    /** Sets attributes value
     */
    public void setValue(double value) {
        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Attribute value cannot be over 1 or under 0");
        }
        this.value = value;
    }

    /** Sets attributes weight
     */
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
