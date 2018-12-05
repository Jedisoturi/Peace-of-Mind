package theryhma.sovellus.Instruction;

import java.util.ArrayList;

import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.status.Status;

public class InstructionTools {
    public static ArrayList<Instruction> createPossibleInstructions(Status status) {
        ArrayList<Instruction> instructions = InstructionConstants.createArrayList();
        ArrayList<Instruction> result = new ArrayList<>();
        for (Instruction i : instructions) {
            AttributeType type = i.getAttributeType();
            if (status.containsAttribute(type)) {
                double value = status.getAttribute(type).getValue();
                if (i.isInRange(value)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    /*public static ArrayList<Instruction> generateRandomInstructions(Status status) {
        ArrayList<Instruction> list = createPossibleInstructions(status);
        ArrayList<Instruction> reference = new ArrayList<>();
        for (Instruction i : list) {

        }
    }*/

    public static String instructionArrayToString(ArrayList<Instruction> instructions) {
        String result = "Instructions:\n";
        for (Instruction i : instructions) {
            result = result + i.getText() + "\n";
        }
        result = result + "----\n";
        return result;
    }
}
