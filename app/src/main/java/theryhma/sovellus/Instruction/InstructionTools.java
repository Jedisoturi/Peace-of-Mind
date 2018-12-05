package theryhma.sovellus.Instruction;

import java.util.ArrayList;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.tools.Maths;

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

    public static ArrayList<Instruction> createInstructionsOfType(ArrayList<Instruction> reference, AttributeType type) {
        ArrayList<Instruction> result = new ArrayList<>();
        for (Instruction i : reference) {
            if (i.getAttributeType() == type) {
                result.add(i);
            }
        }
        return result;
    }

    public static Instruction getRandomInstruction(ArrayList<Instruction> instructions) {
        Instruction i = instructions.get(Maths.getRandomIntegerBetweenRange(0, instructions.size() - 1));
        return i;
    }

    public static ArrayList<Instruction> generateRandomInstructions(Status status) {
        ArrayList<Instruction> reference = createPossibleInstructions(status);
        ArrayList<Instruction> result = new ArrayList<>();
        for (Attribute a : status.getAttributes()) {
            if (containsAttributeType(reference, a.getType())) {
                ArrayList<Instruction> dummy = createInstructionsOfType(reference, a.getType());
                Instruction i = getRandomInstruction(dummy);
                result.add(i);
            }
        }
        return result;
    }

    public static boolean containsAttributeType(ArrayList<Instruction> instructions, AttributeType type) {
        for (Instruction i : instructions) {
            if (i.getAttributeType() == type) {
                return true;
            }
        }
        return false;
    }

    public static String instructionArrayToString(ArrayList<Instruction> instructions) {
        String result = "Instructions:\n";
        for (Instruction i : instructions) {
            result = result + i.getText() + "\n";
        }
        result = result + "----\n";
        return result;
    }
}
