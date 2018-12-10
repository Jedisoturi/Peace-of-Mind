package theryhma.sovellus.Instruction;

import java.util.ArrayList;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.state.State;
import theryhma.sovellus.tools.Maths;

// todo: please remove
public class InstructionTools {
    public static ArrayList<Instruction> createPossibleInstructions(State state) {
        ArrayList<Instruction> instructions = InstructionConstants.createArrayList();
        ArrayList<Instruction> result = new ArrayList<>();
        for (Instruction i : instructions) {
            AttributeType type = i.getAttributeType();
            if (state.containsAttribute(type)) {
                double value = state.getAttribute(type).getValue();
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

    /**Get random instruction */
    public static Instruction getRandomInstruction(ArrayList<Instruction> instructions) {
        Instruction i = instructions.get(Maths.getRandomIntegerBetweenRange(0, instructions.size() - 1));
        return i;
    }

    public static ArrayList<Instruction> generateRandomInstructions(State state) {
        ArrayList<Instruction> reference = createPossibleInstructions(state);
        ArrayList<Instruction> result = new ArrayList<>();
        for (Attribute a : state.getAttributes()) {
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
        String result = "InstructionContainer:\n";
        for (Instruction i : instructions) {
            result = result + i.getText() + "\n";
        }
        result = result + "----\n";
        return result;
    }
}
