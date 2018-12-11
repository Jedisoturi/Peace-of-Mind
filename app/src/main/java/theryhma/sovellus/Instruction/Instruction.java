package theryhma.sovellus.Instruction;

import theryhma.sovellus.attribute.AttributeType;

/** This classes purpose is to set the constructor "Instruction" and it's parameters.
 * This class also includes methods, that return constructors parameters.
 */
public class Instruction {
    private String title;
    private String text;
    private AttributeType attributeType;
    private double minValue;
    private double maxValue;

    /** Creates a new Instructor*/
    public Instruction(String title, String text, AttributeType attributeType, double minValue, double maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("Instruction maxValue cannot be less than minValue");
        }
        this.text = text;
        this.attributeType = attributeType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.title = title;
    }

    /** This constructor copies the Instruction given as a parameter*/

    public Instruction(Instruction reference) {
        this.text = reference.text;
        this.attributeType = reference.attributeType;
        this.minValue = reference.minValue;
        this.maxValue = reference.maxValue;
        this.title = reference.title;
    }

    /** This method returns the title of the given Instruction*/
    public String getTitle() {
        return title;
    }

    /** This method returns the text of the given Instruction*/
    public String getText() {
        return text;
    }

    /** This method returns the attribute type of the given Instruction*/
    public AttributeType getAttributeType() {
        return attributeType;
    }

    /** This method checks whether the given value is in range or not*/
    public boolean isInRange(double value) {
        return minValue <= value && value <= maxValue;
    }

    /** This toString methos return the title of the given Instruction*/
   @Override
    public String toString (){
        return getTitle();
    }
}
